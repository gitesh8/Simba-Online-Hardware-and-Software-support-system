package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exceptions.EmployeeException;
import com.model.Complains;
import com.model.Employee;
import com.utility.Dbcon;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String RegisterEmp(String username, String password, String name) throws EmployeeException {
		// TODO Auto-generated method stub
		
		String message="Signup Failed, Please Try Again Later";
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("insert into employee (empname,username,password) values (?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Signup Sucess, Login with your Credentials";
			}

			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		return message;
	}

	@Override
	public Employee Login(String username, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Employee e = new Employee();
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("select * from employee where username=? AND password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet r = ps.executeQuery();
			
			if(r.next()) {
				e.setEmpid(r.getInt("empid"));
				e.setEmpname(r.getString("empname"));
			}
			else {
				throw new EmployeeException("Invalid Credentials");
			}
			
		} catch (SQLException e2) {
			// TODO: handle exception
			throw new EmployeeException(e2.getMessage());
		}
		
		return e;
	}

	@Override
	public String RegisterComp(int empid, String desc, String category) throws EmployeeException {
		// TODO Auto-generated method stub
		String message = "Complain Registration Failed";
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("insert into complains (empid,engid,category,status,description) values (?,NULL,?,?,?) ");
			
			ps.setInt(1, empid);
			ps.setString(2, category);
			ps.setString(3, "Pending");
			ps.setString(4, desc);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Complain Raised Successfully, An Engineer Will Assign Shortly";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<Complains> getComp(int empid) throws EmployeeException {
		// TODO Auto-generated method stub
		
		List<Complains> ls = new ArrayList<>();
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("select en.engid,c.cid, e.empid, c.description,c.category,c.status,en.ename from complains c  left join employee e  on e.empid=c.empid left join engineer en on en.engid=c.engid where e.empid=?");
			
			ps.setInt(1, empid);
			
			ResultSet s = ps.executeQuery();
			
			while(s.next()) {
				Complains c = new Complains();
				c.setCid(s.getInt("cid"));
				c.setEng_name(s.getString("ename"));
				c.setStatus(s.getString("status"));
				c.setDesc(s.getString("description"));
				c.setEngid(s.getInt("engid"));
				c.setCategory(s.getString("category"));
				
				ls.add(c);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		return ls;
	}

	@Override
	public String Changepass(int empid, String pass, String cpass) throws EmployeeException {
		// TODO Auto-generated method stub
		
		String m = "Failed to Change Password, Try Again";
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("update employee set password=? where empid=? AND password=?");
			
			ps.setString(1, pass);
			ps.setInt(2, empid);
			ps.setString(3, cpass);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				m = "Password Changed, Login Again";
			}
			else {
				throw new EmployeeException("Current Password Not Matched with our Records");
				
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		return m;
	}

}
