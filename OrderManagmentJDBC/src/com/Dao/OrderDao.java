package com.Dao;

import com.entity.Order;

public interface OrderDao {
	
	public void addorder();
	public void deleteorder();
	public void updateorder();
	public Order getorderById();
	public void displayAllorder();

}
