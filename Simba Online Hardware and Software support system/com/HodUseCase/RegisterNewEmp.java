package com.HodUseCase;

import java.util.Scanner;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exceptions.HodException;

public class RegisterNewEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Engineer Name");
		String e = ip.nextLine();
		
		System.out.println("Enter Engineer Category");
		String c = ip.nextLine();
		
		System.out.println("Select Password for Engineer");
		String p = ip.nextLine();
		
		
		
		HodDao hd = new HodDaoImpl();
		
		try {
			System.out.println(hd.RegisterNewEng(e, c, p)+"\n");
			Menu.main(args);
		} catch (HodException e1) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e1.getMessage()+" Try Again"+"\n");
		}

		ip.close();
	}

}
