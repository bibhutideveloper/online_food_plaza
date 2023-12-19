package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.dao.AdminDao;
import com.project.dto.AdminDTO;
import com.project.utility.DBConnection;

public class AdminDaoImplusingJdbc implements AdminDao {

	private Connection con;
	private PreparedStatement pstmt;
	
	@Override
	public boolean isAdminSave(AdminDTO admin) {
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("INSERT INTO ADMIN(USERNAME, PASSWORD) VALUES(?, ?)");
			pstmt.setString(1, admin.getUsername());
			pstmt.setString(2, admin.getPassword());
			int rows = pstmt.executeUpdate();
			
			return rows>0;
			
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
	public boolean isAdminDeleted(String username) {
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("DELETE FROM ADMIN WHERE USERNAME = ?");
			pstmt.setString(1, username);
			int rows = pstmt.executeUpdate();
			
			return rows>0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return false;
	}

}
