package com.logindetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.prodcutsinfo.Connectivity;
import com.prodcutsinfo.HomePage;

public class Login {

	// object of home page.
	HomePage obj1 = new HomePage();

	public void addLogin() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Login yourself.");

		System.out.println("Enter the username :");
		String name = sc.nextLine();

		System.out.println("Enter your password :");
		String password = sc.nextLine();

		Connection con = Connectivity.getConnection();

		try {
			PreparedStatement pt = con.prepareStatement("select * from register");

			ResultSet rs = pt.executeQuery();

			while (rs.next()) {
				if (name.equals(rs.getString(2)) && password.equals(rs.getString(4))) {
					System.out.println("Login Successfully.");

					obj1.listOfProduct();

				} else if (name.equals("admin") && password.equals("admin123")) {

					obj1.adminview();
					

				}

				else {
					System.err.println("Please register yourself or check username or password.");
					HomePage obj = new HomePage();
					obj.selectLogin();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
