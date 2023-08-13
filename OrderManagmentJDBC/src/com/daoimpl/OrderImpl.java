package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.DBconnection.JDBCconnection;
import com.Dao.OrderDao;
import com.entity.Item;
import com.entity.Order;

public class OrderImpl implements OrderDao{
	
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement ps;
	Order r=new Order();
	Item i=new Item();
	
	static Scanner sc=new Scanner(System.in);
	
	public OrderImpl()
	{
		con=JDBCconnection.getConnection();
		
		try
		{
			st=con.createStatement();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void addorder() {
		
		System.out.println("Enter the order ID :");
		r.setOrder_id(sc.nextInt());
		System.out.println("Enter the customer id");
		r.setCid(sc.nextInt());
		System.out.println("Enter the item id: ");
		int Iid=sc.nextInt();
		r.setIid(Iid);
		System.out.println("Enter the quntity");
		int qty=sc.nextInt();
		r.setQuntity(qty);
	    System.out.println("Enter the Order Status");
	    r.setOrder_status(sc.next());
	    System.out.println("Enter the Payment Status");
	    r.setPay_status(sc.next());
	    
	    try
	    {
	    	ps=con.prepareStatement("select * from item");
	    	rs=ps.executeQuery();
	    	
	        float totalcost=0;
	    	while(rs.next())
	    	{
	    		if(rs.getInt(1)==Iid)
	    		{
	    			totalcost=rs.getFloat(3)*r.getQuntity();
	    		}
	    	}
	    	ps=con.prepareStatement("insert into orderdetails values(?,?,?,?,?,?,?)");
	    	ps.setInt(1, r.getOrder_id());
	    	ps.setInt(2, r.getCid());
	    	ps.setInt(3, r.getIid());
	    	ps.setInt(4, r.getQuntity());
	    	ps.setFloat(5, totalcost);
	    	ps.setString(6, r.getOrder_status());
	    	ps.setString(7, r.getPay_status());
	    	
	    	if(ps.executeUpdate()>0)
	    	{
	    		System.out.println("Order Added");
	    	}
	    	
	    	else
	    	{
	    		System.out.println("*****Error*****");
	    	}
	    }
	    catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

	@Override
	public void deleteorder() {
		
		displayAllorder();
		System.out.println("................................");
		System.out.println("Enter Order Id to be delete");
		int oid=sc.nextInt();
		
		try
		{
		    ps=con.prepareStatement("delete from orderdetails where order_id=?");
		    ps.setInt(1, oid);
		    
		    if(ps.executeUpdate()>0)
		    {
		    	System.out.println("Ordere deleted");
		    }
		    
		    else
		    {
		    	System.out.println("****Error******");
		    }
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateorder() {
		displayAllorder();
		System.out.println(".....................................");
		System.out.println("Enter the Order Id to be update");
		int oid=sc.nextInt();
		
		try
		{
			ps=con.prepareStatement("update orderdetails set qty=? where order_id=?");
			System.out.println("Enter new quntity");
			int qty=sc.nextInt();
			ps.setInt(1, qty);
			ps.setInt(2, oid);
			if(ps.executeUpdate()>0)
			{
				System.out.println("Order Quntity update");
			}
			else
			{
				System.out.println("Quntity not update");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Order getorderById() {
		System.out.println("Enter the Order ID to display order deatils");
		int oid=sc.nextInt();
		try
		{
			ps=con.prepareStatement("select * from orderdetails where order_id=?");
			ps.setInt(1, oid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getFloat(5)
				+" "+rs.getString(6)+" "+rs.getString(7));
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void displayAllorder() {
		
		try
		{
			rs=st.executeQuery("select * from orderdetails");
			System.out.println(".............Orderdetails...........");
			while(rs.next())
			{   
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getFloat(5)
				+" "+rs.getString(6)+" "+rs.getString(7));
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
