package com.WorkShop.sagar.repo.Repository;

import com.WorkShop.sagar.models.Calender.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, LocalDate> {

    @Query("SELECT c FROM Calendar c WHERE FUNCTION('MONTH', c.date) = :month AND " +
            "FUNCTION('YEAR', c.date) = :year AND c.dayOfWeek <> 'Saturday'")
    List<Calendar> findNonSaturdayDays(@Param("month") int month, @Param("year") int year);





        @Query("SELECT COUNT(c) FROM Calendar c " +
                "LEFT JOIN Attendance a ON c.date = a.date AND a.studentID = :studentID " +
                "WHERE FUNCTION('MONTH', c.date) = :month " +
                "AND FUNCTION('YEAR', c.date) = :year " +
                "AND c.dayOfWeek <> 'Saturday' " +
                "AND a.studentID IS NULL")
        long countNonSaturdayDaysWithoutAttendance(@Param("studentID") int studentID,
                                                   @Param("month") int month,
                                                   @Param("year") int year);



    }


