package com.project.controller;

import java.util.Scanner;

public class CartController {
	private int optionCart = 0;
	Scanner sc = new Scanner(System.in);
	{
		System.out.println("1. Select 1 Add to Cart \n2. Delete from Cart \n3. Select 3 for Exit");
		optionCart = 0;
		do {
			optionCart = sc.nextInt();
			switch(optionCart) {
			case 1:
				System.out.println("Add to Cart");
				break;
			case 2:
				System.out.println("Delete from Cart");
				break;
			case 3:
				System.out.println("Exited from Cart Section Successfully...");
				break;
			}		
		}while(optionCart != 3);
	}
}
