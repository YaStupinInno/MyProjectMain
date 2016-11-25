package ru.innopolis;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * создаем нового пользователя добавляем его в базу
 * переходим в личный кабинет
 */
public class RegisterClient extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(RegisterClient.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("create NEW user ");
        IconectBD conBD = new ConnectBD();
        try {
            Statement statement = conBD.getConect();
            Class.forName("org.postgresql.Driver");
            StringBuffer strBuf = new StringBuffer();
            //try {
            logger.info("add user to base");
                strBuf.append("INSERT INTO clients VALUES (").
                        append("'").append(req.getParameter("login")).append("',").
                        append("'").append(req.getParameter("password").hashCode()).append("',").
                        append("'").append(req.getParameter("firstName")).append("',").
                        append(req.getParameter("lastName")).append(");").toString();
           // } catch (Exception e){
                //resp.sendRedirect("/error.jsp");
          //  }
            statement.executeUpdate(String.valueOf(strBuf));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("go to ACC");
        req.getRequestDispatcher("/inMyAcc").forward(req, resp);
        //resp.sendRedirect("/inMyAcc");///myAcc.jsp
    }
}
