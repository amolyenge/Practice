package com.demo.EmployeeCrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.EmployeeCrud.beans.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>{

	@Query(value="select * from employee1 where sal between :lsal and :hsal",nativeQuery=true)
	List<Employee> findBySal(double lsal, double hsal);

}
