package ru.innopolis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * диспечер конекта к базе
 * если есть подключение отдает его если нету создает новое
 * принимает и хранит 1 подключение
 * синхронизирован по классу
 */
public class ConnectBD implements IconectBD {
    private final static Logger logger = LoggerFactory.getLogger(ConnectBD.class);
    private static Statement statement = null; // хранится подключение

    /**
     * метод отдает подключение либо создает новое
     *
     * @return
     * @throws SQLException
     */
    @Override
    public Statement getConect() throws SQLException {
        synchronized (ConnectBD.class) {
            if (ConnectBD.statement == null) {
                logger.info("hav not free connect");
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "admin", "admin");
                Statement tempstatement = con.createStatement();
                logger.info("create new connect and get");
                return tempstatement;
            } else {
                Statement tempstatement = ConnectBD.statement;
                statement = null;
                logger.info("get connect");
                return tempstatement;
            }
        }
    }

    /**
     * принимает и запоминает подключение
     * если переменная уже занята закрывает подключение
     *
     * @param tstatement
     */
    @Override
    public void returnConect(Statement tstatement) {
        synchronized (ConnectBD.class) {
            logger.info("return connect");
            if (statement != null) {
                logger.info("is not plase for connect, close");
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            logger.info("add conect");
            ConnectBD.statement = tstatement;
        }
    }
}



