package com.WorkShop.sagar.models.Calender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor

public class StudentAttendanceDto {
    private int studentID;
    private LocalDate date;
    private LocalTime punchIn;
    private LocalTime punchOut;
    private String dayOfWeek;

    public StudentAttendanceDto(int studentID, String dayOfWeek, LocalTime punchOut, LocalTime punchIn, LocalDate date) {
        this.studentID = studentID;
        this.dayOfWeek = dayOfWeek;
        this.punchOut = punchOut;
        this.punchIn = punchIn;
        this.date = date;
    }

    public StudentAttendanceDto() {
    }
}
