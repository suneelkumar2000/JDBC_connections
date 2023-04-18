package com.traning.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		getConnection();
		System.out.println(getConnection());
		createDepartment();
		showDepartment();
		insertDepartment();
		showDepartment();
		updateDepartment();
		showDepartment();
		deleteDepartment();
		showDepartment();
		dropDepartment();
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "suneel123");
		// System.out.println(con);
		return con;

	}

	public static void showDepartment() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement prepareStatement = con.prepareStatement("select * from Department");
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next())
			System.out.println(rs.getInt(1) + "  " + rs.getString(2));
		con.close();
	}

	public static void createDepartment() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		Statement stmt = con.createStatement();
		String q = "create table Department(id_no int(10),Name char(20))";
		stmt.executeUpdate(q);
		System.out.println("created table successfully");
	}

	public static void insertDepartment() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		String q1 = "insert into Department values(10,'Mee')";
		PreparedStatement prepareStatement = con.prepareStatement(q1);
		int executeUpdate = prepareStatement.executeUpdate();
		System.out.print(executeUpdate);
		System.out.println(" Inserted successfully");
	}

	public static void updateDepartment() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		String q2 = "update Department set Name='suneel' where id_no=10 ";
		PreparedStatement prepareStatement = con.prepareStatement(q2);
		int executeUpdate = prepareStatement.executeUpdate();
		System.out.print(executeUpdate);
		System.out.println(" Updated successfully");
	}

	public static void deleteDepartment() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		String q3 = "delete from Department where id_no=10";
		PreparedStatement prepareStatement = con.prepareStatement(q3);
		int executeUpdate = prepareStatement.executeUpdate();
		System.out.print(executeUpdate);
		System.out.println(" Deleted successfully");
	}

	public static void dropDepartment() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		String d = "drop table department";
		PreparedStatement prepareStatement = con.prepareStatement(d);
		prepareStatement.executeUpdate(d);
		System.out.println("Droped table successfully");
	}
}
