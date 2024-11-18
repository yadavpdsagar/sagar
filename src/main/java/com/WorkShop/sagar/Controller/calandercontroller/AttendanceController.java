package com.WorkShop.sagar.Controller.calandercontroller;

import com.WorkShop.sagar.models.Calender.StudentAttendanceDto;
import com.WorkShop.sagar.service.attserv.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/all")
    public List<StudentAttendanceDto> getAllStudentAttendance() {
        return attendanceService.getAllStudentAttendance();
    }

    @GetMapping("/count")
    public List<Object[]> getAttendanceCountPerStudent() {
        return attendanceService.getAttendanceCountPerStudent();
    }

    @GetMapping("/adjusted-count")
    public List<Object[]> getAdjustedAttendanceCountPerStudent() {
        return attendanceService.getAdjustedAttendanceCountPerStudent();
    }

    @GetMapping("/{studentId}")
    public List<StudentAttendanceDto> getStudentAttendance(@PathVariable int studentId) {
        return attendanceService.getStudentAttendanceById(studentId);
    }

    @GetMapping("/{studentId}/count")
    public long getAttendanceCount(@PathVariable int studentId) {
        return attendanceService.getAttendanceCountByStudentId(studentId);
    }
}
