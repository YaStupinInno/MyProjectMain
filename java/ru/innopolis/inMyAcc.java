package ru.innopolis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * запрашиваем подключение к базе
 * проверяем естьли юзер в базе, если нет ошибка
 * если есть, создаем его заполняем данными из базы
 * переходим в кабинет
 *
 */

public class inMyAcc extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(inMyAcc.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("check in basis");
        IconectBD conBD = new ConnectBD();
        try {
            Statement statement = conBD.getConect();
            Class.forName("org.postgresql.Driver");
            StringBuffer strBuf = new StringBuffer();
            String login = req.getParameter("login");
            int passw = req.getParameter("password").hashCode();
            logger.info("build select adn send");
            strBuf.append("SELECT login, pass, name, firstname, status FROM clients where (login='").
                    append(login).append("' and pass=").append(passw).append(");").toString();
            ResultSet rsult = statement.executeQuery(String.valueOf(strBuf));//запрашиваем в базе юзера с такимлогином и паролем
            if(rsult.next()) {
                logger.info("user be in base");
                User usr = createUser(rsult);
                creatSess( req, resp, usr);
                req.setAttribute("user",usr);// передаем созданного узера в кабинет
                logger.info("create user");
                req.getRequestDispatcher("myAcc.jsp").forward(req, resp);
            }else{
                logger.info("user is not in base");
                resp.sendRedirect("error.jsp");// если в базе клиента ненашли выводим ошибку
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод проверяет зашел админ или простой юзер
     * такой обьект и создает и заполняет его поля
     * @param rsult
     * @return
     */
    private User createUser(ResultSet rsult) {
        User user=null;
        try {
            if (rsult.getInt(5) == 1){
                logger.info("its admin");
                  user = new Admin();
            }else {
                logger.info("its simpl user");
                user = new User();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            user.setLogin(rsult.getString(1));
            user.setPass(rsult.getString(2));
            user.setName(rsult.getString(3));
            user.setFerstName(rsult.getString(4));
            user.setStatus(rsult.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("return user");
        return user;
    }

    /**
     * реализуем сессию, в которую помещаем самогоже юзера
     * @param req
     * @param resp
     * @param usr
     */
    private void creatSess(HttpServletRequest req, HttpServletResponse resp, User usr){

        HttpSession ses = req.getSession();
        logger.info("set user in to session");
        ses.setAttribute("user", usr);
        // берем Id сессии и передаем клиенту в куку
        Cookie cookie = new Cookie("id", req.getSession().toString()/*ses.getId()*/);
        cookie.setMaxAge(60*60);
        logger.info("create cook");
        resp.addCookie(cookie);
    }
}
