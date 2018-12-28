package com.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import com.server.Client;

public class Company implements Serializable {
	private String c_id;
	private String c_name;
	private String c_regist;

	public Company() {

	}

	public Company(String cId, String cName, String cRegist) {
		super();
		c_id = cId;
		c_name = cName;
		c_regist = cRegist;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String cId) {
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

	public ArrayList<Company> viewData() throws IOException,
			ClassNotFoundException {
		Client c = new Client();
		return c.QueryComp();
	}



}
