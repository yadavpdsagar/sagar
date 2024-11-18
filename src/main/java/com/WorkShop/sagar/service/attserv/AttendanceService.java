package com.WorkShop.sagar.service.attserv;

import com.WorkShop.sagar.models.Calender.StudentAttendanceDto;
import com.WorkShop.sagar.repo.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<StudentAttendanceDto> getAllStudentAttendance() {
        return attendanceRepository.getAllStudentAttendanceDto();
    }

    public List<Object[]> getAttendanceCountPerStudent() {
        return attendanceRepository.getAttendanceCountPerStudent();
    }

    public List<Object[]> getAdjustedAttendanceCountPerStudent() {
        return attendanceRepository.getAdjustedAttendanceCountPerStudent();
    }

    public List<StudentAttendanceDto> getStudentAttendanceById(int studentId) {
        return attendanceRepository.getStudentAttendanceByStudentID(studentId);
    }

    public long getAttendanceCountByStudentId(int studentId) {
        return attendanceRepository.getAttendanceCountByStudentId(studentId);
    }
}