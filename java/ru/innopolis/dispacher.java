package ru.innopolis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ADMIN on 22.11.2016.
 */
public class dispacher extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(dispacher.class);

    public void forward(String to, HttpServletRequest req, HttpServletResponse resp){

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(to);
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
