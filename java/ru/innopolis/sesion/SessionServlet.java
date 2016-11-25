package ru.innopolis.sesion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ADMIN on 23.11.2016.
 */
public class SessionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses = req.getSession();
        String str = req.getParameter("textinput");
        ses.setAttribute("textin",str);
        RequestDispatcher disp =  req.getRequestDispatcher("/sesion/swowsession.jsp");
        disp.forward(req, resp);

    }
}
