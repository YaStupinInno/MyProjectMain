package ru.innopolis;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ADMIN on 24.11.2016.
 */
public interface IconectBD {
    public Statement getConect() throws SQLException;

    void returnConect(Statement statement);
}
