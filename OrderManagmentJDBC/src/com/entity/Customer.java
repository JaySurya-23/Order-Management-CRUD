package com.entity;

public class Customer {
	
	private int cid;
	private String fname;
	private String lname;
	private long moblie_no;
	private String email;
	private String address;
	
	public Customer()
	{
		
	}
	 
	public Customer(int cid, String fname, String lname, long moblie_no, String email, String address) {
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
		this.moblie_no = moblie_no;
		this.email = email;
		this.address = address;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public long getMoblie_no() {
		return moblie_no;
	}


	public void setMoblie_no(long moblie_no) {
		this.moblie_no = moblie_no;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", moblie_no=" + moblie_no
				+ ", email=" + email + ", address=" + address + "]";
	}
	
	
	
	

}
