package com.task.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeImpl implements Employee{
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "suneel123");
		// System.out.println(con);
		return con;
	}

	@Override
	public void saveEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String q = "insert into employee_table values(1,'kumar',7397389818,20000)";
		PreparedStatement prepareStatement = con.prepareStatement(q);
		int executeUpdate = prepareStatement.executeUpdate();
		System.out.print(executeUpdate);
		System.out.println(" Inserted successfully");
	}

	@Override
	public void deleteEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String q = "delete from employee_table where id=1";
		PreparedStatement prepareStatement = con.prepareStatement(q);
		int executeUpdate = prepareStatement.executeUpdate();
		System.out.print(executeUpdate);
		System.out.println(" Deleted successfully");
	}

}
