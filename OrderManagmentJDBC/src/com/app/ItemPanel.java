package com.app;

import java.util.Scanner;

import com.Dao.ItemDao;
import com.daoimpl.ItemImpl;


public class ItemPanel {

	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int ch ;
		
		do
		{
			System.out.println("............Item Panel..............");
			System.out.println("1. Add Item");
			System.out.println("2. Delete Item");
			System.out.println("3. Update Item cost");
			System.out.println("4. Display all items");
			System.out.println("5. Search item by id");
			System.out.println("6. Exit Item Panel");
			System.out.println("Enter your choice in Item panel");
			ch=sc.nextInt();
			
			ItemDao i=new ItemImpl();
			
			switch(ch)
			{
			
			case 1:i.additem();
					break;
			case 2:i.deleteitem();
			         break;
			case 3:i.updateitem();
			       break;
			case 4:i.displayAllitem();
			       break;
			case 5:i.getitemById(); 
			       break;
			case 6:Application.main(null);
			       break;
			default:System.out.println("Error");       
		    }
		System.out.println("Do you want continue with Item Panel");
		ch = sc.next().charAt(0);

	}while (ch == 'y' || ch == 'Y');

	
		
	}
}
