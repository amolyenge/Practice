package com.demo.EmployeeCrud.dto;

public class EmployeeDto {

	private int eid;
	private String ename;
    private double sal;
    private String hdate;
    private String dept;
    
	public EmployeeDto() {
		super();
	}

	public EmployeeDto(int eid, String ename, double sal, String hdate, String dept) {
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

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
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
		return "EmployeeDto [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", hdate=" + hdate + ", dept=" + dept
				+ "]";
	}
    
    
}
