package com.entity;

public class Order {
	
	private int order_id;
	private int cid;
	private int Iid;
	private int quntity;
	private float totalcost;
	private String order_status;
	private String pay_status;
	
	public Order()
	{
		
	}
	public Order(int order_id, int cid, int iid, int quntity, String order_status, String pay_status) {
		
		this.order_id = order_id;
		this.cid = cid;
		this.Iid = iid;
		this.quntity = quntity;
		//this.totalcost = totalcost;
		this.order_status = order_status;
		this.pay_status = pay_status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getIid() {
		return Iid;
	}
	public void setIid(int iid) {
		Iid = iid;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	public float getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(float totalcost) {
		this.totalcost = totalcost;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getPay_status() {
		return pay_status;
	}
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", cid=" + cid + ", Iid=" + Iid + ", quntity=" + quntity + ", totalcost="
				+ totalcost + ", order_status=" + order_status + ", pay_status=" + pay_status + "]";
	}
	
	
	
	

}
