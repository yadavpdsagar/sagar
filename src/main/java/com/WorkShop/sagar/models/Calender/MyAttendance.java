package com.WorkShop.sagar.models.Calender;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Entity
public class MyAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;



//        @Id
        private LocalDate date;

        private LocalTime punchIn;
        private LocalTime punchOut;

    @ManyToOne
    @JoinColumn(name = "employee_Id")
    @JsonBackReference
    private Employeec employee;

}
