package com.app;

import java.util.Scanner;

public class Application {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int choice;
		do {
			System.out.println("...........Order Managment System................");

			System.out.println("1.Item panel");
			System.out.println("2.Customer panel");
			System.out.println("3.Order panel");
			System.out.println("4.Exit");

			System.out.println("Enter your choice panel");
			choice = sc.nextInt();
			switch (choice) 
			{
			case 1:ItemPanel.main(null);
			       break;
			       
			case 2:CustomerPanel.main(null); 
				   break;
				   
			case 3:OrderPanel.main(null);	
				   break;
				   
			case 4:System.exit(0);
				    break;
				    
			default: System.out.println("Error ");	    
			}
//			System.out.println("Do you want continue");
//			choice = sc.next().charAt(0);
		}
//		while (choice == 'y' || choice == 'Y');
		while(choice!=4);

	}

}
