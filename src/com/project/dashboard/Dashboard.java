package com.project.dashboard;

import java.util.Scanner;

import com.project.controller.CartController;
import com.project.controller.OrderController;
import com.project.controller.ProductController;
import com.project.controller.UserController;

public class Dashboard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		
		do {
			System.out.println("Welcome to Dashboard\n======================");
			System.out.println("1. Select 1 for User \n2. Select 2 for Products \n3. Select 3 for Cart \n4. Select 4 for Order \n5. Select 5 for Exit");
			option = sc.nextInt();
			switch(option) {
			case 1: 
				new UserController();
				break;
			case 2: 
				new ProductController();
				break;
			case 3: 
				new CartController();
				break;
			case 4: 
				new OrderController();
				break;
			case 5: 
				System.out.println("5. Case 5 Executed \nExited Successfully");
				sc.close();
				System.exit(0);
			}
		}while(option !=5);
	}

}

