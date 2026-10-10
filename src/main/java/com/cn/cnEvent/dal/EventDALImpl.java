package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


@Repository
@Transactional
public class EventDALImpl implements EventDAL {
    @Autowired
    EntityManager entityManager;


    @Override
    public Event getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Event.class, id);
    }

    @Override
    public List<Event> getAllEvents() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery(
                "SELECT e FROM Event e", Event.class
        ).getResultList();
    }

    @Override
    public String save(Event item) {
        Session session = entityManager.unwrap(Session.class);
        Serializable id = session.save(item);
        return id.toString();
    }

    @Override
    public void update(Event updateEvent) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(updateEvent);
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);

        Event event = session.get(Event.class, id);

        if (event != null) {
            session.remove(event);
        }
    }
}
