package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public  class EmployeePayrollDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
    public String name;
    @Min(value = 500, message = "Min Wage should be more than 500")
    public  long salary;

    public String gender;
    @JsonFormat(pattern = "dd MM yyyy")
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> department;
}