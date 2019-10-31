package com.javacourse.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FirstConnection {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(
			      "jdbc:mysql://localhost/sakila?serverTimezone=UTC", "root", "root");
		
		System.out.println(conn.isValid(1));
		conn.close();
	}
}
