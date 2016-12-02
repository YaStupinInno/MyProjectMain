package ru.innopolis.models.dao;

import ru.innopolis.models.pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 * Created by ADMIN on 01.12.2016.
 */

/**
 * Класс имплементациии ДАО для работы с Юзером через Хибернейт
 */
public class UserDaoIpmlHibirnate implements UserDao {

    // как инжектить?
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "item-manager-pu" );
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    /**
     * Метод добавления нового пользователя в базу
     *
     * @param user
     */
    @Override//ok
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    /**
     * Метод сохраняет изменения в БД
     *
     * @param user
     */
    @Override//ok
    public void updateUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    /**
     * Метод удаления пользователя из базы по ИД
     * @param id
     */
    @Override//ok
    public void removeUser(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class,id));
        entityManager.getTransaction().commit();
    }

    /**
     * Метод вернет пользователя из базы по ИД
     * @param id
     * @return
     */
    @Override // ok
    public User getUserById(int id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,id);
        entityManager.getTransaction().commit();
        return user;
    }

    /**
     * Метод вернет юзера по логину из базы
     * @param login
     * @return
     */
    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    /**
     * Метод вернет пользователя из базы по логину на
     * входе Юзер
     * @param user
     * @return
     */
    @Override
    public User isThereUser(User user) {
        return null;
    }

    /**
     * Метод вернет всех пользователей из базы
     * @return
     */
    @Override//ok
    public List<User> listUsers() {

        return null;
    }
}
