package com.WorkShop.sagar.repo.Repository;

import com.WorkShop.sagar.models.Calender.Attendance;
import com.WorkShop.sagar.models.Calender.AttendanceId;
import com.WorkShop.sagar.models.Calender.StudentAttendanceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {

    // Query to get all attendance records joined with Calendar
    @Query( "SELECT new com.WorkShop.sagar.models.Calender.StudentAttendanceDto(a.studentID, a.date, a.punchIn, a.punchOut, c.dayOfWeek) " +
            "FROM Attendance a JOIN Calendar c ON a.date = c.date")
    List<StudentAttendanceDto> getAllStudentAttendanceDto();


    // Query to get  find ByEmpId ForMonth //



    // Query to get attendance count per student
    @Query("SELECT a.studentID, COUNT(*) AS attendanceCount " +
            "FROM Attendance a JOIN Calendar c ON a.date = c.date " +
            "GROUP BY a.studentID")
    List<Object[]> getAttendanceCountPerStudent();

    // Query to get adjusted attendance count per student
    @Query(value ="SELECT a.studentID, COUNT(*) AS attendanceCount, COUNT(*) * 3 AS adjustedAttendanceCount " +
            "FROM Attendance a JOIN Calendar c ON a.date = c.date " +
            "GROUP BY a.studentID" , nativeQuery = true)
    List<Object[]> getAdjustedAttendanceCountPerStudent();

    // Query to get attendance for a specific student
    @Query( value = "SELECT new com.WorkShop.sagar.models.Calender.StudentAttendanceDto(a.studentID, a.date, a.punchIn, a.punchOut, c.dayOfWeek)  FROM Attendance a JOIN Calendar c ON a.date = c.date WHERE a.studentID = :studentId "
             )
    List<StudentAttendanceDto> getStudentAttendanceByStudentID(@Param("studentId") Integer studentId);

    // Query to count attendance for a specific student
    @Query("SELECT COUNT(*) FROM Attendance a JOIN Calendar c ON a.date = c.date WHERE a.studentID = :studentId")
    long getAttendanceCountByStudentId(@Param("studentId") Integer studentId);
}
