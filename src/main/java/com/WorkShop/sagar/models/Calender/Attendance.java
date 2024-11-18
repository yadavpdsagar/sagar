package com.WorkShop.sagar.models.Calender;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Attendance")
@IdClass(AttendanceId.class)
public class Attendance {
    @Id
    private int studentID;

    @Id
    private LocalDate date;

    private LocalTime punchIn;
    private LocalTime punchOut;
}
