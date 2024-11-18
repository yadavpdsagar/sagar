package com.WorkShop.sagar.service;

import com.WorkShop.sagar.models.Calender.Attendance;
import com.WorkShop.sagar.models.Calender.AttendanceCountDTO;
import com.WorkShop.sagar.models.Calender.Calendar;
import com.WorkShop.sagar.models.Calender.MyAttendance;
import com.WorkShop.sagar.repo.MyAttendanceRepository;
import com.WorkShop.sagar.repo.Repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.time.Month;
import java.util.HashSet;

import java.util.Set;

@Service
public class MyAttendanceService {

    @Autowired
    private MyAttendanceRepository myAttendanceRepository;

    @Autowired
    private CalendarRepository calendarRepository ;

    public List<MyAttendance> getAllAttendance() {
        return myAttendanceRepository.findAll();
    }

    public MyAttendance getAttendanceById(int id) {
        return myAttendanceRepository.findById(id).orElse(null);
    }

    public MyAttendance createAttendance(MyAttendance attendance) {
        return myAttendanceRepository.save(attendance);
    }

    public MyAttendance updateAttendance(int id, MyAttendance attendanceDetails) {
        MyAttendance attendance = getAttendanceById(id);
        if (attendance != null) {
            attendance.setDate(attendanceDetails.getDate());
            attendance.setPunchIn(attendanceDetails.getPunchIn());
            attendance.setPunchOut(attendanceDetails.getPunchOut());
            attendance.setEmployee(attendanceDetails.getEmployee());
            return myAttendanceRepository.save(attendance);
        }
        return null;
    }

    public void deleteAttendance(int id) {
        myAttendanceRepository.deleteById(id);
    }



    public long countAttendanceByEmployeeIdAndMonth(int employeeId, int month, int year) {
        return myAttendanceRepository.countByEmployeeIdAndMonth(employeeId, month, year);
    }

    public List<AttendanceCountDTO> getAttendanceCountByMonth(int month, int year) {
        return myAttendanceRepository.countMyAttendanceByMonth(month, year);
    }

    public long countNonSaturdayDaysWithoutAttendance(int studentID, Month month, int year) {
        return calendarRepository.countNonSaturdayDaysWithoutAttendance(studentID, month.getValue(), year);
    }

//    public long countNonSaturdayDaysWithoutAttendance(int studentID, Month month, int year) {
//        // Get attendance records
//        List<Attendance> attendances = myAttendanceRepository.findAttendanceByStudentIdAndMonth(studentID, month.getValue(), year);
//        Set<LocalDate> attendedDates = new HashSet<>();
//        for (Attendance attendance : attendances) {
//            attendedDates.add(attendance.getDate());
//        }
//
//        // Get non-Saturday calendar days
//        List<Calendar> nonSaturdayDays = calendarRepository.findNonSaturdayDays(month.getValue(), year);
//
//        // Count non-Saturday days without attendance
//        return nonSaturdayDays.stream()
//                .filter(calendar -> !attendedDates.contains(calendar.getDate()))
//                .count();
//    }


}
