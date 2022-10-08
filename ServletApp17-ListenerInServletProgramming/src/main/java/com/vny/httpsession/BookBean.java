package com.vny.httpsession;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookBean implements Serializable{
	//1.class must be implement from Serializable interface
	//2.variable must be private
	private String bcode,bname,bauthor;
	private float bprice;
	private int qty;
	//3. one 0-argument constructor
	public BookBean() {
		
	}
	// getter and setter method
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public float getBprice() {
		return bprice;
	}
	public void setBprice(float bprice) {
		this.bprice = bprice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	

}
