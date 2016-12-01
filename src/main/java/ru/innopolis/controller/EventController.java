package ru.innopolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.innopolis.models.pojo.Eventt;
import ru.innopolis.models.pojo.Topics;
import ru.innopolis.models.pojo.User;
import ru.innopolis.models.servis.EventtServis;

import java.util.Date;
import java.util.List;

/**
 * Created by ADMIN on 28.11.2016.
 */


@Controller
public class EventController {
    private EventtServis eventtServis;
/*
   // @Autowired(required = true)
    public EventController(EventtServis eventtServis) {
        this.eventtServis = eventtServis;
    }

    public void setEventtServis(EventtServis eventtServis) {
        this.eventtServis = eventtServis;
    }


    public void addEventt(Eventt eventt);

    public void updateEventt(Eventt eventt);

    public void removeEventt(int id);

    public Eventt getEventtById(int id);

    public List<Eventt> listEventts();

    public List<Eventt> listEventts(Date date);

    public List<Eventt> listEventts(Topics topic);

    public List<Eventt> listEventts(User user);
*/
}
