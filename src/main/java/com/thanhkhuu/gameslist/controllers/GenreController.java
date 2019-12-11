package com.thanhkhuu.gameslist.controllers;


import com.thanhkhuu.gameslist.models.Game;
import com.thanhkhuu.gameslist.models.Genre;
import com.thanhkhuu.gameslist.models.data.GameDao;
import com.thanhkhuu.gameslist.models.data.GenreDao;
import com.thanhkhuu.gameslist.models.forms.AddGenreTitleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("genre")
public class GenreController {

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private GameDao gameDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Genres");
        model.addAttribute("genres", genreDao.findAll());
        return "genre/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddGenreForm(Model model) {
        model.addAttribute("title", "Add Menus");
        model.addAttribute(new Genre());
        return "genre/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddGenreForm(Model model, @ModelAttribute @Valid Genre genre, Errors errors) {
        model.addAttribute(genre);
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menus");
            return "genre/add";
        }
        genreDao.save(genre);
        return "redirect:view/" + genre.getId();
    }

    @RequestMapping(value = "view/{genreId}", method = RequestMethod.GET)
    public String viewGenre(Model model, @PathVariable int genreId) {
        Genre genre = genreDao.findOne(genreId);
        model.addAttribute(genre);
        return "genre/view";
    }

    @RequestMapping(value = "add-item/{genreId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int genreId) {
        Genre genre = genreDao.findOne(genreId);
        AddGenreTitleForm form = new AddGenreTitleForm(
                gameDao.findAll(),
                genre);
        model.addAttribute("title", "Add Game Titles to the " + genre.getName() + " Genre");
        model.addAttribute("form", form);
        return "genre/add-item";
    }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddGenreTitleForm form, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "menu/add-item";
        }
        Game thisGame = gameDao.findOne(form.getGameId());
        Genre thisGenre = genreDao.findOne(form.getGenreId());
        thisGenre.addItem(thisGame);
        genreDao.save(thisGenre);
        return "redirect:/genre/view/" + thisGenre.getId();
    }

}
