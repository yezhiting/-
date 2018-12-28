package com.model;

public class Plane {
	private int p_id;
	private String f_id;
	private String p_scity;
	private String p_ecity;//到达城市
	private String p_stime;//出发时间
	private String p_etime;//到达时间
	private String p_sdate;//出发日期
	private String p_edate;//到达日期
	private String p_comp;//公司名
	private int[] p_seat = new int[35];
	public Plane(int pId, String fId, String pScity, String pEcity,
			String pStime, String pEtime, String pSdate, String pEdate,
			String pComp, int[] pSeat) {
		super();
		p_id = pId;
		f_id = fId;
		p_scity = pScity;
		p_ecity = pEcity;
		p_stime = pStime;
		p_etime = pEtime;
		p_sdate = pSdate;
		p_edate = pEdate;
		p_comp = pComp;
		p_seat = pSeat;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int pId) {
		p_id = pId;
	}
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String fId) {
		f_id = fId;
	}
	public String getP_scity() {
		return p_scity;
	}
	public void setP_scity(String pScity) {
		p_scity = pScity;
	}
	public String getP_ecity() {
		return p_ecity;
	}
	public void setP_ecity(String pEcity) {
		p_ecity = pEcity;
	}
	public String getP_stime() {
		return p_stime;
	}
	public void setP_stime(String pStime) {
		p_stime = pStime;
	}
	public String getP_etime() {
		return p_etime;
	}
	public void setP_etime(String pEtime) {
		p_etime = pEtime;
	}
	public String getP_sdate() {
		return p_sdate;
	}
	public void setP_sdate(String pSdate) {
		p_sdate = pSdate;
	}
	public String getP_edate() {
		return p_edate;
	}
	public void setP_edate(String pEdate) {
		p_edate = pEdate;
	}
	public String getP_comp() {
		return p_comp;
	}
	public void setP_comp(String pComp) {
		p_comp = pComp;
	}
	public int[] getP_seat() {
		return p_seat;
	}
	public void setP_seat(int[] pSeat) {
		p_seat = pSeat;
	}
	
	
}
