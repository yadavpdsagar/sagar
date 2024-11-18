package com.WorkShop.sagar.service;

import com.WorkShop.sagar.models.Calender.Employeec;
import com.WorkShop.sagar.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employeec> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employeec getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employeec createEmployee(Employeec employee) {
        return employeeRepository.save(employee);
    }

    public Employeec updateEmployee(int id, Employeec employeeDetails) {
        Employeec employee = getEmployeeById(id);
        if (employee != null) {
            employee.setEmployeeUsername(employeeDetails.getEmployeeUsername());
            employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
            employee.setEmployeePassword(employeeDetails.getEmployeePassword());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}

