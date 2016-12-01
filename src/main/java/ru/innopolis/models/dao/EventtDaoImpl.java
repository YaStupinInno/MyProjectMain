package ru.innopolis.models.dao;

import org.springframework.stereotype.Repository;
import ru.innopolis.anyUtil.conectBD.ConnectBD;

import ru.innopolis.models.pojo.Eventt;
import ru.innopolis.models.pojo.Topics;
import ru.innopolis.models.pojo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ADMIN on 30.11.2016.
 */
@Repository
public class EventtDaoImpl implements EventtDao {

    ConnectBD connectBD;

    public void setConnectBD(ConnectBD connectBD) {
        this.connectBD = connectBD;
    }

    @Override
    public void addEventt(Eventt eventt) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "INSERT INTO events (date, name, subject, description)VALUES (?,?,?,?)")){
            pstmt.setDate(1, (java.sql.Date) eventt.getData());
            pstmt.setString(2, eventt.getName());
            pstmt.setString(3, eventt.getSubject());
            pstmt.setString(4, eventt.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateEventt(Eventt eventt) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "UPDATE events SET date = ?, name= ?, subject= ?, description= ? WHERE id = ?;")){
            pstmt.setDate(1, (java.sql.Date) eventt.getData());
            pstmt.setString(2, eventt.getName());
            pstmt.setString(3, eventt.getSubject());
            pstmt.setString(4, eventt.getDescription());
            pstmt.setInt(5, eventt.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeEventt(int id) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "DELETE FROM events WHERE id = ?;")){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Eventt getEventtById(int id) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "SELECT * FROM events where id=?")){
            pstmt.setInt(1, id);
            ResultSet rsult = pstmt.executeQuery();
            if(rsult.next()) {
                return new Eventt(rsult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Eventt> listEventts() {
        List<User> list = new ArrayList<>();
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "SELECT * FROM events")){
            ResultSet rsult = pstmt.executeQuery();
            while(rsult.next()) {
                list.add(new User(rsult));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Eventt> listEventts(Date date) {
        List<User> list = new ArrayList<>();
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "SELECT * FROM events where date= ? ")){

            pstmt.setDate(1 , new java.sql.Date(date.getTime()));



            ResultSet rsult = pstmt.executeQuery();
            while(rsult.next()) {
                list.add(new User(rsult));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Eventt> listEventts(Topics topic) {
        return null;
    }

    @Override
    public List<Eventt> listEventts(User user) {
        return null;
    }
}
