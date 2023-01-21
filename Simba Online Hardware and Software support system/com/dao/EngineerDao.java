package com.dao;

import java.util.List;

import com.exceptions.EngineerException;
import com.model.Complains;
import com.model.Engineer;

public interface EngineerDao {

	public Engineer engLogint(int engid, String password) throws EngineerException;
	public List<Complains> getComplains(int engid) throws EngineerException;
	public String updateCmpStatus(int engid, int cmpid, String s) throws EngineerException;
	public List<Complains> getCompletedCmp(int engid) throws EngineerException;
	public String ChangePass(int engid, String pass,String cpass) throws EngineerException;
}
