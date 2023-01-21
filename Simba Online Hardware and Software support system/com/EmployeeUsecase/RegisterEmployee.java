package com.EmployeeUsecase;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exceptions.EmployeeException;

public class RegisterEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Your Name ");
		String n = ip.nextLine();
		
		System.out.println("Select Username ");
		String u = ip.nextLine();
		
		System.out.println("Select Password ");
		String p = ip.nextLine();
		
		EmployeeDao d = new EmployeeDaoImpl();
		try {
			String S = d.RegisterEmp(u, p, n);
            System.out.println(S);
            
            Main.main(args);
            
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
			main(args);
		}
		
		
		ip.close();
		

	}

}
