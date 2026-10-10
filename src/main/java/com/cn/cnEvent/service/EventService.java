package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventDAL eventDAL;


    @Transactional
    public void saveToDAL(Event event) {
        eventDAL.save(event);
    }

    @Transactional
    public List<Event> getAllEventsFromDAL() {
        return eventDAL.getAllEvents();
    }

    @Transactional
    public Event getAllEventsFromDALByID(Long id) {
        return eventDAL.getById(id);
    }

    @Transactional
    public void updateEvent(Event updateEvent) {
        Event existingEvent = eventDAL.getById(updateEvent.getId());

        if (existingEvent == null) {
            throw new RuntimeException("No event found with id: " + updateEvent.getId());
        }

        eventDAL.update(updateEvent);
    }

    @Transactional
    public void deleteEvent(Long id) {
        Event existingEvent = eventDAL.getById(id);

        if (existingEvent == null) {
            throw new RuntimeException("No event found with id: " + id);
        }

        eventDAL.delete(id);
    }

}
