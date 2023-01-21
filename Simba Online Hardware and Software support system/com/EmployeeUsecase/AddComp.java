package com.EmployeeUsecase;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exceptions.EmployeeException;

public class AddComp {
	
	public static void addComp(int empid) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Complain Type (Hardware or Software)");
		String type = ip.next();
		ip.nextLine();
		
		System.out.println("Enter Complain Description");
		String cd = ip.nextLine();
		
		EmployeeDao ed = new EmployeeDaoImpl();
		
		try {
			System.out.println(ed.RegisterComp(empid, cd, type));
			System.out.println();
			Menu.menu(empid);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
			addComp(empid);
		}
		
		ip.close();
		
		
	}

}
