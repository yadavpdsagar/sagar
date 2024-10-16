package com.WorkShop.sagar.Controller;

import com.WorkShop.sagar.models.Calender.Event;
import com.WorkShop.sagar.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Create a new event
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    // Get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Find events by date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<Event>> getEventsByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Event> events = eventService.getEventsByDate(localDate);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/month")
    public List<Event> getEventsByMonth(@RequestParam int year, @RequestParam int month) {
        return eventService.findEventsByMonth(year, month);
    }
    // Delete an event
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
