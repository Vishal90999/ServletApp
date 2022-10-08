package com.vny.loginfilter;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LogBean implements Serializable{
	private String uName,pwd;
	
	public LogBean() {
		
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

}
