package com.project.controller;

import java.util.Scanner;

public class ProductController {
	private int optionProduct = 0;
	Scanner sc = new Scanner(System.in);
	{
		System.out.println("1. Select 1 Add Product \n2. Select 2 Delete Product \n3. Select 3 Update Product \n4. Select 4 Show All Product \n5. Select 5 Show Any Product \n6. Select 6 for Exit");
		optionProduct = 0;
		do {
			optionProduct = sc.nextInt();
			switch(optionProduct) {
			case 1:
				System.out.println("Add Product");
				break;
			case 2:
				System.out.println("Delete Product");
				break;
			case 3:
				System.out.println("Update Product");
				break;
			case 4:
				System.out.println("Show All Product");
				break;
			case 5:
				System.out.println("Show Any Product");
				break;
			case 6:
				System.out.println("Exited from Product Section Successfully...");
				break;
			}		
		}while(optionProduct != 6);
	}
}
