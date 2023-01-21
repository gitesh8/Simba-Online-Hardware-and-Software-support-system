package com.EmployeeUsecase;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exceptions.EmployeeException;

public class ChangePass {

	public static void changePass(int empid) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Current Password");
		String cpass = ip.nextLine();
		
		System.out.println("Enter New Password");
		String pass = ip.nextLine();
		
		EmployeeDao ed = new EmployeeDaoImpl();
		
		try {
			System.out.println(ed.Changepass(empid, pass, cpass));
			EmpLogin.main(null);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
			changePass(empid);
		}
		
		ip.close();
		
	}

}
