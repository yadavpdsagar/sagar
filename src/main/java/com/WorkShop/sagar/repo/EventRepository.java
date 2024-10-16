package com.WorkShop.sagar.repo;

import com.WorkShop.sagar.models.Calender.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventRepository  extends JpaRepository<Event, Long> {

    List<Event> findByDate(LocalDate date);





}

