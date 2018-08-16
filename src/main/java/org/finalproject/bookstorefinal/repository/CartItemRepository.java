package org.finalproject.bookstorefinal.repository;

import org.finalproject.bookstorefinal.Account.CartItem;
import org.finalproject.bookstorefinal.Account.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
}
