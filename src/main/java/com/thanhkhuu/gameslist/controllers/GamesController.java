package com.thanhkhuu.gameslist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//request path is starts at /games

@Controller
@RequestMapping("games")
public class GamesController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "My Games");
        return "games/index";
    }

}
