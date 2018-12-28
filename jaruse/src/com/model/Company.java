package com.model;

public class Company {
	private int c_id;
	private String c_name;
	private String c_regist;
	public Company(int cId, String cName, String cRegist) {
		super();
		c_id = cId;
		c_name = cName;
		c_regist = cRegist;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int cId) {
		c_id = cId;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String cName) {
		c_name = cName;
	}
	public String getC_regist() {
		return c_regist;
	}
	public void setC_regist(String cRegist) {
		c_regist = cRegist;
	}
	
	
}
