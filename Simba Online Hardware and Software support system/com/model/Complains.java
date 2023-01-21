package com.model;

public class Complains {
	
	private int cid;
	private int empid;
	private int engid;
	private String desc;
	private String status;
	private String eng_name;
	private String emp_name;
	private String category;
	
	public Complains() {
		
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getEngid() {
		return engid;
	}

	public void setEngid(int engid) {
		this.engid = engid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEng_name() {
		return eng_name;
	}

	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Complains(int cid, int empid, int engid, String desc, String status, String eng_name, String emp_name,
			String category) {
		super();
		this.cid = cid;
		this.empid = empid;
		this.engid = engid;
		this.desc = desc;
		this.status = status;
		this.eng_name = eng_name;
		this.emp_name = emp_name;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Complains [cid=" + cid + ", empid=" + empid + ", engid=" + engid + ", desc=" + desc + ", status="
				+ status + ", eng_name=" + eng_name + ", emp_name=" + emp_name + ", category=" + category + "]";
	}

	
}
