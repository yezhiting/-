package com.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import com.server.Client;

public class Flight implements Serializable{
	private String f_id;// 航班号
	public static String fid;
	private String f_scity;// 出发城市
	private String f_ecity;// 到达城市
	private String f_stime;// 出发时间
	private String f_etime;// 到达时间
	private String f_sdate;// 出发日期
	private String f_edate;// 到达日期

	public Flight(){
		
	}
	public Flight(String fId, String fSdate, String fEdate, String fScity, String fEcity, String fStime,
			String fEtime) {
		super();
		f_id = fId;
		f_sdate = fSdate;
		f_edate = fEdate;
		f_scity = fScity;
		f_ecity = fEcity;
		f_stime = fStime;
		f_etime = fEtime;
	}

	public static String getu() {
		return fid;
	}

	public static void setu(String fId) {
		fid = fId;
	}

	public String getF_id() {
		return f_id;
	}

	public void setF_id(String fId) {
		f_id = fId;
	}

	public String getF_scity() {
		return f_scity;
	}

	public void setF_scity(String fScity) {
		f_scity = fScity;
	}

	public String getF_ecity() {
		return f_ecity;
	}

	public void setF_ecity(String fEcity) {
		f_ecity = fEcity;
	}

	public String getF_stime() {
		return f_stime;
	}

	public void setF_stime(String fStime) {
		f_stime = fStime;
	}

	public String getF_etime() {
		return f_etime;
	}

	public void setF_etime(String fEtime) {
		f_etime = fEtime;
	}

	public String getF_sdate() {
		return f_sdate;
	}

	public void setF_sdate(String fSdate) {
		f_sdate = fSdate;
	}

	public String getF_edate() {
		return f_edate;
	}

	public void setF_edate(String fEdate) {
		f_edate = fEdate;
	}

	public ArrayList<Flight> viewData() throws IOException,
			ClassNotFoundException {
		Client c = new Client();
		return c.QueryFlight();
	
	}
	
}
