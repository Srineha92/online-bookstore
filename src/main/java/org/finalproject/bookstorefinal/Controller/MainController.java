package org.finalproject.bookstorefinal.Controller;

import org.finalproject.bookstorefinal.Account.Book;
import org.finalproject.bookstorefinal.Account.User;
import org.finalproject.bookstorefinal.service.BookService;
import org.finalproject.bookstorefinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// this is a simple controller

@Controller
public class MainController {


    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping("/bookshelf")
    public String bookshelf(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "bookshelf";
    }

    @RequestMapping(value ="/bookDetail", method = RequestMethod.GET)
    public String bookDetail(
            @PathParam("id") Long id, Model model, Principal principal) {
        if(principal != null) {
            String email = principal.getName();
            User user = userService.findByEmail(email);
            model.addAttribute("user", user);
        }

        Optional<Book> book = bookService.findById(id);

        Book book1 = book.get();

        model.addAttribute("book",book1);

        List<Integer> qtyList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        model.addAttribute("qtyList", qtyList);
        model.addAttribute("qty", 1);

        return "bookDetail";
    }
}