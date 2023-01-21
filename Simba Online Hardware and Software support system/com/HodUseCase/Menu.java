package com.HodUseCase;

import java.util.Scanner;



public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("1. Add new Engineer\n2. Delete Engineer\n3. Assign Complain\n4. All Complains\n5. All Engineers\n6. Main Menu\n7. Logout");
		
		Scanner ip = new Scanner(System.in);
		
		int val = ip.nextInt();
		
		switch(val) {
		case 1:
			RegisterNewEmp.main(args);
			break;
		case 2:
			DeleteEng.main(args);
			break;
		case 3:
			AssignProblemToEng.main(args);
			break;
		case 4:
			AllComplains.main(args);
		case 5:
			EngineerList.main(args);
		case 6:
			main.Main.main(args);
			break;
		case 7:
			System.out.println("Logged Out");
			break;
			default:
				System.out.println("Invalid Input, Try Again");
				Menu.main(args);
				break;
		}
		ip.close();

	}

}
