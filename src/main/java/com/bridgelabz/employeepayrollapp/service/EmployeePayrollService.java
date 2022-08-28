package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;

import java.util.List;

public interface EmployeePayrollService {
    List<Employee> getEmployeeDetails();
    Employee getEmployeeDetailsById(int empId);
    List<Employee> getEmployeeByDepartment(String department);
    Employee CreateEmployeeDetails(EmployeePayrollDto employeePayrollDto);
    Employee updateEmployeeDetails(int empId, EmployeePayrollDto employeePayrollDto);
    void deleteEmployeeDetails(int empId);
}
