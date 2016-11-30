package ru.innopolis.anyUtil.conectBD;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ADMIN on 28.11.2016.
 */
public interface ConnectBD {
    public Connection getConect()throws SQLException;
    public void returnConect(Connection connec);

}
