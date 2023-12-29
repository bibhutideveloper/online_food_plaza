package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.UserDao;
import com.project.dto.UserDTO;
import com.project.utility.DBConnection;

public class UserDaoImplUsingJdbc implements UserDao{
	
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;

	@Override
	public boolean saveUser(UserDTO user) {
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("INSERT INTO USERS(UNAME, UEMAIL, UPASSWORD) VALUES (?, ?, ?)");
			
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {con.close();}
				if(pstmt != null) {pstmt.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean updateUser(UserDTO user) {
		try {
			con = DBConnection.getConnection();
			StringBuilder query = new StringBuilder("UPDATE USERS SET ");
			
//			System.out.println("user: "+user);
			
			if(user.getName() != null && !user.getName().equals("")) {
				query.append("UNAME= ?, ");
			}
			if(user.getEmail() != null && !user.getEmail().equals("")) {
				query.append("UEMAIL= ?, ");
			}
			if(user.getPassword() != null && !user.getPassword().equals("")) {
				query.append("UPASSWORD= ?, ");
			}
			
			
//			if (user.getName() != null && !user.getName().trim().isEmpty()) {
//			    query.append("UNAME= ?, ");
//			}
//			if (user.getEmail() != null && !user.getEmail().trim().isEmpty()) {
//			    query.append("UEMAIL= ?, ");
//			}
//			if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
//			    query.append("UPASSWORD= ?, ");
//			}
			
//			System.out.println("1="+query);
			query.deleteCharAt(query.length()-2);
//			System.out.println("2="+query);
			query.append(" WHERE UID= ?");
			
			pstmt = con.prepareStatement(query.toString());
//			System.out.println("3="+query);
			
			int index = 1;
			
			if(user.getName() != null && !user.getName().equals("")) {
				pstmt.setString(index, user.getName());
				index++;
			}
			if(user.getEmail() != null && !user.getEmail().equals("")) {
				pstmt.setString(index, user.getEmail());
				index++;
			}
			if(user.getPassword() != null && !user.getPassword().equals("")) {
				pstmt.setString(index, user.getPassword());
				index++;
			}
			if(user.getId() != null) {
				pstmt.setInt(index, user.getId());
				index++;
			}
						
//			if (user.getName() != null && !user.getName().trim().isEmpty() && !user.getName().equals("null")) {
//			    pstmt.setString(index++, user.getName());
//			}
//			if (user.getEmail() != null && !user.getEmail().trim().isEmpty() && !user.getEmail().equals("null")) {
//			    pstmt.setString(index++, user.getEmail());
//			}
//			if (user.getPassword() != null && !user.getPassword().trim().isEmpty() && !user.getPassword().equals("null")) {
//			    pstmt.setString(index++, user.getPassword());
//			}
//			if (user.getId() != null) {
//			    pstmt.setInt(index++, user.getId());
//			}
	
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {con.close();}
				if(pstmt != null) {pstmt.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteUser(String email) {
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("DELETE FROM USERS WHERE UEMAIL= ?");
			
			pstmt.setString(1, email);
			
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {con.close();}
				if(pstmt != null) {pstmt.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<UserDTO> searchUser(String email) {
		List<UserDTO> users = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM USERS WHERE UEMAIL= ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("UID");
				String name = rs.getString("UNAME");
				String uemail = rs.getString("UEMAIL");
				String password = rs.getString("UPASSWORD");
				UserDTO user = new UserDTO(id, name, uemail, password);
				users.add(user);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {con.close();}
				if(stmt != null) {stmt.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	@Override
	public List<UserDTO> showAllUser() {
		List<UserDTO> users = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM USERS");
			
			while(rs.next()) {
				int id = rs.getInt("UID");
				String name = rs.getString("UNAME");
				String email = rs.getString("UEMAIL");
				String password = rs.getString("UPASSWORD");
				UserDTO user = new UserDTO(id, name, email, password);
				users.add(user);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {con.close();}
				if(stmt != null) {stmt.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return users;
	}

}
