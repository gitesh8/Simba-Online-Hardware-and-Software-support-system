package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.exceptions.EngineerException;
import com.model.Complains;

import com.model.Engineer;
import com.utility.Dbcon;

public class EngineerDaoImpl implements EngineerDao{

	@Override
	public Engineer engLogint(int engid, String password) throws EngineerException {
		// TODO Auto-generated method stub
        Engineer en = new Engineer();
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("select * from engineer where engid=? AND password=?");
			
			ps.setInt(1, engid);
			ps.setString(2, password);
			
			ResultSet r = ps.executeQuery();
			
			if(r.next()) {
				en.setEname(r.getString("ename"));
			}
			else {
				throw new EngineerException("Invalid Credentials");
			}
			
		} catch (SQLException e2) {
			// TODO: handle exception
			throw new EngineerException(e2.getMessage());
		}
		
		return en;
	}

	@Override
	public List<Complains> getComplains(int engid) throws EngineerException {
		// TODO Auto-generated method stub
		List<Complains> ls = new ArrayList<>();
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("select c.cid, c.description, c.category, c.status from complains c inner join employee e on e.empid=c.empid where c.engid=?");
			
			ps.setInt(1, engid);
			
			ResultSet s = ps.executeQuery();
			
			while(s.next()) {
				Complains c = new Complains();
				c.setCid(s.getInt("cid"));
				c.setStatus(s.getString("status"));
				c.setDesc(s.getString("description"));
				c.setCategory(s.getString("category"));
				
				ls.add(c);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EngineerException(e.getMessage());
		}
		
		return ls;
	}

	@Override
	public String updateCmpStatus(int engid, int cmpid, String S) throws EngineerException {
		// TODO Auto-generated method stub
	String ls = "Update Failed, Please Try Again";
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("update complains set status=? where cid=? AND engid=?");
			
			ps.setString(1, S);
			ps.setInt(2, cmpid);
			ps.setInt(3, engid);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				ls = "Status Updated to"+S;
			}
			else {
				throw new EngineerException("\nInvalid Complain Id, Please Try Again\n");
			}
			
		
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EngineerException(e.getMessage());
		}
		
		return ls;
	}

	@Override
	public List<Complains> getCompletedCmp(int engid) throws EngineerException {
		// TODO Auto-generated method stub
		List<Complains> ls = new ArrayList<>();
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("select c.cid, c.description, c.category, c.status from complains c inner join employee e on e.empid=c.empid where c.engid=? AND c.status='Completed'");
			
			ps.setInt(1, engid);
			
			ResultSet s = ps.executeQuery();
			
			while(s.next()) {
				Complains c = new Complains();
				c.setCid(s.getInt("cid"));
				c.setStatus(s.getString("status"));
				c.setDesc(s.getString("description"));
				c.setCategory(s.getString("category"));
				
				ls.add(c);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EngineerException(e.getMessage());
		}
		
		return ls;
	}

	@Override
	public String ChangePass(int engid, String pass, String cpass) throws EngineerException {
		// TODO Auto-generated method stub
		String m = "Failed to Change Password, Try Again";
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("update engineer set password=? where engid=? AND password=?");
			
			ps.setString(1, pass);
			ps.setInt(2, engid);
			ps.setString(3, cpass);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				m = "Password Changed, Login Again";
			}
			else {
				throw new EngineerException("Current Password Not Matched with our Records");
				
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EngineerException(e.getMessage());
		}
		
		return m;
	}

}
