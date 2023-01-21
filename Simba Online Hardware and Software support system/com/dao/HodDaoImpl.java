package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.exceptions.HodException;
import com.model.Complains;
import com.model.Engineer;
import com.utility.Dbcon;

public class HodDaoImpl implements HodDao {

	@Override
	public String RegisterNewEng(String ename, String c, String p) throws HodException {
		// TODO Auto-generated method stub
		String message="Engineer Registration Failed, Please Try Again Later";
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("insert into engineer (ename,category,password) values (?,?,?)");
			
			ps.setString(1, ename);
			ps.setString(2,c);
			ps.setString(3, p);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Engineer Registration, Success";
			}

			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new HodException(e.getMessage());
		}
		return message;
	}


	@Override
	public List<Engineer> getEngineer() throws HodException {
		// TODO Auto-generated method stub
		List<Engineer> ls = new ArrayList<>();
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("select * from engineer");
			
			
			ResultSet s = ps.executeQuery();
			
			while(s.next()) {
				Engineer c = new Engineer();
				
				c.setCategory(s.getString("category"));
				c.setEname(s.getString("ename"));
				c.setEngid(s.getInt("engid"));
				
				ls.add(c);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new HodException(e.getMessage());
		}
		
		return ls;
	}

	@Override
	public String deleteEng(int engid) throws HodException {
		// TODO Auto-generated method stub
		
		String m = "Failed";
		
		try(Connection con = Dbcon.getCon()) {
			PreparedStatement ps = con.prepareStatement("delete from engineer where engid=?");
			
			ps.setInt(1, engid);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				m = "Enginner Deleted With Id "+engid;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new HodException(e.getMessage());
		}
		return m;
	}

	@Override
	public List<Complains> getComplains() throws HodException {
		// TODO Auto-generated method stub
		List<Complains> ls = new ArrayList<>();
		
		try(Connection con = Dbcon.getCon()) {
			
			PreparedStatement ps = con.prepareStatement("select e.empid,e.empname,en.engid,c.cid, e.empid, c.description,c.category,c.status,en.ename from complains c  left join employee e  on e.empid=c.empid left join engineer en on en.engid=c.engid");
			
			ResultSet s = ps.executeQuery();
			
			while(s.next()) {
				Complains c = new Complains();
				c.setCid(s.getInt("cid"));
				c.setEngid(s.getInt("engid"));
				c.setEng_name(s.getString("ename"));
			    c.setEmpid(s.getInt("empid"));
			    c.setEmp_name(s.getString("empname"));
				c.setStatus(s.getString("status"));
				c.setDesc(s.getString("description"));
				c.setCategory(s.getString("category"));
				
				ls.add(c);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new HodException(e.getMessage());
		}
		
		return ls;
	}

	@Override
	public String assignProblemToEng(int engid, int cmpid) throws HodException {
		// TODO Auto-generated method stub
		String m = "Failed";
		
		try(Connection con = Dbcon.getCon()) {
			PreparedStatement ps = con.prepareStatement("update complains set engid=? where cid=?");
			
			ps.setInt(1, engid);
			ps.setInt(2, cmpid);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				m = "Complain Assigned to Enginner With Id "+engid;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new HodException(e.getMessage());
		}
		return m;
	}

}
