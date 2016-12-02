package ru.innopolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.models.pojo.User;
import ru.innopolis.models.servis.UserServis;

/**
 * Created by ADMIN on 28.11.2016.
 */
@Controller
public class UserController {

    private UserServis userService;
    @Autowired(required = true)
   // @Qualifier(value = "userService")
    public void setUserService(UserServis userServis) {
        this.userService = userServis;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView reg(/*@ModelAttribute("user") User user*/){
        return new ModelAndView("view/registration", "user", new User());
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user){
        if(user.getId() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }
        return new ModelAndView("view/myacc", "user", user);
        //return "myacc";
    }

    @RequestMapping("/removestud/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping("editstud/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        return "userdata";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logIn(@ModelAttribute("user") User user){
        if(user.getId() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }
        return "redirect:/users";
    }
}
