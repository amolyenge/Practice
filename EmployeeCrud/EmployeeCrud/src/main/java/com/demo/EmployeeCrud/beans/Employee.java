package com.demo.EmployeeCrud.beans;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee1")
public class Employee {

	@Id
	private int eid;
	private String ename;
    private double sal;
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private LocalDate hdate;
    private String dept;
    
	public Employee() {
		super();
	}

	public Employee(int eid, String ename, double sal, LocalDate hdate, String dept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.hdate = hdate;
		this.dept = dept;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public LocalDate getHdate() {
		return hdate;
	}

	public void setHdate(LocalDate hdate) {
		this.hdate = hdate;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", hdate=" + hdate + ", dept=" + dept
				+ "]";
	}
    
    
}
