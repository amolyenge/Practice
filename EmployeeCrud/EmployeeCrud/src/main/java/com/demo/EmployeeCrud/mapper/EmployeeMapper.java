package com.demo.EmployeeCrud.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.EmployeeCrud.beans.Employee;
import com.demo.EmployeeCrud.dto.EmployeeDto;

public class EmployeeMapper {

	public static Employee mapToEmployee(EmployeeDto emp) {
		return new Employee(emp.getEid(),emp.getEname(),emp.getSal(),LocalDate.parse(emp.getHdate(),DateTimeFormatter.ofPattern("dd/MM/yyyy")),emp.getDept());
	}
	
	public static EmployeeDto mapToEmployeeDto(Employee e) {
	    if(e.getHdate() == null) {
	    	return new EmployeeDto(e.getEid(),e.getEname(),e.getSal(),null,e.getDept());
	    }else {
	    	return new EmployeeDto(e.getEid(),e.getEname(),e.getSal(),e.getHdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),e.getDept());
	    }
	}
}
