package ru.innopolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.models.pojo.User;
import ru.innopolis.models.servis.UserServis;

/**
 * Created by ADMIN on 02.12.2016.
 */
@Controller
public class LoginController {

    private UserServis userService;
    @Autowired(required = true)
    public void setUserService(UserServis userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainLoginChek(){
        return new ModelAndView("view/login", "user", new User());
    }

    @RequestMapping(value = "/chekUser", method = RequestMethod.POST)
    public ModelAndView chekUser(@ModelAttribute("user") User user){

       user = userService.isThereUser(user);

        if(user== null || user.getStatys()==0)
            return new ModelAndView("view/error","mesag", "SORY");
        else
           return new ModelAndView("view/myacc", "user", user);
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public ModelAndView loginOut(){
        return new ModelAndView("view/login", "user", new User());
    }
}
