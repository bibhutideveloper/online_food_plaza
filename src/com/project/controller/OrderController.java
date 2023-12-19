package com.project.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.project.dto.OrderDTO;
import com.project.service.OrderService;
import com.project.service.impl.OrderServiceImpl;

public class OrderController {
	private int optionOrder = 0;
	Scanner sc = new Scanner(System.in);
	OrderService orderService = new OrderServiceImpl();
	{
		do {
			System.out.println("1. Select 1 Book an Order \n2. Cancel an Order \n3. Select 3 for Exit");
			optionOrder = 0;
			optionOrder = sc.nextInt();
			switch(optionOrder) {
			case 1:
				bookOrder();
				break;
			case 2:
				cancelOrder();
				break;
			case 3:
				System.out.println("Exited from Order Section Successfully...");
				break;
			}		
		}while(optionOrder != 3);
	}
	
	private void bookOrder() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter customer id: ");
			int customerId = sc.nextInt();
			System.out.println("Enter cart id: ");
			int cartId = sc.nextInt();
			System.out.println("Enter address: ");
			String address = br.readLine();
			System.out.println("Enter total bill: ");
			double totalBill = sc.nextDouble();
			System.out.println("Enter transaction type: ");
			String transactionType = br.readLine();
			OrderDTO order = new OrderDTO(customerId, cartId, address, totalBill, transactionType);
			boolean isOrderPlaced = orderService.isOrderPlaced(order);
			
			if(isOrderPlaced) {
				System.out.println("Order placed successfully.");
			}else {
				System.out.println("Something went wrong!\nFailed to place this order.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cancelOrder() {
		try {
			System.out.println("Enter order id: ");
			int orderId = sc.nextInt();
			OrderDTO order = new OrderDTO(orderId);
			boolean isOrderCancelled = orderService.isOrderCancelled(order);
			
			if(isOrderCancelled) {
				System.out.println("Order cancelled successfullly.");
			}else {
				System.out.println("Something went wrong!\nFailed to cancel this order.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
