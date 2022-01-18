package com.ghassan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcConnection {

	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false"
				+ "&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to database: "+ jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful...");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
