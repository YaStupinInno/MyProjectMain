package ru.innopolis.anyUtil.conectBD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс пула конектов который хранит только 1 коннект
 */
@Component
public class ConnectBDImpl implements ConnectBD {

    private final static Logger logger = LoggerFactory.getLogger(ConnectBDImpl.class);
    private Connection conection = null; // хранится подключение


/*    public void setConection(Connection conection) {
        this.conection = conection;
    }*/

    /**
     * метод отдает подключение либо создает новое
     *
     * @return
     * @throws SQLException
     */
    //@Override
    public Connection getConect() throws SQLException {
        synchronized (ConnectBDImpl.class) {
            if (conection == null) {
                logger.info("hav not free connect");
                try {
                    Class.forName("org.postgresql.Driver");
                    conection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "admin", "admin");
                    logger.info("create new connect and get");
                    return conection;
                } catch (ClassNotFoundException e) {
                    logger.info("ClassNotFoundException");
                }
            } else {
                Connection tempconection = conection;
                conection = null;
                logger.info("get connect");
                return tempconection;
            }
            return null;
        }
    }

    /**
     * принимает и запоминает подключение
     * если переменная уже занята закрывает подключение
     *
     * @param
     */
   // @Override
    public void returnConect(Connection connec) {
        synchronized (ConnectBDImpl.class) {
            logger.info("return connect");
            if (conection != null) {
                logger.info("is not plase for connect, close");
                try {
                    conection.close();
                } catch (SQLException e) {
                    logger.info("SQLException");
                }
            }
            logger.info("add conect");
            conection = connec;
        }
    }
}



