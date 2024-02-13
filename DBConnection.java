package com.java.jdbc;

import java.sql.*;

public class DBConnection {
	public static void main(String args[]) throws Exception {
		
		// Database credentials
		String username = "system";
		String password = "tiger";
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String databaseUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";

		Connection connection = null;
		try {
			// Register JDBC driver
			//now oracle version 11g onwords we can't need of loading this jdbc driver, it will load automatically.
			Class.forName(jdbcDriver);

			// Open a connection
			connection = DriverManager.getConnection(databaseUrl, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Close the resources
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
