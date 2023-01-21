package com.EmployeeUsecase;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Employee Login & Signup \n");
		System.out.println("1. Login\n2. Signup");
		
	    int val = ip.nextInt();
	    
	    if(val==1) {
	    	EmpLogin.main(args);
	    }
	    else if(val==2) {
	    	RegisterEmployee.main(args);
	    }
	    else {
	    	System.out.println("Invalid Input, Try Again\n");
	    	Main.main(args);
	    }
		
		ip.close();

	}

}
