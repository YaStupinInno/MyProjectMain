package ru.innopolis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.anyUtil.conectBD.ConnectBDImpl;
import ru.innopolis.models.pojo.User;
import ru.innopolis.models.servis.UserServis;

/**
 * Created by ADMIN on 02.12.2016.
 */

/**
 * Класс контроллера действий связанных с залогиниванием
 * и разлогированием пользователя
 *
 */
@Controller
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(ConnectBDImpl.class);

    private UserServis userService;
    @Autowired(required = true)
    public void setUserService(UserServis userService) {
        this.userService = userService;
    }

    /**
     * при первом обращении все заходят
     * создается Чистый юзер и передается в представление
     * для заполнения логина и пароля
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainLoginChek(){
        logger.info("open log in ");
        return new ModelAndView("view/login", "user", new User());
    }

    /**
     * После нажатия кнопки войти, передвется User c
     *  Заполенными логином и паролем,
     *  обращается к базе
     *  если пользователь есть вернется Юзер с заполненным статусом >0
     *  если статус 0 выпадет ошибка
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/chekUser", method = RequestMethod.POST)
    public ModelAndView chekUser(@ModelAttribute("user") User user){
        logger.info("chekUser, login and pass");
       user = userService.isThereUser(user);
        if(user== null || user.getStatys()==0) {
            logger.info("not use in the base");
            return new ModelAndView("view/error", "mesag", "SORY");
        }else {
            logger.info("user is in base");
            return new ModelAndView("view/myacc", "user", user);
        }
    }

    /**
     * Метод лоя разлогирования,
     * создаст чистого Юзера и перенаправит на стартовую страницу
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public ModelAndView loginOut(){
        logger.info("LogOut");
        return new ModelAndView("view/login", "user", new User());
    }
}
