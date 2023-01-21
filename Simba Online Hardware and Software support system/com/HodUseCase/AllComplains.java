package com.HodUseCase;

import java.util.ArrayList;
import java.util.List;

import com.dao.HodDao;
import com.dao.HodDaoImpl;

import com.exceptions.HodException;
import com.model.Complains;

public class AllComplains {
	
	public static void main(String[] args) {
			
			List<Complains> ls = new ArrayList<>();
			
			HodDao d = new HodDaoImpl();
			
			try {
				ls = d.getComplains();
				if(ls.size()==0) {
					System.out.println("No Records, Available");
					Menu.main(args);
				}
				ls.forEach(n-> {
					
					if(n.getEngid()==0) {
						System.out.println("Complain Id: "+n.getCid()+"\n");
						
						System.out.println("Engineer Id : Enginner Not Assigned");
						System.out.println("Engineer Name : Enginner Not Assigned\n");
						
						System.out.println("Employee Id : "+n.getEmpid());
						System.out.println("Employee Name : "+n.getEmp_name()+"\n");
						
						System.out.println("Description : "+n.getDesc()+"\n");
						System.out.println("Category "+n.getCategory()+"\n");
						System.out.println("Status: "+n.getStatus()+"\n");
					}
					else {
					
					System.out.println("Complain Id: "+n.getCid()+"\n");
					
					System.out.println("Engineer Id : "+n.getEngid());
					System.out.println("Engineer Name : "+n.getEng_name()+"\n");
					
					System.out.println("Employee Id : "+n.getEmpid());
					System.out.println("Employee Name : "+n.getEmp_name()+"\n");
					
					System.out.println("Description : "+n.getDesc()+"\n");
					System.out.println("Category "+n.getCategory()+"\n");
					System.out.println("Status: "+n.getStatus()+"\n");
					
					}
					
					System.out.println("-----------------");
				});
				
				Menu.main(args);
				
			} catch (HodException e) {
				// TODO Auto-generated catch block
				System.out.println("\n"+e.getMessage()+" Try Again"+"\n");
				
			}
		}

}
