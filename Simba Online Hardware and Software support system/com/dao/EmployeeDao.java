package com.dao;

import java.util.List;

import com.exceptions.EmployeeException;
import com.model.Complains;
import com.model.Employee;

public interface EmployeeDao {
	
	public String RegisterEmp(String username, String password, String Name) throws EmployeeException;
	public Employee Login(String username, String password) throws EmployeeException;
	public String RegisterComp(int empid, String desc, String category) throws EmployeeException;
	public List<Complains> getComp(int empid) throws EmployeeException;
	public String Changepass(int empid, String pass, String cpass) throws EmployeeException;
	
	
	
	

}
