package ru.innopolis.models.servis;

import org.springframework.stereotype.Service;
import ru.innopolis.models.dao.UserDao;
import ru.innopolis.models.pojo.User;

import java.util.List;

/**
 * Created by ADMIN on 28.11.2016.
 */
@Service
public class UserServisImpl implements UserServis {
    private UserDao userDao;

    public UserServisImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    //@Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
