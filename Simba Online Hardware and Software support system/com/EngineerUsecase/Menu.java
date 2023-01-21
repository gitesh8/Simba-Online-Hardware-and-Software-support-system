package com.EngineerUsecase;

import java.util.Scanner;

public class Menu {
	
public static void menu(int engid) {
		
		System.out.println("1. All Complains\n2. Update Complain Status\n3. Change Password\n4. Completed Complains\n5. Main Menu\n6. Logout");
		
		Scanner ip = new Scanner(System.in);
		
		int val = ip.nextInt();
		
		switch(val) {
		case 1:
			AllComplains.AllComp(engid);
			break;
		case 2:
			UpdateCmpStatus.update(engid);
			break;
		case 3:
			ChangePass.changePass(engid);
			break;
		case 4:
			getCompleteCmp.getcompDetails(engid);
		case 5:
			main.Main.main(null);
		case 6:
			System.out.println("Logged Out");
			break;
		default:
			System.out.println("Invalid Input, Try Again");
			Menu.menu(engid);
			break;
		}
		ip.close();
	}

}
