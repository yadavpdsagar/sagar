package com.WorkShop.sagar.models.Calender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;





public class AttendanceId implements Serializable {
    private int studentID;
    private LocalDate date;

    // Default constructor
    public AttendanceId() {}

    // Getters and setters...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttendanceId)) return false;
        AttendanceId that = (AttendanceId) o;
        return studentID == that.studentID && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, date);
    }
}