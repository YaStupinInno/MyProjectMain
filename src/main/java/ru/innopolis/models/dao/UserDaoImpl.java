package ru.innopolis.models.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * Класс для работы с БД и обьектами Юзер
 */
@Repository
public class UserDaoImpl implements UserDao {
    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    ConnectBD connectBD;
    @Autowired(required = true)
    public void setConnectBD(ConnectBD connectBD) {
        this.connectBD = connectBD;
    }

    /**
     * Метод добавления юзера нового в базу
     * @param user
     */
    @Override
    public void addUser(User user) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "INSERT INTO users (login, pass, sals, namefull)VALUES (?,?,?,?)")){
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPass());
            pstmt.setString(3, user.getSals());
            pstmt.setString(4, user.getNameFull());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.info("SQLException");
        }
    }

    /**
     * Метод внесения изменений в старом позователе
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "UPDATE users SET login = ?, pass= ?, sals= ?, namefull= ? WHERE id = ?;")){
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPass());
            pstmt.setString(3, user.getSals());
            pstmt.setString(4, user.getNameFull());
            pstmt.setInt(5, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.info("SQLException");
        }
    }

    /**
     * Метод удаления пользователя по ИД
     * @param id
     */
    @Override
    public void removeUser(int id) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "DELETE FROM users WHERE id = ?;")){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.info("SQLException");
        }
    }

    /**
     * Метод вернет пользователя по ИД
     * @param id
     * @return
     */
    @Override
    public User getUserById(int id) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "SELECT * FROM users where id=?")){
            pstmt.setInt(1, id);
            ResultSet rsult = pstmt.executeQuery();
            if(rsult.next()) {
                return new User(rsult);
            }
        } catch (SQLException e) {
            logger.info("SQLException");
        }
        return null;
    }

    /**
     * Метод вернет из базы пользователя по заданному  логину
     * для работы с Входом пользователя, на входе строка
     * @param login
     * @return
     */
    @Override
    public User getUserByLogin(String login) {

        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "SELECT * FROM users where login=?")){
            pstmt.setString(1, login);
            ResultSet rsult = pstmt.executeQuery();
            if(rsult.next()) {
                return new User(rsult);
            }
        } catch (SQLException e) {
            logger.info("SQLException");
        }
        return null;
    }

    /**
     * Метод вернет из базы пользователя по заданному  логину
     * для работы с Входом пользователя на входе Юзер
     * @param user
     * @return
     */
    @Override
    public User isThereUser(User user) {
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "SELECT * FROM users where login=?")){
            pstmt.setString(1, user.getLogin());
            ResultSet rsult = pstmt.executeQuery();
            if(rsult.next()) {
                return new User(rsult);
            }
        } catch (SQLException e) {
            logger.info("SQLException");
        }
        return null;
    }

    /**
     * Метод вернет из базы пользователей всех
     *
     * @return
     */
    @Override
    public List<User> listUsers() {
        List<User> list = new ArrayList<>();
        try (PreparedStatement pstmt = connectBD.getConect().prepareStatement(
                "SELECT * FROM users")){
            ResultSet rsult = pstmt.executeQuery();
            while(rsult.next()) {
                list.add(new User(rsult));
            }
        } catch (SQLException e) {
            logger.info("SQLException");
        }
        return list;
    }
}
