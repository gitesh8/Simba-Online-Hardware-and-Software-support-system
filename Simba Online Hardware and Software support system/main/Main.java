package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Simba Online Hardware & Software Support System\n");
		
		
		System.out.println("1. HOD (Head of Department) Login\n2. Engineer Login\n3. Employee Login\n");

		Scanner ip = new Scanner(System.in);
		int val = ip.nextInt();
		
		switch(val) {
		case 1:
			menu(1,0);
			break;
		case 2:
			com.EngineerUsecase.Main.main(args);
			break;
		case 3 :
			com.EmployeeUsecase.Main.main(args);
			break;
		}
		
		
		ip.close();
		
	}
	public static void menu(int val,int count) {
		if(count==3) {
			System.out.println("\nToo Many Failed Attempts, Try after Sometime\n");
		}
		else {
			Scanner ip = new Scanner(System.in);
//			
			switch(val) {
			case 1:
				System.out.print("Enter Username: ");
				String u = ip.next();
				
				System.out.print("Enter Password: ");
				String p = ip.next();
				
				
				if(u.equals("Admin") && p.equals("Admin123")) {
					System.out.println("\nWelcome, HOD\n");
					com.HodUseCase.Menu.main(null);
				}
				else {
					System.out.println("\nInvalid Credentials\n");
					menu(1,count+1);
				}
			case 2:
				break;
			case 3 :
				com.EmployeeUsecase.Main.main(null);
			}
			
			ip.close();
			
			
			
		}
		
	}

}
