package com.WorkShop.sagar.Controller;

import com.WorkShop.sagar.models.Calender.Event;
import com.WorkShop.sagar.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @GetMapping("/{date}")
    public List<Event> getEventsByDate(@PathVariable String date) {
        return eventRepository.findByDate(LocalDate.parse(date));
    }
}

