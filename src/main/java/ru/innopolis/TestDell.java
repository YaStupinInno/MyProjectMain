package ru.innopolis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.innopolis.models.dao.UserDaoIpmlHibirnate;
import ru.innopolis.models.pojo.User;
import ru.innopolis.models.servis.UserServis;

/**
 * Created by ADMIN on 28.11.2016.
 */

/**
 * Класс для тестирования УДАЛИТЬ
 */
public class TestDell {
    public static void main(String[] args) {



       ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"WEB-INF/student-servlet.xml"});
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
