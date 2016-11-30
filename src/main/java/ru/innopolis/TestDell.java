package ru.innopolis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.innopolis.models.dao.EventtDaoImpl;
import ru.innopolis.models.pojo.Eventt;
import ru.innopolis.models.pojo.Topics;
import ru.innopolis.models.pojo.User;
import ru.innopolis.models.servis.UserServis;

import java.time.Instant;
import java.util.*;

/**
 * Created by ADMIN on 28.11.2016.
 */
public class TestDell {
    public static void main(String[] args) {

        Topics s = Topics.EANGLISH;
        int a =s.getValue();
        Topics b =  Topics.getByValue(a);

        Eventt d = new Eventt();
        EventtDaoImpl rr= new EventtDaoImpl();


        rr.listEventts();

        System.out.println(s.equals(b));
        System.out.println(Topics.getByValue(5));
        System.out.println(Topics.getByValue(6));
        System.out.println(Topics.getByValue(8));
        System.out.println(Topics.getByValue(7));

  /*      ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"student-servlet.xml"});

        UserServis userServis = (UserServis) applicationContext.getBean("userServis");
        List<User> list = userServis.listUsers();
        System.out.println(list.size());
        for(User a:list){
            System.out.println(a.toString());
        }*/
    }
}
