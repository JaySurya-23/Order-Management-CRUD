package com.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCconnection {
	
	static Connection con=null;
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		  	
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdb","root","root");
	   	    
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static void main(String[] args) {
		
       getConnection();
	}

}
