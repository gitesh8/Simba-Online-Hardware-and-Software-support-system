package com.EngineerUsecase;

import java.util.Scanner;

import com.dao.EngineerDao;
import com.dao.EngineerDaoImpl;
import com.exceptions.EngineerException;

public class UpdateCmpStatus {

	public static void update(int engid) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Complain Id ");
		int id = ip.nextInt();
		
		ip.nextLine();
		
		System.out.println("Enter Complain Status ");
		String S = ip.nextLine();
		
		EngineerDao ed = new EngineerDaoImpl();
		
		try {
			System.out.println(ed.updateCmpStatus(engid, id, S));
			
			Menu.menu(engid);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
		   UpdateCmpStatus.update(engid);
		}
		
		ip.close();
		
		
	}
}
