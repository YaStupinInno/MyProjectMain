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
public class UserDaoIpmlHibirnate implements UserDao {

    // как инжектить?
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "item-manager-pu" );
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override//ok
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override//ok
    public void updateUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override//ok
    public void removeUser(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class,id));
        entityManager.getTransaction().commit();
    }

    @Override // ok
    public User getUserById(int id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,id);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override//ok
    public List<User> listUsers() {

        return null;
    }
}
