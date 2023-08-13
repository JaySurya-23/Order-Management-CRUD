package com.app;

import java.util.Scanner;

import com.daoimpl.OrderImpl;

public class OrderPanel {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int ch;

		do {
			System.out.println("..................Order Panel..........");
            
			System.out.println("1. Add Order");
			System.out.println("2. Delete Order");
			System.out.println("3. Update Item quantity");
			System.out.println("4. Display all Orders");
			System.out.println("5. Search Order by id");
			System.out.println("6. Exit\n");
            System.out.println("*****Enter you choice in order panel*****");
			OrderImpl oi=new OrderImpl();
			ch = sc.nextInt();

			switch (ch) {
			
			case 1:oi.addorder();
			       break;
			case 2:oi.deleteorder();
			       break;
			case 3:oi.updateorder();       
			case 4:oi.displayAllorder();   
			       break;
			case 5:oi.getorderById();
			       break;
			case 6:Application.main(null);
			       break;
			default:
				System.out.println("Error");

			}

			System.out.println("Do you want continue with Order Panel");
			ch = sc.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}

}
