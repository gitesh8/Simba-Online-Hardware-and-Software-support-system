package com.EmployeeUsecase;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exceptions.EmployeeException;
import com.model.Employee;

public class EmpLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner ip = new Scanner(System.in);
		
		
		System.out.print("Enter Username: ");
		String u = ip.nextLine();
		
		System.out.print("Enter Password: ");
		String p = ip.nextLine();
		
		EmployeeDao d = new EmployeeDaoImpl();
		
		try {
			Employee em = d.Login(u, p);
			
			System.out.println("\n"+"Welcome, "+em.getEmpname()+"\n");
			Menu.menu(em.getEmpid());
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
			
			main(args);
		}
		
		ip.close();

	}

}
