package com.prodcutsinfo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectivity {
	
	static Connection con = null;

	public static Connection getConnection() {

		String DbURL = "jdbc:mysql://localhost:3306/ecommerce";
		String Dbusername = "root";
		String DbPassowrd = "Password#123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con=DriverManager.getConnection(DbURL, Dbusername, DbPassowrd);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}

}
