package ru.innopolis.models.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.innopolis.anyUtil.passHash.PassHashSals;
import ru.innopolis.models.dao.UserDao;
import ru.innopolis.models.pojo.User;

import java.util.List;

/**
 * Created by ADMIN on 28.11.2016.
 */
@Service
public class UserServisImpl implements UserServis {

    //private PassHashSals passHashSals;
    private UserDao userDao;
    @Autowired(required = true)
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    //@Transactional
    public void addUser(User user) {
      /*  String sals=  passHashSals.getSals();
        user.setPass(user.getPass()+sals.hashCode());
        user.setSals(sals);
        */
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
    public User isThereUser(User user) {
        // user с простым паролем
        User usFromBD = this.userDao.getUserByLogin(user.getLogin());
        if( usFromBD.getPass().equals((user.getPass()+usFromBD.getSals()).hashCode())){
            return usFromBD;
        }
        //--------------
        System.out.println("no");
        return this.userDao.isThereUser(user);
    }

    @Override
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
