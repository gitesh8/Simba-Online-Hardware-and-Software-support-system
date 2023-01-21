package com.EmployeeUsecase;

import java.util.Scanner;

public class Menu {
	
	public static void menu(int empid) {
		
		System.out.println("1. Raise Complain\n2. Complain History\n3. Change Password\n4. Main Menu\n5. Logout");
		
		Scanner ip = new Scanner(System.in);
		
		int val = ip.nextInt();
		
		switch(val) {
		case 1:
			AddComp.addComp(empid);
			break;
		case 2:
			getComplainsDetails.getcomp(empid);
			break;
		case 3:
			ChangePass.changePass(empid);
			break;
		case 4:
			Main.main(null);
		case 5:
			System.out.println("Logged Out");
			break;
			default:
				System.out.println("Invalid Input, Try Again");
				menu(empid);
				break;
		}
		ip.close();
	}

}
