package com.WorkShop.sagar.repo;

import com.WorkShop.sagar.models.Calender.Attendance;
import com.WorkShop.sagar.models.Calender.AttendanceCountDTO;
import com.WorkShop.sagar.models.Calender.MyAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MyAttendanceRepository extends JpaRepository<MyAttendance, Integer> {

    @Query("SELECT COUNT(a) FROM MyAttendance a WHERE a.employee.employeeId = :employeeId AND " +
            "FUNCTION('MONTH', a.date) = :month AND FUNCTION('YEAR', a.date) = :year")
    long countByEmployeeIdAndMonth(@Param("employeeId") int employeeId,
                                   @Param("month") int month,
                                   @Param("year") int year);

      /// 1 step //countNonSaturdayDaysWithoutAttendance
    @Query("SELECT a FROM Attendance a WHERE a.studentID = :studentID AND " +
            "FUNCTION('MONTH', a.date) = :month AND FUNCTION('YEAR', a.date) = :year")
    List<Attendance> findAttendanceByStudentIdAndMonth(@Param("studentID") int studentID,
                                                       @Param("month") int month,
                                                       @Param("year") int year);



    @Query(value ="SELECT new com.WorkShop.sagar.models.Calender.AttendanceCountDTO(a.employee.employeeId, COUNT(a)) " +
            "FROM MyAttendance a " +
            "WHERE FUNCTION('MONTH', a.date) = :month " +
            "AND FUNCTION('YEAR', a.date) = :year " +
            "GROUP BY a.employee.employeeId" , nativeQuery = true)
    List<AttendanceCountDTO> countMyAttendanceByMonth(@Param("month") int month, @Param("year") int year);



}
