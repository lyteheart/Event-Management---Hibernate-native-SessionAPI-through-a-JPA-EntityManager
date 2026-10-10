package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    // GET /event/{id}
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getAllEventsFromDALByID(id);
    }

    // GET /event/all
    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEventsFromDAL();
    }

    // POST /event/save
    @PostMapping("/save")
    public String saveEvent(@RequestBody Event event) {
        eventService.saveToDAL(event);
        return "The event was saved successfully.";
    }

    // DELETE /event/delete/{id}
    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "The event was deleted successfully";
    }

    // PUT /event/update
    @PutMapping("/update")
    public String updateEvent(@RequestBody Event updateEvent) {
        eventService.updateEvent(updateEvent);
        return "Event is updated successfully";
    }
}