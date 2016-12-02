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

    private PassHashSals passHashSals;//!
    private UserDao userDao;
    @Autowired(required = true)
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired(required = true)
    public void setPassHashSals(PassHashSals passHashSals) {
        this.passHashSals = passHashSals;
    }//!

    /**
     * Метод добавления юзера. при добал=влении
     * приходит юзер с открытым паролем с формы регистрации
     * генерится соль + пароль + хеш и записывается в бозу
     * @param user
     */
    @Override
    //@Transactional
    public void addUser(User user) {
        String sals=  passHashSals.getSals();//!
        user.setPass(user.getPass()+sals.hashCode());//!
        user.setSals(sals);//!
        this.userDao.addUser(user);
    }

    /**
     * Метод обновления пользователя в базе
     * @param user
     */
    @Override
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    /**
     * Метод удаления пользователя из базы по ИД
     * @param id
     */
    @Override
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    /**
     * Метод вернет Юзера по ИД
     * @param id
     * @return
     */
    @Override
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    /**
     * Метод проверяет есть ли пользователь в базе на входе Юзер
     * пришедший с формы Залогирования берет в базе по логину Юзера
     * Берет соль + пароль(открытый) + хеш и сравнивает с паролем из базы
     *
     * @param user
     * @return
     */
    @Override
    public User isThereUser(User user) {
        User usFromBD = this.userDao.getUserByLogin(user.getLogin());
        if( usFromBD.getPass().equals((user.getPass()+usFromBD.getSals()).hashCode())){
            return usFromBD;
        }
        return this.userDao.isThereUser(user);
    }

    /**
     * Метод вернет список пользователе всех из базы
     * @return
     */
    @Override
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
