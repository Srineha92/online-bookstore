package org.finalproject.bookstorefinal.repository;

import org.finalproject.bookstorefinal.Account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//We create the UserRepository by extending the JpaRepository interface.
// This is a Spring Data interface and gives us all the CRUD operations
// automatically.

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}