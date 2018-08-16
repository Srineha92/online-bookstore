package org.finalproject.bookstorefinal.repository;

import org.finalproject.bookstorefinal.Account.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {


}
