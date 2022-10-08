//ProductBean
package com.vny.hiddenform;

import java.io.Serializable;
// Class must be implemented from serializable interface
@SuppressWarnings("serial")
public class ProductBean implements Serializable{
	// variable must be private
	private String pCode;
    private String pName;
    private float pprice;
    private int pqty;
    
    //0-constructor
    public ProductBean() {
    	
    }
    
    //getter and setter method
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
