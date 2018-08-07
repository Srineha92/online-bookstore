package org.finalproject.bookstorefinal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// this is a simple controller

@Controller
public class MainController {

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
}