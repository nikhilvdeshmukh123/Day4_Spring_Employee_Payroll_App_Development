package com.bridgelabz.employeepayrollapp.entity;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Employee {
    private  int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> department;

    public Employee (int employeeId, EmployeePayrollDto employeePayrollDto) {
        this.employeeId = employeeId;
        this.updateEmployeePayrollData(employeePayrollDto);
    }

    public void updateEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        this.name = employeePayrollDto.name;
        this.salary = employeePayrollDto.salary;
        this.gender = employeePayrollDto.gender;
        this.note = employeePayrollDto.note;
        this.startDate = employeePayrollDto.startDate;
        this.profilePic = employeePayrollDto.profilePic;
        this.department = employeePayrollDto.department;
    }
}