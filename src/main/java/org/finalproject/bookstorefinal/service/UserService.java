package org.finalproject.bookstorefinal.service;

import org.finalproject.bookstorefinal.Account.User;
import org.finalproject.bookstorefinal.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}