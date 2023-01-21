package com.dao;

import java.util.List;

import com.exceptions.HodException;
import com.model.Complains;
import com.model.Engineer;


public interface HodDao {
	
	public String RegisterNewEng(String ename, String c, String p) throws HodException;
	public List<Engineer> getEngineer() throws HodException;
	public String deleteEng(int engid) throws HodException;
	public List<Complains> getComplains() throws HodException;
	public String assignProblemToEng(int engid, int cmpid) throws HodException;
	
	

}
