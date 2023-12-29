package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.ProductDao;
import com.project.dto.ProductDTO;
import com.project.utility.DBConnection;

public class ProductDaoImplUsingJdbc implements ProductDao {

	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	@Override
	public boolean saveProduct(ProductDTO product) {
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("INSERT INTO PRODUCT(PRODUCT_NAME, PRODUCT_PRICE, CATEGORY_ID) VALUES(?, ?, ?)");
			
			pstmt.setString(1, product.getProductName());
			pstmt.setDouble(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductCtgId());
			
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean updateProduct(ProductDTO product) {
		try {
			con = DBConnection.getConnection();
			
			pstmt = con.prepareStatement("UPDATE PRODUCT SET PRODUCT_NAME= ?, PRODUCT_PRICE= ?, CATEGORY_ID= ? WHERE PRODUCT_ID= ?");
			
			pstmt.setString(1, product.getProductName());
			pstmt.setDouble(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductCtgId());
			pstmt.setInt(4, product.getProductId());
			
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteProduct(ProductDTO product) {
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_NAME = ?");
			
			pstmt.setString(1, product.getProductName());
			
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public ProductDTO searchProduct(String pName) {
		ProductDTO product = null;
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCT_NAME= ?");
			
			pstmt.setString(1, pName);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				// fetching from database and storing into variables then
				// created object for productDTO to transfer and then 
				// setting the data into that object
				int productId = rs.getInt("PRODUCT_ID");
				String productName = rs.getString("PRODUCT_NAME");
				double productPrice = rs.getDouble("PRODUCT_PRICE");
				int productCtgId = rs.getInt("CATEGORY_ID");
				
				product = new ProductDTO();
				product.setProductId(productId);
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				product.setProductCtgId(productCtgId);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public List<ProductDTO> showAllProduct() {
		List<ProductDTO> products = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT");
			
			while(rs.next()) {
				int productId = rs.getInt("PRODUCT_ID");
				String productName = rs.getString("PRODUCT_NAME");
				double productPrice = rs.getDouble("PRODUCT_PRICE");
				int productCtgId = rs.getInt("CATEGORY_ID");
				ProductDTO product = new ProductDTO(productId, productName, productPrice, productCtgId);
				products.add(product);
			}		
			
		}catch(Exception e){
			e.printStackTrace();
		}	
		return products;
	}

}
