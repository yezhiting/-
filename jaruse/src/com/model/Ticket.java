package com.model;

/**
 * @author FLLFFL
 * @category ��Ʊ��
 */
public class Ticket {
	private int t_id;//��Ʊid
	private String t_seat;//��λ��
	private int p_id;//�����ɻ���
	private String f_id;//�����
	private String u_tname;//����
	private String t_scity;//��������
	private String t_ecity;//�������
	private String t_stime;//����ʱ��
	private String t_etime;//����ʱ��
	private String t_sdate;//��������
	private String t_edate;//��������
	public Ticket(int tId, String tSeat, int pId, String fId, String uTname,
			String tScity, String tEcity, String tStime, String tEtime,
			String tSdate, String tEdate) {
		super();
		t_id = tId;
		t_seat = tSeat;
		p_id = pId;
		f_id = fId;
		u_tname = uTname;
		t_scity = tScity;
		t_ecity = tEcity;
		t_stime = tStime;
		t_etime = tEtime;
		t_sdate = tSdate;
		t_edate = tEdate;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int tId) {
		t_id = tId;
	}
	public String getT_seat() {
		return t_seat;
	}
	public void setT_seat(String tSeat) {
		t_seat = tSeat;
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
	public String getU_tname() {
		return u_tname;
	}
	public void setU_tname(String uTname) {
		u_tname = uTname;
	}
	public String getT_scity() {
		return t_scity;
	}
	public void setT_scity(String tScity) {
		t_scity = tScity;
	}
	public String getT_ecity() {
		return t_ecity;
	}
	public void setT_ecity(String tEcity) {
		t_ecity = tEcity;
	}
	public String getT_stime() {
		return t_stime;
	}
	public void setT_stime(String tStime) {
		t_stime = tStime;
	}
	public String getT_etime() {
		return t_etime;
	}
	public void setT_etime(String tEtime) {
		t_etime = tEtime;
	}
	public String getT_sdate() {
		return t_sdate;
	}
	public void setT_sdate(String tSdate) {
		t_sdate = tSdate;
	}
	public String getT_edate() {
		return t_edate;
	}
	public void setT_edate(String tEdate) {
		t_edate = tEdate;
	}
	
	
}
