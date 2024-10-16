package com.WorkShop.sagar.service;

import com.WorkShop.sagar.models.Calender.Event;
import com.WorkShop.sagar.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    // Create an event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Find events by date
    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepository.findByDate(date);
    }

    // Delete an event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> findEventsByMonth(int year, int month) {
        // Calculate the first day of the month
        LocalDate startDate = LocalDate.of(year, month, 1);
        // Calculate the last day of the month
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        return eventRepository.findByDateBetween(startDate, endDate);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        if (!eventRepository.existsById(id)) {
            return null; // or throw an exception
        }
        updatedEvent.setId(id); // Ensure the ID is set for the update
        return eventRepository.save(updatedEvent);
    }
}
