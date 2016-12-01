package ru.innopolis.models.dao;


import org.springframework.stereotype.Repository;
import ru.innopolis.anyUtil.conectBD.ConnectBD;
import ru.innopolis.models.pojo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 28.11.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    ConnectBD connectBD;

    public void setConnectBD(ConnectBD connectBD) {
        this.connectBD = connectBD;
    }

    @Override
    public void addUser(User user) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "INSERT INTO studnew (login, pass, sals, namefull)VALUES (?,?,?,?)")){
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPass());
            pstmt.setString(3, user.getSals());
            pstmt.setString(4, user.getNameFull());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "UPDATE studnew SET login = ?, pass= ?, sals= ?, namefull= ? WHERE id = ?;")){
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPass());
            pstmt.setString(3, user.getSals());
            pstmt.setString(4, user.getNameFull());
            pstmt.setInt(5, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUser(int id) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "DELETE FROM studnew WHERE id = ?;")){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "SELECT * FROM studnew where id=?")){
            pstmt.setInt(1, id);
            ResultSet rsult = pstmt.executeQuery();
            if(rsult.next()) {
                return new User(rsult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> listUsers() {
        List<User> list = new ArrayList<>();
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "SELECT * FROM studnew")){
            ResultSet rsult = pstmt.executeQuery();
            while(rsult.next()) {
                list.add(new User(rsult));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
