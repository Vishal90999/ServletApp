package com.vny.httpsession;

import java.io.Serializable;
//remember 4 thing while creating Bean
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
