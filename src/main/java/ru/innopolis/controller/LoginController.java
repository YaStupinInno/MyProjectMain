package ru.innopolis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.models.pojo.User;

/**
 * Created by ADMIN on 02.12.2016.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainLoginChek(){
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping(value = "/chekUser", method = RequestMethod.POST)
    public ModelAndView chekUser(){
        return new ModelAndView("login", "user", new User());
    }


}
