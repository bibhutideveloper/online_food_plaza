package com.project.controller;

import java.util.Scanner;

public class OrderController {
	private int optionOrder = 0;
	Scanner sc = new Scanner(System.in);
	{
		System.out.println("1. Select 1 Book an Order \n2. Cancel an Order \n3. Select 3 for Exit");
		optionOrder = 0;
		do {
			optionOrder = sc.nextInt();
			switch(optionOrder) {
			case 1:
				System.out.println("Book an Order");
				break;
			case 2:
				System.out.println("Cancel an Order");
				break;
			case 3:
				System.out.println("Exited from Order Section Successfully...");
				break;
			}		
		}while(optionOrder != 3);
	}
}
