package com.model;

public class Employee {
     private int empid;
     private String empname;
     private String username;
     private String password;
     
     public Employee() {
    	 
     }
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee(int empid, String empname, String username, String password) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", username=" + username + ", password=" + password
				+ "]";
	}
     
     
}
