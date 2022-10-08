package com.vny.product;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable
{
     private String pCode;
     private String pName;
     private float pprice;
     private int pqty;
     
	public ProductBean() 
	{
		super();
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public float getPprice() {
		return pprice;
	}

	public void setPprice(float pprice) {
		this.pprice = pprice;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
     
     
	
}
