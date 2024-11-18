package com.WorkShop.sagar.Controller;

import com.WorkShop.sagar.models.Calender.AttendanceCountDTO;
import com.WorkShop.sagar.models.Calender.MyAttendance;
import com.WorkShop.sagar.service.MyAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/myattendance")
public class MyAttendanceController {

    @Autowired
    private MyAttendanceService myAttendanceService;

    @GetMapping
    public List<MyAttendance> getAllAttendance() {
        return myAttendanceService.getAllAttendance();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyAttendance> getAttendanceById(@PathVariable int id) {
        MyAttendance attendance = myAttendanceService.getAttendanceById(id);
        if (attendance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(attendance);
    }

    @PostMapping
    public MyAttendance createAttendance(@RequestBody MyAttendance attendance) {
        return myAttendanceService.createAttendance(attendance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyAttendance> updateAttendance(@PathVariable int id, @RequestBody MyAttendance attendanceDetails) {
        MyAttendance updatedAttendance = myAttendanceService.updateAttendance(id, attendanceDetails);
        if (updatedAttendance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAttendance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable int id) {
        myAttendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }




    @GetMapping("/count")
    public ResponseEntity<Long> countAttendanceByEmployeeIdAndMonth(
            @RequestParam int employeeId,
            @RequestParam int month,
            @RequestParam int year) {
        long count = myAttendanceService.countAttendanceByEmployeeIdAndMonth(employeeId, month, year);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/count/all")
    public ResponseEntity<List<AttendanceCountDTO>> getAllAttendanceCounts(
            @RequestParam int month,
            @RequestParam int year) {
        List<AttendanceCountDTO> counts = myAttendanceService.getAttendanceCountByMonth(month, year);
        return ResponseEntity.ok(counts);
    }

//    @GetMapping("/count-non-saturdays/{studentID}/{month}/{year}")
//    public ResponseEntity<Long> countNonSaturdays(
//            @PathVariable int studentID,
//            @PathVariable int month,  // Change this to int
//            @PathVariable int year) {
//        Month monthEnum = Month.of(month);  // Use Month.of(int month)
//        long count = myAttendanceService.countNonSaturdayDaysWithoutAttendance(studentID, monthEnum, year);
//        return ResponseEntity.ok(count);
//    }



    @GetMapping("/count-non-saturdays/{studentID}/{month}/{year}")
    public ResponseEntity<Long> countNonSaturdays(
            @PathVariable int studentID,
            @PathVariable int month,
            @PathVariable int year) {
        Month monthEnum = Month.of(month);
        long count = myAttendanceService.countNonSaturdayDaysWithoutAttendance(studentID, monthEnum, year);
        return ResponseEntity.ok(count);
    }





}

