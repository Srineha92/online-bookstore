package org.finalproject.bookstorefinal.Controller;

import org.finalproject.bookstorefinal.Account.Book;
import org.finalproject.bookstorefinal.Account.CartItem;
import org.finalproject.bookstorefinal.Account.ShoppingCart;
import org.finalproject.bookstorefinal.Account.User;
import org.finalproject.bookstorefinal.service.BookService;
import org.finalproject.bookstorefinal.service.CartItemService;
import org.finalproject.bookstorefinal.service.ShoppingCartService;
import org.finalproject.bookstorefinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private BookService bookService;

    @Autowired
    private MainController mainController;

    @RequestMapping(value = "/cart")
    public String shoppingCart(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("shoppingCart", shoppingCart);

        return "shoppingCart";
    }

    @PostMapping(value = "/addItem")
    public String addItem(
            @ModelAttribute("book") Book book,
            @ModelAttribute("qty") String qty,
            Model model, Principal principal
    ) {
        User user = userService.findByEmail(principal.getName());

       Optional<Book> test = bookService.findById(book.getId());

        Book book1 = test.get();

        CartItem cartItem = cartItemService.addBookToCartItem(book, user, Integer.parseInt(qty));
        model.addAttribute("addBookSuccess", true);

        return mainController.bookDetail(book1.getId(), model, principal);
    }

    @PostMapping("/removeItem/{id}")
    public String removeItem(
            @PathVariable("id") Long cartItemId,
            Model model, Principal principal){

         cartItemService.removeItem(cartItemId);
         return shoppingCart(model, principal);
    }

}
