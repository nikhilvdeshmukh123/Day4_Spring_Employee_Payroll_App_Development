package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {
    @Autowired
    private EmployeePayrollService employeePayrollService;
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData(){
        List<Employee> employeeList = null;
        employeeList = employeePayrollService.getEmployeeDetails();
        ResponseDto responseDto = new ResponseDto("Get Call Sucess", employeeList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId")int empId){
        Employee employee = employeePayrollService.getEmployeeDetailsById(empId);
        ResponseDto responseDTO = new ResponseDto("Get Call For Id Sucessful", employee);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("department") String department){
        List<Employee> employeeList = null;
        employeeList = employeePayrollService.getEmployeeByDepartment(department);
        ResponseDto responseDTO = new ResponseDto("Get Call For Id Sucessful. ", employeeList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDto empPayrollDTO){
        log.debug("Employee DTO: " + empPayrollDTO.toString());
        Employee employee = employeePayrollService.CreateEmployeeDetails(empPayrollDTO);
        ResponseDto responseDTO = new ResponseDto("Created Employee Payroll Data Successfully:", employee);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@Valid @PathVariable("empId") int empId, @RequestBody EmployeePayrollDto empPayrollDTO){
        Employee employee = employeePayrollService.updateEmployeeDetails(empId, empPayrollDTO);
        ResponseDto responseDTO = new ResponseDto("Updated Employee Payroll Data Successfully:", employee);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId")int empId){
        employeePayrollService.deleteEmployeeDetails(empId);
        ResponseDto responseDTO = new ResponseDto("Deleted Successfully:","Delete Id:"+empId);
        return new ResponseEntity<ResponseDto>(responseDTO,HttpStatus.OK);
    }
}