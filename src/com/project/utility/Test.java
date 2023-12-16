package com.project.utility;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		Connection con = DBConnection.getConnection();
		if(con != null) {
			System.out.println("Connected...");
		}else {
			System.out.println("Not connected...");
		}

	}

}