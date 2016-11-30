package ru.innopolis.models.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by ADMIN on 30.11.2016.
 */
public class Eventt {
    int id;
    Date data;
    String name;
    String subject;
    String description;

    public Eventt() {
    }

    public Eventt(ResultSet rsult) {
        try {
            this.id = rsult.getInt(1);
            this.data = rsult.getDate(2);
            this.name =rsult.getString(3);
            this.subject = rsult.getString(4);
            this.description = rsult.getString(5);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Eventt(int id, Date data, String name, String subject, String description) {
        this.id = id;
        this.data = data;
        this.name = name;
        this.subject = subject;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Eventt{" +
                "id=" + id +
                ", data=" + data +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
