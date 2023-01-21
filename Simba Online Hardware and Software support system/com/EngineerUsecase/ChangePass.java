package com.EngineerUsecase;

import java.util.Scanner;

import com.dao.EngineerDao;
import com.dao.EngineerDaoImpl;
import com.exceptions.EngineerException;



public class ChangePass {
	public static void changePass(int engid) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Current Password");
		String cpass = ip.nextLine();
		
		System.out.println("Enter New Password");
		String pass = ip.nextLine();
		
		EngineerDao ed = new EngineerDaoImpl();
		
		try {
			System.out.println(ed.ChangePass(engid, pass, cpass));
		   Main.main(null);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
			changePass(engid);
		}
		
		ip.close();
		
	}

}
