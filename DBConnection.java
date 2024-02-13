package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String args[]) throws Exception {

		// prerequisists credintial
		String userName = "system";
		String pwd = "tiger";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";

		// load the driver class
		Connection con = null;
		try {
			// load the driver class.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// create the connection object
			con = DriverManager.getConnection(jdbcUrl, userName, pwd);
			
			// create the statement objecet
			Statement st = con.createStatement();
			
			System.out.println("Connection obj class = " + con.getClass());
			System.out.println("Statement obj class = " + st.getClass());
			
			int count = st.executeUpdate("update emp set SAL=SAL+100 where JOB='CLERK'");
			System.out.println("Record update successfully" + count);
			
			//create the object of ResultSet interface
			ResultSet rs = st.executeQuery("SELECT SAL FROM EMP WHERE JOB='CLERK'");
			System.out.println("Record fetch successfully"+rs); 
			  
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					System.out.println("Connection is eastiblished..");
					con.close();

				} else {
					System.out.println("Connection isn't eastiblished..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
