package ru.innopolis.models.servis;


import ru.innopolis.models.dao.EventtDao;
import ru.innopolis.models.pojo.Eventt;
import ru.innopolis.models.pojo.Topics;
import ru.innopolis.models.pojo.User;

import java.util.Date;
import java.util.List;

/**
 * Created by ADMIN on 30.11.2016.
 */
public class EventtServisImpl implements EventtServis {
    EventtDao eventtDao;

    @Override
    public void addEventt(Eventt eventt) {
        eventtDao.addEventt(eventt);
    }

    @Override
    public void updateEventt(Eventt eventt) {
        eventtDao.updateEventt(eventt);
    }

    @Override
    public void removeEventt(int id) {
        eventtDao.removeEventt(id);
    }

    @Override
    public Eventt getEventtById(int id) {
        return eventtDao.getEventtById(id);
    }

    @Override
    public List<Eventt> listEventts() {
        return eventtDao.listEventts();
    }

    @Override
    public List<Eventt> listEventts(Date date) {
        return eventtDao.listEventts(date);
    }

    @Override
    public List<Eventt> listEventts(Topics topic) {
        return eventtDao.listEventts(topic);
    }

    @Override
    public List<Eventt> listEventts(User user) {
        return eventtDao.listEventts(user);
    }
}
