package com.EmployeeUsecase;

import java.util.ArrayList;
import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exceptions.EmployeeException;
import com.model.Complains;

public class getComplainsDetails {
	
	public static void getcomp(int empid) {
		
		List<Complains> ls = new ArrayList<>();
		
		EmployeeDao d = new EmployeeDaoImpl();
		
		try {
			ls = d.getComp(empid);
			
			if(ls.size()==0) {
				System.out.println("\n No Complains Found \n");
				Menu.menu(empid);
			}
			ls.forEach(n-> {
				if(n.getEngid()==0) {
					System.out.println("Complain Id: "+n.getCid());
					System.out.println("Enginner Id: "+"Engineer Will Assign Shortly");
					System.out.println("Enginner Name: "+"Engineer Will Assign Shortly");
					System.out.println("Description : "+n.getDesc());
					System.out.println("Status: "+n.getStatus());
					
				}
				else {
					System.out.println("Complain Id: "+n.getCid());
					System.out.println("Enginner Id: "+n.getEngid());
					System.out.println("Enginner Name: "+n.getEng_name());
					System.out.println("Description : "+n.getDesc());
					System.out.println("Status: "+n.getStatus());
					
				}
				
				
				System.out.println("-----------------");
			});
			
			Menu.menu(empid);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
		}
	}

}
