package com.thanhkhuu.gameslist.controllers;

import com.thanhkhuu.gameslist.models.User;
import com.thanhkhuu.gameslist.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Sign In");
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add (Model model) {
        model.addAttribute("title", "Sign Up");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add (Model model, @ModelAttribute User user, String verify) {

        if (user.getPassword() != null && user.getPassword().equals(verify)) {
            model.addAttribute("name", user.getUsername());
            return "user/index";
        }

        model.addAttribute("title", "Sign Up");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("error", "Passwords must match to continue");

        return "user/add";
    }
}
