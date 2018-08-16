package org.finalproject.bookstorefinal.repository;

import org.finalproject.bookstorefinal.Account.BookToCartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {

}
