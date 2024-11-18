package com.WorkShop.sagar.models.Calender;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Calendar")
public class Calendar {
    @Id
    private LocalDate date;
    private String dayOfWeek;
}
