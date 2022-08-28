package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Override
    public List<Employee> getEmployeeDetails() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public Employee getEmployeeDetailsById(int empId) {
        return employeePayrollRepository.findById(empId).orElseThrow( () -> new EmployeePayrollException("Employee with employee Id " + empId + " does not exists..!!"));
    }

    @Override
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeePayrollRepository.findEmployeeByDepartment(department);
    }

    @Override
    public Employee CreateEmployeeDetails(EmployeePayrollDto employeePayrollDto) {
        Employee employee = null;
        employee = new Employee(employeePayrollDto);
        log.debug("Emp Data: " + employee.toString());
        return employeePayrollRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeDetails(int empId, EmployeePayrollDto employeePayrollDto) {
        Employee empDetails = this.getEmployeeDetailsById(empId);
        empDetails.updateEmployeePayrollData(employeePayrollDto);
        return employeePayrollRepository.save(empDetails);
    }

    @Override
    public void deleteEmployeeDetails(int empId) {
        Employee empDetails = this.getEmployeeDetailsById(empId);
        employeePayrollRepository.delete(empDetails);
    }
}