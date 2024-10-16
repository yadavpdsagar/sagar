package com.WorkShop.sagar.models.Calender;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private DayStatus dayStatus ;

    // Use LocalDate to manage date
    private LocalDate date;

    // Constructor to set date using year, month, and day
    public Event(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }


    // Default constructor
    public Event() {
    }


    // Getters for year, month, and day
    public int getYear() {
        return date.getYear();
    }

    public int getMonth() {
        return date.getMonthValue(); // 1-based month
    }

    public int getDay() {
        return date.getDayOfMonth();
    }

    // Method to get month name
    public String getMonthName() {
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}
