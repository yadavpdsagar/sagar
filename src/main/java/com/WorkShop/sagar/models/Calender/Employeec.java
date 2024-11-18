package com.WorkShop.sagar.models.Calender;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Employeec {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  employeeId;
    private String  employeePassword ;
    private String employeeEmail ;
    private String employeeUsername ;

    @OneToMany(mappedBy = "employee" )
    @JsonManagedReference
    private List<MyAttendance> attendance;
}
/*
*   public class AttendanceCreateRequest {
    private int employeeId;
    private LocalDate date;
    private LocalTime punchIn;
    private LocalTime punchOut;

    // Getters and setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getPunchIn() {
        return punchIn;
    }

    public void setPunchIn(LocalTime punchIn) {
        this.punchIn = punchIn;
    }

    public LocalTime getPunchOut() {
        return punchOut;
    }

    public void setPunchOut(LocalTime punchOut) {
        this.punchOut = punchOut;
    }
}

* */