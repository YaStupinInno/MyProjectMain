package ru.innopolis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * сервлет проверяет какая клавиша была нажата
 * на главной странице
 * войти в кабинет или зарегистрироваться
 * отправляет соотвецтвенно на проверку логина
 * пароля либо на страницу регистрации
 */
public class actionClic extends dispacher {
    private final static Logger logger = LoggerFactory.getLogger(actionClic.class);
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("enter") != null){
            logger.info("clic to LogIn");
            super.forward("/inMyAcc",req,resp);
        }else {
            if(req.getParameter("register") != null){
                logger.info("clic to Regestration");
                super.forward("/register.jsp",req,resp);
            }
        }
    }
}
