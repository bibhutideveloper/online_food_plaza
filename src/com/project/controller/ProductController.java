package com.project.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.project.dto.ProductDTO;
import com.project.service.ProductService;
import com.project.service.impl.ProductServiceImpl;

public class ProductController {
	private int optionProduct = 0;
	ProductService productService = new ProductServiceImpl();
	Scanner sc = new Scanner(System.in);
	{
		do {
			System.out.println("1. Select 1 Add Product \n2. Select 2 Delete Product \n3. Select 3 Update Product \n4. Select 4 Show All Product \n5. Select 5 Show Any Product \n6. Select 6 for Exit");
			optionProduct = sc.nextInt();
			switch(optionProduct) {
			case 1:
				addProduct();
				break;
			case 2:
				deleteProduct();
				break;
			case 3:
				updateCart();
				break;
			case 4:
				showAllProduct();
				break;
			case 5:
				searchProduct();
				break;
			case 6:
				System.out.println("Exited from Product Section Successfully...");
				break;
			}		
		}while(optionProduct != 6);
	}
	
	private void addProduct() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter product name: ");
			String productName = br.readLine();
			System.out.println("Enter product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Enter product category id: ");
			int productCtgId = sc.nextInt();
			ProductDTO product = new ProductDTO(productName, productPrice, productCtgId);
			boolean isProductSaved = productService.saveProduct(product);
			
			if(isProductSaved) {
				System.out.println("Product added successfully.");
			}else {
				System.out.println("Something went wrong!\nFailed to add product.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteProduct() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter product name to delete: ");
			String productName = br.readLine();
			ProductDTO product = new ProductDTO(productName);
			boolean isProductDeleted = productService.deleteProduct(product);
			
			if(isProductDeleted) {
				System.out.println("Product deleted successfully.");
			}else {
				System.out.println("Something went wrong!\nFailed to delete product.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void updateCart() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter product id to update: ");
			int productId = sc.nextInt();
			System.out.println("Enter product name: ");
			String productName = br.readLine();
			System.out.println("Enter product price: ");
			double productPrice = Double.parseDouble(br.readLine());
			System.out.println("Enter product Category Id: ");
			int productCtgId = Integer.parseInt(br.readLine());
			ProductDTO product = new ProductDTO(productId, productName, productPrice, productCtgId);
			boolean isProductUpdated = productService.updateProduct(product);
			
			if(isProductUpdated) {
				System.out.println("Product updated successfully.");
			}else {
				System.out.println("Something went wrong!\nFailed to update product.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showAllProduct() {
		List<ProductDTO> products = productService.showAllProduct();
		
		for(ProductDTO productList : products) {
			System.out.println(productList);
		}
	}
	
	private void searchProduct() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter product name to search: ");
			String productName = br.readLine();
			ProductDTO product = productService.searchProduct(productName);
			
			System.out.println(product);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
		}
	}
}
