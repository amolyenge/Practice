package com.demo.EmployeeCrud.service;

import java.util.List;

import com.demo.EmployeeCrud.dto.EmployeeDto;

public interface EmployeeService {

	List<EmployeeDto> findAllEmployees();

	EmployeeDto findByID(int eid);

	List<EmployeeDto> findBySal(double lsal, double hsal);

	boolean addEmp(EmployeeDto emp);

	boolean updateEmp(EmployeeDto emp);

	boolean deleteEmp(int eid);

}
