package org.finalproject.bookstorefinal.service;

import org.finalproject.bookstorefinal.Account.Book;

import java.util.List;
import java.util.Optional;


public interface BookService {

    Book save(Book book);

    List<Book> findAll();


    Optional<Book> findById(Long id);

}
