package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class EmployeePayrollDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
    public String name;
    @Min(value = 500, message = "Min Wage should be more than 500")
    public  long salary;

    public EmployeePayrollDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
