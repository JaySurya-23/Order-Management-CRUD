package com.Dao;

import com.entity.Item;


public interface ItemDao {
	
	
	public void additem();
	public void deleteitem();
	public void updateitem();
	public Item getitemById();
	public void displayAllitem();

}
