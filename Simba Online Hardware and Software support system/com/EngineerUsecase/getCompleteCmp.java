package com.EngineerUsecase;

import java.util.ArrayList;
import java.util.List;

import com.dao.EngineerDao;
import com.dao.EngineerDaoImpl;
import com.exceptions.EngineerException;
import com.model.Complains;


public class getCompleteCmp {
	
public static void getcompDetails(int engid) {
		
		List<Complains> ls = new ArrayList<>();
		
		EngineerDao d = new EngineerDaoImpl();
		
		try {
			ls = d.getCompletedCmp(engid);
			ls.forEach(n-> {
				
				System.out.println("-----------------");
				
				System.out.println("Complain Id: "+n.getCid());
				System.out.println("Description : "+n.getDesc());
				System.out.println("Category "+n.getCategory());
				System.out.println("Status: "+n.getStatus());
				
				System.out.println("-----------------");
			});
			
			Menu.menu(engid);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
			
		}
	}

}
