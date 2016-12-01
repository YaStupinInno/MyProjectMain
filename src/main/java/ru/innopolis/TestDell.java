package ru.innopolis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.innopolis.models.dao.EventtDaoImpl;
import ru.innopolis.models.dao.UserDaoIpmlHibirnate;
import ru.innopolis.models.pojo.Eventt;
import ru.innopolis.models.pojo.Topics;
import ru.innopolis.models.pojo.User;
import ru.innopolis.models.servis.UserServis;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.*;

/**
 * Created by ADMIN on 28.11.2016.
 */
public class TestDell {
    public static void main(String[] args) {



       ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"student-servlet.xml"});
        UserServis userServis = (UserServis) applicationContext.getBean("userServis");

        UserDaoIpmlHibirnate hib= new UserDaoIpmlHibirnate();
        User us= hib.getUserById(12);
        hib.removeUser(12);

       // hib.removeUser(5);
        System.out.println(1);


    /*    List<User> list = userServis.listUsers();

        System.out.println(list.size());
        for(User a:list){
            System.out.println(list.size());
        }
        System.out.println(list.size());*/
    }
}
