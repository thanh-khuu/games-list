package com.thanhkhuu.gameslist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

//request path is starts at /games

@Controller
@RequestMapping("games")
public class GamesController {

    static ArrayList<String> gamesList = new ArrayList<>();

    //shows list of games currently present
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("gamesList", gamesList);
        model.addAttribute("title", "My Games");
        return "games/index";
    }

    //shows (displays) form to add games to gamesList
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddGamesForm(Model model) {
        model.addAttribute("title", "Add Game");
        return "games/add";
    }

    //processes data received from form to add games to gamesList
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddGamesForm(@RequestParam String gameName) {
        gamesList.add(gameName);

        // Redirect to /games
        return "redirect:";
    }

}
