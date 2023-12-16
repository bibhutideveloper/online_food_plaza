package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;

public class UserController {
	private int optionUser = 0;
	Scanner sc = new Scanner(System.in);
	UserService userService = new UserServiceImpl();
	
	{
		do{
			System.out.println(
					"1. Select 1 Add User \n2. Select 2 Delete User \n3. Select 3 Update User \n4. Select 4 Show All User \n5. Select 5 Show Any User \n6. Select 6 for Exit");
			optionUser = sc.nextInt();
			switch (optionUser) {
			case 1:
				addUser();
				break;
			case 2:
				deleteUser();
				break;
			case 3:
				updateUser();
				break;
			case 4:
				showAllUser();
				break;
			case 5:
				searchUser();
				break;
			case 6:
				System.out.println("Exited from User Section Successfully...");
				break;
			}
		}while(optionUser!=6);
	}
	
	private void addUser() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			
			System.out.println("Enter name: ");
			String name = br.readLine();
			System.out.println("Enter email: ");
			String email = br.readLine();
			System.out.println("Enter password: ");
			String password = br.readLine();
			UserDTO user = new UserDTO(name, email, password);
			boolean isUserSaved = userService.saveUser(user);
			
			if(isUserSaved) {
				System.out.println("Data has been saved successfully.");
			}else {
				System.out.println("Something went wrong!\nFailed to save data.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteUser() {
		try {
			System.out.println("Enter email to delete: ");
			String email= sc.next();			
			boolean isUserDeleted = userService.deleteUser(email);
			
			if(isUserDeleted) {
				System.out.println("User deleted successfully.");
			}else {
				System.out.println("Something went wrong!\nFailed to delete user.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateUser() {
		InputStreamReader isr =  null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter Id: ");
			int id = sc.nextInt();
			System.out.println("Enter new name: ");
			String name = br.readLine();
			System.out.println("Enter new email: ");
			String email = br.readLine();
			System.out.println("Enter new password: ");
			String password = br.readLine();
			UserDTO user = new UserDTO(id, name, email, password);
			boolean isUserUpdated = userService.updateUSer(user);
			
			if(isUserUpdated) {
				System.out.println("User updated successfully.");
			}else {
				System.out.println("Something went wrong!\nFailed to update user.");
			}
			
		}catch(Exception e) {
			
		}
	}
	
	private void searchUser() {
		try {
			System.out.println("Enter email: ");
			String email = sc.next();
			UserDTO user = new UserDTO(email);
			
			List<UserDTO> users = userService.searchUser(email);
			
			for(UserDTO row : users) {
				System.out.println(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showAllUser() {
		List<UserDTO> users = userService.showAllUser();
		
		for(UserDTO user : users) {
			System.out.println(user);
		}
	}
}
