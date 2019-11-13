package com.thanhkhuu.gameslist.controllers;

import com.thanhkhuu.gameslist.models.GamePlatform;
import com.thanhkhuu.gameslist.models.data.GamePlatformDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("platforms")
public class GamePlatformController {

    @Autowired
    private GamePlatformDao platformDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {
        model.addAttribute("title", "Platforms");
        model.addAttribute("platforms", platformDao.findAll());
        return "platform/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new GamePlatform());
        model.addAttribute("title", "Add Platform");
        return "platform/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid GamePlatform gamePlatform, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Platform");
            return "platform/add";
        }
        platformDao.save(gamePlatform);
        return "redirect:";
    }
}
