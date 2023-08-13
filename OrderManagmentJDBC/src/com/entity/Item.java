package com.entity;

public class Item {
	
	private int Item_id;
	private float cost;
	private String item_name;
	
	public Item(int item_id, float cost, String item_name) {
		
		this.Item_id = item_id;
		this.cost = cost;
		this.item_name = item_name;
	}

	public Item() {
		
	}

	public int getItem_id() {
		return Item_id;
	}

	public void setItem_id(int item_id) {
		Item_id = item_id;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float f) {
		this.cost = f;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	@Override
	public String toString() {
		return "Item [Item_id=" + Item_id + ", cost=" + cost + ", item_name=" + item_name + "]";
	}
	
	

}
