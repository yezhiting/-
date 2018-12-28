package com.model;

import java.sql.ResultSet;

import com.usejdbc.Database;

public class Announcement {
	private String a_id;
	private String f_id;
	private String a_detail;
	private String a_time;
	public Announcement(){
		
	}
	
	public Announcement(String aid,String aTime,String aDetail) {
		super();
		a_id = aid;
		a_time = aTime;
		a_detail = aDetail;

	}
	
	public Announcement(String aid,String fId, String aDetail, String aTime) {
		super();
		a_id = aid;
		f_id = fId;
		a_detail = aDetail;
		a_time = aTime;
	}

	public String getF_id() {
		return f_id;
	}
	public void setF_id(String fId) {
		f_id = fId;
	}
	public String getA_detail() {
		return a_detail;
	}
	public void setA_detail(String aDetail) {
		a_detail = aDetail;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String aTime) {
		a_time = aTime;
	}
	
}
