package com.demo.EmployeeCrud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.EmployeeCrud.beans.Employee;
import com.demo.EmployeeCrud.dao.EmployeeDao;
import com.demo.EmployeeCrud.dto.EmployeeDto;
import com.demo.EmployeeCrud.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao edao;
	
	@Override
	public List<EmployeeDto> findAllEmployees() {
		List<Employee> elist = edao.findAll();
		List<EmployeeDto> elist1 = elist.stream()
				.map(emp -> EmployeeMapper.mapToEmployeeDto(emp))
				.collect(Collectors.toList());
		return elist1;
	}

	@Override
	public EmployeeDto findByID(int eid) {
		Optional<Employee> op = edao.findById(eid);
		if(op.isPresent()) {
			EmployeeDto emp = EmployeeMapper.mapToEmployeeDto(op.get());
			return emp;
		}
		 return null;
	}

	@Override
	public List<EmployeeDto> findBySal(double lsal, double hsal) {
		List<Employee> elist = edao.findBySal(lsal,hsal);
		if(elist.size() > 0) {
		  List<EmployeeDto> elist1 = elist.stream()
				.map(emp -> EmployeeMapper.mapToEmployeeDto(emp))
				.collect(Collectors.toList());
		  return elist1;
		}
		return null;
	}

	@Override
	public boolean addEmp(EmployeeDto emp) {
		Employee e = EmployeeMapper.mapToEmployee(emp);
		Employee e1 = edao.save(e);
		return e1 != null;
	}

	@Override
	public boolean updateEmp(EmployeeDto emp) {
		Employee e = EmployeeMapper.mapToEmployee(emp);
		Optional<Employee> op = edao.findById(e.getEid());
		if(op.isPresent()) {
			Employee e1 = op.get();
			e1.setEname(emp.getEname());
			e1.setSal(emp.getSal());
			e1.setDept(emp.getDept());
			edao.save(e1);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmp(int eid) {
		Optional<Employee> op = edao.findById(eid);
		if(op.isPresent()) {
			edao.delete(op.get());
			return true;
		}
		return false;
	}

}
