package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.dao.CartDao;
import com.project.dto.CartDTO;
import com.project.utility.DBConnection;

public class CartDaoImplUsingJdbc implements CartDao {
	
	private Connection con;
	private PreparedStatement pstmt;
	
	@Override
	public boolean isAddedtoCart(CartDTO cart) {
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("INSERT INTO CART(PRODUCT_ID, QUANTITY, PRICE, PAYMENT_STATUS, CUSTOMER_ID) VALUES(?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, cart.getProductId());
			pstmt.setInt(2, cart.getProductQuantity());
			pstmt.setDouble(3, cart.getTotalPrice());
			pstmt.setString(4, cart.getPaymentStatus());
			pstmt.setInt(5, cart.getCustomerId());
			
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				return true;
			}
			
		}catch(Exception e) {
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
	public boolean isDeletedFromCart(CartDTO cart) {
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("DELETE FROM CART WHERE PRODUCT_ID= ?");
			pstmt.setInt(1, cart.getProductId());
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				return true;
			}
			
		}catch(Exception e) {
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

}
