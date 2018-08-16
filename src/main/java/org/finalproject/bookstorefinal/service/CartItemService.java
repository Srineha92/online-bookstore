package org.finalproject.bookstorefinal.service;

import org.finalproject.bookstorefinal.Account.Book;
import org.finalproject.bookstorefinal.Account.CartItem;
import org.finalproject.bookstorefinal.Account.ShoppingCart;
import org.finalproject.bookstorefinal.Account.User;

import java.util.List;

public interface CartItemService {
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    CartItem updateCartItem(CartItem cartItem);

    CartItem addBookToCartItem(Book book, User user, int qty);

    void  removeItem(Long id);

}
