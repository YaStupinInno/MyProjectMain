package ru.innopolis.models.dao;

import ru.innopolis.models.pojo.User;

import java.util.List;

/**
 * Created by ADMIN on 28.11.2016.
 */
public interface UserDao {

    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> listUsers();

}
