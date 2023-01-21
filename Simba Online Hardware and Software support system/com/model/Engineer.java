package com.model;

public class Engineer {
	
	private int engid;
	private String ename;
	private String category;
	
	public Engineer() {
		
	}

	public Engineer(int engid, String ename, String category) {
		super();
		this.engid = engid;
		this.ename = ename;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Engineer [engid=" + engid + ", ename=" + ename + ", category=" + category + "]";
	}

	public int getEngid() {
		return engid;
	}

	public void setEngid(int engid) {
		this.engid = engid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
