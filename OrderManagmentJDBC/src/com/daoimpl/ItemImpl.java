package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.DBconnection.JDBCconnection;
import com.Dao.ItemDao;
import com.entity.Item;

public class ItemImpl  implements ItemDao {

	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement ps;
	
	static Scanner sc=new Scanner(System.in);
	
	public ItemImpl()
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
	public void additem() {
		
		displayAllitem();
		System.out.println("...........................................");
		System.out.println("Enter Item id :");
		int Iid=sc.nextInt();
		System.out.println("Enter item name :");
		String name=sc.next();
		System.out.println("Enter item cost: ");
		float cost=sc.nextFloat();
		
		try
		{
			ps=con.prepareStatement("insert into item values(?,?,?)");
			ps.setInt(1, Iid);
			ps.setString(2, name);
			ps.setFloat(3, cost);
			if(ps.executeUpdate()>0)
					{
				      System.out.println("Item added");
					}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
			
	}

	@Override
	public void deleteitem() {
		
		displayAllitem();
		System.out.println("...........................................");
		System.out.println("Enter item id to be deleted :");
		int Iid=sc.nextInt();
		try
		{
			ps=con.prepareStatement("delete from item where item_id=?");
			ps.setInt(1, Iid);
			
		
			if(ps.executeUpdate()>0)
			{
				System.out.println("Item is delete......");
			}
			else
			{
				System.out.println("Error.....");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

	@Override
	public void updateitem() {
		displayAllitem();
		System.out.println("..................................................");
		System.out.println("Enter the ITem id to be updated:");
		int Iid=sc.nextInt();
		
		try
		{
			ps=con.prepareStatement("update item set cost=? where item_id=?");
			System.out.println("Enter new item cost");
			float icost=sc.nextFloat();
			ps.setFloat(1, icost);
			ps.setInt(2, Iid);
			if(ps.executeUpdate()>0)
			{
				System.out.println("Item cost Update");
			}
			else
			{
				System.out.println("Cost not update");
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	@Override
	public Item getitemById() {
		System.out.println("Enter the Item ID to display Item");
		int Iid=sc.nextInt();
		try
		{
			
			ps=con.prepareStatement("select * from item where item_id=?");
			ps.setInt(1, Iid);
			rs=ps.executeQuery();
			while(rs.next())
			{			
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));

			}		
	
	}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public void displayAllitem() {
		
		try
		{
			rs=st.executeQuery("select * from item");
			System.out.println("....................Item  Panel..................");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
		
	}



