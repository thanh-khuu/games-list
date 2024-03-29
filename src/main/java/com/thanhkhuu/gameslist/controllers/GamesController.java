package com.thanhkhuu.gameslist.controllers;

import com.thanhkhuu.gameslist.models.Game;
import com.thanhkhuu.gameslist.models.GamePlatform;
import com.thanhkhuu.gameslist.models.data.GameDao;
import com.thanhkhuu.gameslist.models.data.GamePlatformDao;
import com.thanhkhuu.gameslist.models.data.GenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//request path is starts at /games

@Controller
@RequestMapping("games")
public class GamesController {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private GamePlatformDao platformDao;

    @Autowired
    private GenreDao genreDao;

    //shows list of games currently present
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("gamesList", gameDao.findAll());
        model.addAttribute("title", "My Games");
        return "games/index";
    }

    //shows (displays) form to add games to gamesList
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddGamesForm(Model model) {
        model.addAttribute("title", "Add Game");
        model.addAttribute(new Game());
        model.addAttribute("gamePlatforms", platformDao.findAll());
        return "games/add";
    }

    //processes data received from form to add games to gamesList
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddGamesForm(@ModelAttribute @Valid Game newGame,
                                      Errors errors, @RequestParam int platformId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Game");
            model.addAttribute("platforms", platformDao.findAll());
            return "games/add";
        }

        //above is model-binding Game Object with attributes

        /* Behind The Scenes
        *
        * Game newGame = new Game();
        * newGame.setName(Request.getParameter("name"))   something like this;
        * newGame.setDescription(Request.getParameter("description"));
        *
        * */

        //add that new "Game" object into the gamesList ArrayList

        GamePlatform gamePlatform = platformDao.findOne(platformId);
        newGame.setPlatform(gamePlatform);
        gameDao.save(newGame);

        // Redirect to /games
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveGameForm(Model model) {
        model.addAttribute("games", gameDao.findAll());
        model.addAttribute("title", "Remove Game");
        return "games/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveGameForm(@RequestParam int[] gameIds) {


        for (int gameId : gameIds) {
            gameDao.delete(gameId);
        }
        return "redirect:";
    }

    //edit already-entered games
    /*public String displayEditForm(Model model, @PathVariable int gameId) {

    }

    public String processEditForm(int gameId, String name, String description) {

    }*/

    @RequestMapping(value = "platforms", method = RequestMethod.GET)
    public String platform (Model model, @RequestParam int id) {
        GamePlatform platform = platformDao.findOne(id);
        List<Game> games = platform.getGames();
        model.addAttribute("games", games);
        model.addAttribute("title", "Games on the " + platform.getName());
        return "games/index";
    }

}