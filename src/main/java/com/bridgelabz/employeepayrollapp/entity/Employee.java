package com.bridgelabz.employeepayrollapp.entity;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "employee_payroll")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private  int employeeId;
    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_Department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    public Employee ( EmployeePayrollDto employeePayrollDto) {
        this.updateEmployeePayrollData(employeePayrollDto);
    }

    public Employee() {

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