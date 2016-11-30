package ru.innopolis.models.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by ADMIN on 28.11.2016.
 */

public class User {
    private int id;
    private String login;
    private String pass;
    private String sals;
    private String nameFull;
    Topics[] setTopics;

    public User() {
    }
    public User(ResultSet rsult) {
        try {
            this.id = rsult.getInt(1);
            this.login = rsult.getString(2);
            this.pass = rsult.getString(3);
            this.sals = rsult.getString(4);
            this.nameFull = rsult.getString(5);
            //this.setTopics = rsult.getArray(6);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User(int id, String login, String pass, String sals, String nameFull, Topics[] setTopics) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.sals = sals;
        this.nameFull = nameFull;
        this.setTopics = setTopics;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSals() {
        return sals;
    }

    public void setSals(String sals) {
        this.sals = sals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public Topics[] getSetTopics() {
        return setTopics;
    }

    public void setSetTopics(Topics[] setTopics) {
        this.setTopics = setTopics;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", sals='" + sals + '\'' +
                ", nameFull='" + nameFull + '\'' +
                ", setTopics=" + setTopics +
                '}';
    }

}