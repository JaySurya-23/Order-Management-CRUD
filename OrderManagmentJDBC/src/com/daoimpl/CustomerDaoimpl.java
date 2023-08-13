package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.DBconnection.JDBCconnection;
import com.Dao.CustomerDao;
import com.entity.Customer;

public class CustomerDaoimpl implements CustomerDao {

	
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement ps;
	
	static Scanner sc=new Scanner(System.in);
	
	
	public CustomerDaoimpl()
	{
		con=JDBCconnection.getConnection();
		
		
		try {
			st= con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	@Override
	public void addCustomer(Customer c) {

		try
		{
			ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			ps.setInt(1,c.getCid());
			ps.setString(2, c.getFname());
			ps.setString(3, c.getLname());
			ps.setLong(4, c.getMoblie_no());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getAddress());
			
			int numofRowadd=ps.executeUpdate();
			if(numofRowadd>0)
			{
				System.out.println("Customer added");
			}
			
			else {
				System.out.println("Error");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteCustomer(int cid) {
	      
		try
		{
			ps=con.prepareStatement("delete from customer where cid=?");
			ps.setInt(1, cid);
			
			int numofrowdelete=ps.executeUpdate();
			
			if(numofrowdelete>0)
			{
				System.out.println("customer is deleted....");
			}
			else
			{
				System.out.println("error..");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void updateCustomer(int cid) {
		try
	     {
	    	 Customer c= new Customer();
	    	 c= getCustomerById(cid);
	    	 if(c!=null)
	    	 {
	    	  System.out.println("Customer Old details are:...........................");	 
	         System.out.println(c);		
	         System.out.println(".....................................................");
	         System.out.println("Enter the new mobile number:");
	         long mno= sc.nextLong();
	    	 ps= con.prepareStatement("update customer set mobileno=? where cid=?");
	    	 ps.setLong(1, mno);
	    	 ps.setInt(2, cid);
	    	 
	    	 int noOfRowsUpdated= ps.executeUpdate();
	    	 if(noOfRowsUpdated>0)
	    	 {
	    		 System.out.println("Customer is updated........");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Error");
	    	 }
	    	
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Customer id doesnot exist..................");
	    	 }
	    	 
	     }
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }
		
	}

	@Override
	public Customer getCustomerById(int cid) {
		  try
		  {
			  ps=con.prepareStatement("select * from customer where cid=?");
			  ps.setInt(1, cid);
			   rs=ps.executeQuery();
			   if(rs.next())
			   {
				   Customer c= new Customer();
				   c.setCid(rs.getInt(1));
				   c.setFname(rs.getString(2));
				   c.setLname(rs.getString(3));
				   c.setMoblie_no(rs.getLong(4));
				   c.setEmail(rs.getString(5));
				   c.setAddress(rs.getString(6));
				   
				   return c;
			   }
			  
		  }
		  catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void displayAllCustomer() {
		try
		{
			rs=st.executeQuery("select * from customer");
			
			System.out.println(".......................................................");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getLong(4)+"  "+rs.getString(5)+"  "+rs.getString(6));

			}
			
			System.out.println("........................................................");
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
