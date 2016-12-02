package ru.innopolis.models.servis;


import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.dao.EventtDao;
import ru.innopolis.models.pojo.Eventt;
import ru.innopolis.models.pojo.Topics;
import ru.innopolis.models.pojo.User;

import java.util.Date;
import java.util.List;

/**
 * Created by ADMIN on 30.11.2016.
 */

/**
 * Класс сервисного слоя для работы с мероприятиями
 */
public class EventtServisImpl implements EventtServis {
    EventtDao eventtDao;
    @Autowired(required = true)
    public void setEventtDao(EventtDao eventtDao) {
        this.eventtDao = eventtDao;
    }

    /**
     * Метод добавления Мероприятия
     * @param eventt
     */
    @Override
    public void addEventt(Eventt eventt) {
        eventtDao.addEventt(eventt);
    }

    /**
     * Метод внесения изменений в мероприятие
     * @param eventt
     */
    @Override
    public void updateEventt(Eventt eventt) {
        eventtDao.updateEventt(eventt);
    }

    /**
     * Метод удаления пользователя по ИД
     * @param id
     */
    @Override
    public void removeEventt(int id) {
        eventtDao.removeEventt(id);
    }

    /**
     * Метод вернет мероприятие по ИД
     * @param id
     * @return
     */
    @Override
    public Eventt getEventtById(int id) {
        return eventtDao.getEventtById(id);
    }

    /**
     * Метод  вернет список всех мероприятий из базы
     * @return
     */
    @Override
    public List<Eventt> listEventts() {
        return eventtDao.listEventts();
    }

    /**
     * Метод вернет список мероприятий из базы по дате
     * @param date
     * @return
     */
    @Override
    public List<Eventt> listEventts(Date date) {
        return eventtDao.listEventts(date);
    }

    /**
     * Метод вернет список мероприятий по тематике
     * @param topic
     * @return
     */
    @Override
    public List<Eventt> listEventts(Topics topic) {
        return eventtDao.listEventts(topic);
    }

    /**
     * Метод  вернет список мероприятий определенного пользователя
     * @param user
     * @return
     */
    @Override
    public List<Eventt> listEventts(User user) {
        return eventtDao.listEventts(user);
    }
}
