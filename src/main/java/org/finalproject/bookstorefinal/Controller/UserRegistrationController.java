package org.finalproject.bookstorefinal.Controller;

//this controller is mapped to /registered URI

import org.finalproject.bookstorefinal.Account.User;
import org.finalproject.bookstorefinal.UserRegistrationDto;
import org.finalproject.bookstorefinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;
// we use the UserRegistrationDto to process and validate the user regiatration
    //form and inject it using the @ModelAttribute("user") annotation.
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }
// When the form is submitted it’s automatically validated and errors are available in the BindingResult.
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        // we check if user does'nt already exist with the submitted email.
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
// if form has any errors , we return to the registration page.
        if (result.hasErrors()){
            return "registration";
        }
// or else we redirect and inform the user the registration procedure is complete.
        userService.save(userDto);
        return "redirect:/registration?success";
    }

}
