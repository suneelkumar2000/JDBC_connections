package com.task.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeImpl implements Employee {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "suneel123");
		return con;
	}

	@Override
	public int saveEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee Id: ");
		int id = sc.nextInt();
		System.out.print("Enter Employee name: ");
		String name = sc.next();
		System.out.print("Enter Department: ");
		String department = sc.next();
		System.out.print("Enter Employee salary: ");
		int salary = sc.nextInt();
		
		String insert = "insert into employee_table values('" + id + "','" + name + "','" + department + "','" + salary+ "')";
		PreparedStatement prepareStatement = con.prepareStatement(insert);
		int execute = prepareStatement.executeUpdate();
		return execute;
	}
	
	@Override
	public int updateEmployeeId(int id, int newId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String update = "update employee_table set id ='"+newId+"' where id='"+id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(update);
		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
	}

	@Override
	public int updateEmployeeName(int id,String name) throws ClassNotFoundException, SQLException {
		
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String update = "update employee_table set name ='"+name+"' where id='"+id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(update);
		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
	}
	
	@Override
	public int updateEmployeeDepartment(int id, String department) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String update = "update employee_table set department ='"+department+"' where id='"+id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(update);
		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
	}
	
	@Override
	public int updateEmployeeSalary(int id, int salary) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String update = "update employee_table set salary ='"+salary+"' where id='"+id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(update);
		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
	}

	@Override
	public int deleteEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee id to delete: ");
		int id = sc.nextInt();
		Connection con = EmployeeImpl.getConnection();
		String delete = "delete from employee_table where id='"+id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(delete);
		int executedelete = prepareStatement.executeUpdate();
		return executedelete;
	}

	@Override
	public void employeeList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String display = "select id,name,department,salary from employee_table";
		PreparedStatement prepareStatement = con.prepareStatement(display);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
		}
	}

	@Override
	public void findById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String find = "select id,name,department,salary from employee_table where id='"+id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}
		
	}

	@Override
	public void findByName(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String find = "select id,name,department,salary from employee_table where name='"+name+"'";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}
	}

	@Override
	public void findByDepartment(String department) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String find = "select id,name,department,salary from employee_table where department='"+department+"'";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}
	}

	@Override
	public void findBySalary(int salary) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String find = "select id,name,department,salary from employee_table where salary='"+salary+"'";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}
	}

	
}
