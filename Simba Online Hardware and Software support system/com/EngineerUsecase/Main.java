package com.EngineerUsecase;

import java.util.Scanner;

import com.dao.EngineerDao;
import com.dao.EngineerDaoImpl;
import com.exceptions.EngineerException;
import com.model.Engineer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Engineer Login\n");
		
	    System.out.print("Enter ID: ");
	    int engid = ip.nextInt();
	    
	    ip.nextLine();
	    
	    System.out.print("Enter Password: ");
	    String pass = ip.nextLine();
	    
	    EngineerDao en = new EngineerDaoImpl();
	    
	    try {
			Engineer e = en.engLogint(engid, pass);
			
			System.out.println("\nWelcome, "+e.getEname()+"\n");
			Menu.menu(engid);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"\n");
			com.EngineerUsecase.Main.main(args);
		}
	    
	    
		
		
		ip.close();
	}

}
