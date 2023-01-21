package com.HodUseCase;

import java.util.List;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exceptions.HodException;
import com.model.Engineer;

public class EngineerList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HodDao hd = new HodDaoImpl();
		
		try {
			List<Engineer> l = hd.getEngineer();
			if(l.size()==0) {
				System.out.println("No Records, Available");
			}
			else {
				l.forEach(n->{
					System.out.println("Engineer Id: "+n.getEngid());
					System.out.println("Engineer Name: "+n.getEname());
					System.out.println("Engineer Category: "+n.getCategory());
					System.out.println("---------------------------------");
				});
				
			}
			
			
			
			Menu.main(args);
		} catch (HodException e) {
			// TODO Auto-generated catch block
			System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
		}

	}

}
