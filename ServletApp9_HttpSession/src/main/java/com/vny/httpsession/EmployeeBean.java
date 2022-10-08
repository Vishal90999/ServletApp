package com.vny.httpsession;

import java.io.Serializable;
//creating Bean Object
@SuppressWarnings("serial")
//Class must be implements Serializable interface
public class EmployeeBean implements Serializable {
	//All variable must be private
	private String eid,ename,job;
	private float sal;
	private int dno;
	//one 0-argument constructor
	public EmployeeBean() {
		
	}
    //Setter And Getter method
	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}
	

}
