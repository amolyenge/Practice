package com.demo.EmployeeCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.EmployeeCrud.dto.EmployeeDto;
import com.demo.EmployeeCrud.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService eservice;
	
	@GetMapping("/emp")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> elist = eservice.findAllEmployees();
		return ResponseEntity.ok(elist);
	}
	
	@GetMapping("/emp/{eid}")
	public ResponseEntity<EmployeeDto> getByID(@PathVariable int eid){
		EmployeeDto emp = eservice.findByID(eid);
		if(emp != null) {
			return ResponseEntity.ok(emp);
		}else {
			return (ResponseEntity<EmployeeDto>) ResponseEntity.notFound();
		}
	}
	
	@GetMapping("/emp/{lsal}/{hsal}")
	public ResponseEntity<List<EmployeeDto>> getBySal(@PathVariable double lsal , @PathVariable double hsal){
		List<EmployeeDto> elist = eservice.findBySal(lsal,hsal);
		if(elist != null) {
			return ResponseEntity.ok(elist);
		}else {
			return (ResponseEntity<List<EmployeeDto>>) ResponseEntity.notFound();
		}
	}
	
	@PostMapping("/emp")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto emp){
		boolean status = eservice.addEmp(emp);
		if(status) {
			return ResponseEntity.ok("Employee Added Successfully.");
		}else {
			return ResponseEntity.ok("Error Occured.");
		}
	}
	
	@PutMapping("/emp/{eid}")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto emp){
		boolean status = eservice.updateEmp(emp);
		if(status) {
			return ResponseEntity.ok("Employee Updated Successfully.");
		}else {
			return ResponseEntity.ok("Error Occured.");
		}
	}
	
	@DeleteMapping("/emp/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int eid){
		boolean status = eservice.deleteEmp(eid);
		if(status) {
			return ResponseEntity.ok("Employee Deleted Successfully");
		}else {
			return ResponseEntity.ok("Error Occured.");
		}
	}
	
	
}
