package ru.innopolis.models.servis;

import ru.innopolis.models.pojo.User;

import java.util.List;

/**
 * Created by ADMIN on 28.11.2016.
 */
public interface UserServis {

    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public User isThereUser(User user);

    public List<User> listUsers();

}
