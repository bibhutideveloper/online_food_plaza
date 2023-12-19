package com.project.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.project.dto.CartDTO;
import com.project.service.CartService;
import com.project.service.impl.CartServiceImpl;

public class CartController {
	private int optionCart = 0;
	Scanner sc = new Scanner(System.in);
	CartService cartService = new CartServiceImpl();
	{
		do {
			System.out.println("1. Select 1 Add to Cart \n2. Delete from Cart \n3. Select 3 for Exit");
			optionCart = sc.nextInt();
			switch(optionCart) {
			case 1:
				addToCart();
				break;
			case 2:
				isDeletedFromCart();
				break;
			case 3:
				System.out.println("Exited from Cart Section Successfully...");
				break;
			}		
		}while(optionCart != 3);
	}
	
	private void addToCart() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br= new BufferedReader(isr);
			System.out.println("Enter customer id: ");
			int customerId = sc.nextInt();
			System.out.println("Enter product id: ");
			int productId = sc.nextInt();
			System.out.println("Enter quantity: ");
			int productQuantity = sc.nextInt();
			System.out.println("Enter total price: ");
			double totalPrice = sc.nextDouble();
			System.out.println("Enter payment status: \ncash / card / online");
			String paymentStatus = br.readLine();
			CartDTO cart = new CartDTO(customerId, productId, productQuantity, totalPrice, paymentStatus);
			boolean isAddedToCart = cartService.isAddedToCart(cart);
			
			if(isAddedToCart) {
				System.out.println("Product added to cart successfully.");
			}else {
				System.out.println("Something went wrong!\nFailed to add to cart.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void isDeletedFromCart() {
		try {
			System.out.println("Enter product id: ");
			int productId = sc.nextInt();
			CartDTO cart = new CartDTO(productId);
			
			boolean isDeletedFromCart = cartService.isDeletedFromCart(cart);
			
			if(isDeletedFromCart) {
				System.out.println("Item removed from cart successfully.");
			}else {
				System.out.println("Something went wrong!\nFailed to remove item from cart.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
