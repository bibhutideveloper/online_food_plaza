package com.project.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.project.dto.AdminDTO;
import com.project.service.AdminService;
import com.project.service.impl.AdminServiceImpl;

public class AdminController {
	private int optionAdmin = 0;
	Scanner sc = new Scanner(System.in);
	AdminService adminService = new AdminServiceImpl();
	{
		do {
			System.out.println("1. Select 1 Add Admin \n2. Remove Admin \n3. Select 3 for Exit");
			optionAdmin = sc.nextInt();
			switch(optionAdmin) {
			case 1:
				isAdminSave();
				break;
			case 2:
				isAdminDeleted();
				break;
			case 3:
				System.out.println("Exited from Cart Section Successfully...");
				break;
			}		
		}while(optionAdmin != 3);
	}
	
	private void isAdminSave() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter admin username: ");
			String username = br.readLine();
			System.out.println("Enter password: ");
			String password = br.readLine();
			AdminDTO admin = new AdminDTO(username, password);
			boolean isAdminSave = adminService.isAdminSave(admin);
			
			if(isAdminSave) {
				System.out.println("Admin added to database.");
			}else {
				System.out.println("Something went wromg!\nFailed to add admin.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void isAdminDeleted() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter username");
			String username = br.readLine();
			boolean isAdminDeleted = adminService.isAdminDeleted(username);
			
			if(isAdminDeleted) {
				System.out.println("Admin removed successfully.");
			}else {
				System.out.println("Something went wromg!\nFailed to remove admin.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
