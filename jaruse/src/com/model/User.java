package com.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.TourView;

import com.usejdbc.Database;

public class User implements Serializable{
	private int u_id;//识别id
	private String u_pw;//密码
	private String u_tname;//姓名
	private String u_fname;//用户名
	private String u_iden;//身份证
	private String u_mail;//邮箱
	private String u_phone;//手机号
	private String u_power;
	private static String tname;
	private static int id;
	private static String power;
	public User(){
		
	}
	public User(int uId, String uPw, String uTname, String uFname,
			String uIden, String uMail, String uPhone, String uPower) {
		super();
		u_id = uId;
		u_pw = uPw;
		u_tname = uTname;
		u_fname = uFname;
		u_iden = uIden;
		u_mail = uMail;
		u_phone = uPhone;
		u_power = uPower;
	}
	public static String getT(){
		return tname;
	}
	public static void setT(String fName){
		tname = fName;
	}
	public static int getI(){
		return id;
	}
	public static void setP(String uPower){
		power = uPower;
	}
	public static String getP(){
		return power;
	}
	public static void setI(int uId){
		id = uId;
	}
	
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int uId) {
		u_id = uId;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String uPw) {
		u_pw = uPw;
	}
	public String getU_tname() {
		return u_tname;
	}
	public void setU_tname(String uTname) {
		u_tname = uTname;
	}
	public String getU_fname() {
		return u_fname;
	}
	public void setU_fname(String uFname) {
		u_fname = uFname;
	}
	public String getU_iden() {
		return u_iden;
	}
	public void setU_iden(String uIden) {
		u_iden = uIden;
	}
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String uMail) {
		u_mail = uMail;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String uPhone) {
		u_phone = uPhone;
	}
	public String getU_power() {
		return u_power;
	}
	public void setU_power(String uPower) {
		u_power = uPower;
	}
	
	public void signUp(Object[] param){
		Database db = new Database();
		String sql = "insert into user(u_fname,u_tname,u_iden,u_pw,u_mail,u_phone,u_power) values (?,?,?,?,?,?,?)";
		db.executUpdate(sql, param);
	}
	

	
}
