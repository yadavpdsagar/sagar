package com.WorkShop.sagar.models.Calender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceCountDTO {
    private Integer employeeId;
    private int attendanceCount;


}
