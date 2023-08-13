package com.app;

import java.util.Scanner;

import com.Dao.CustomerDao;
import com.daoimpl.CustomerDaoimpl;
import com.entity.Customer;

public class CustomerPanel {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int ch;
		do {
			System.out.println("..........Customer panel..........");
			System.out.println("1. Add Customer");
			System.out.println("2. Delete Customer");
			System.out.println("3. Update Customer mobile number");
			System.out.println("4. Display all Customers");
			System.out.println("5. Search Customer by id");
			System.out.println("6. Exit Customer Panel");
			System.out.println("Enter your choice in Customer panel");
			
	     	CustomerDao cd=new CustomerDaoimpl();
			ch = sc.nextInt();
			Customer c=new  Customer();
			
			switch (ch) {

			case 1:System.out.println("Enter the Customer id:");
					c.setCid(sc.nextInt());
					System.out.println("Enter First Name :");
					c.setFname(sc.next());
					System.out.println("Enter the last Name :");
					c.setLname(sc.next());
					System.out.println("Enter the Mobile Number :");
					c.setMoblie_no(sc.nextLong());
					System.out.println("Enter the email :");
					c.setEmail(sc.next());
					System.out.println("Enter the Address :");
					c.setAddress(sc.next());
					cd.addCustomer(c);
					break;
			case 2:System.out.println("Enter the Customer id to be delete");
			       int id=sc.nextInt();
			       cd.deleteCustomer(id);
			       break;
			case 3:System.out.println("Enter the customer id to be updated:");
                   id= sc.nextInt(); 
		           cd.updateCustomer(id);
		           break;       
			case 4:cd.displayAllCustomer();
				   break;
			case 5:System.out.println("Enter customer Id to be display");
				    id=sc.nextInt();
					c=cd.getCustomerById(id);
					if(c!=null)
					{
						System.out.println(c);
					}
					else
					{
						System.out.println("No customer with this id");
					}
					
			case 6:
				Application.main(null);
				break;
			default:
				System.out.println("Wrong choice");

			}

			System.out.println("Do you want continue with Customer Panel");
			ch = sc.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}

}
