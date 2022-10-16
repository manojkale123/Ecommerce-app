package com.prodcutsinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.logindetails.Login;
import com.logindetails.Register;

public class HomePage {

	public void listOfProduct() {

		/// get the connection

		Connection con = Connectivity.getConnection();

		try {
			PreparedStatement pt = con.prepareStatement("SELECT * FROM products ORDER BY prod_name");
			ResultSet rs = pt.executeQuery();

			System.out.println("-----------------------------------");
			System.out.println("Please select product as per items list.");
			System.out.println("-----------------------------------");
			System.out.println("                                                ");

			System.out.println("Id  Description   Price   Product Name         ");

			while (rs.next()) {

				System.out.println(
						rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getInt(3) + "   " + rs.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void adminview() {

		Connection con = Connectivity.getConnection();

		Scanner sc = new Scanner(System.in);

		try {
			PreparedStatement pt = con.prepareStatement("SELECT * FROM products ORDER BY prod_name");
			ResultSet rs = pt.executeQuery();

			System.out.println("-----------------------------------");
			System.out.println("Please select product as per items list.");
			System.out.println("-----------------------------------");
			System.out.println("                                                ");

			System.out.println("Id  Description   Price   Product Name         ");

			while (rs.next()) {

				System.out.println(
						rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getInt(3) + "   " + rs.getString(4));
			}

			System.out.println("Enter product Id to check quantity.");
			int id = sc.nextInt();
			PreparedStatement pt1 = con.prepareStatement("SELECT prod_quantity FROM products where prod_id = ?");

			ResultSet rs1 = pt.executeQuery();

			while (rs1.next()) {
				System.out.println("Quantity of product :" + rs1.getInt(id));
				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void selectLogin() {

		Scanner sc = new Scanner(System.in);

		System.out.println("    Welcome to Ecommerce website.   ");

		System.out.println("--------------------------------");
		System.out.println("Please Login or Register");
		System.out.println("1 - Login");
		System.out.println("2 - Register");
		int choice = sc.nextInt();
		switch (choice) {

		case 1:
			// System.out.println("Login");
			Login login = new Login();
			login.addLogin();
			break;
		case 2:
			// System.out.println("Please Register");
			Register reg = new Register();
			reg.registeruser();
			break;
		}
	}

	public static void main(String[] args) {

		HomePage obj = new HomePage();
		// obj.listOfProduct();
		obj.selectLogin();
	}

}
