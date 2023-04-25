package com.task.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeImpl implements Employee {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "suneel123");
		return con;
	}

	@Override
	public int saveEmployee(EmployeePOJO employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		Scanner sc = new Scanner(System.in);
		
		String insert = "insert into employee_table(id,name,department,salary) values(?,?,?,?)";
		PreparedStatement prepareStatement = con.prepareStatement(insert);
		
		prepareStatement.setInt(1,employee.getId());
		prepareStatement.setString(2,employee.getName());
		prepareStatement.setString(3,employee.getDepartment());
		prepareStatement.setInt(4,employee.getSalary());
		
		int execute = prepareStatement.executeUpdate();
		return execute;
	}

	@Override
	public int updateEmployeeName(EmployeePOJO employee) throws ClassNotFoundException, SQLException {
		
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String update = "update employee_table set name =? where id=?";
		PreparedStatement prepareStatement = con.prepareStatement(update);
		prepareStatement.setString(1,employee.getName());
		prepareStatement.setInt(2,employee.getId());
		
		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
	}
	
	@Override
	public int updateEmployeeDepartment(EmployeePOJO employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String update = "update employee_table set department =? where id=?";
		PreparedStatement prepareStatement = con.prepareStatement(update);
		prepareStatement.setString(1,employee.getDepartment());
		prepareStatement.setInt(2,employee.getId());
		
		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
	}
	
	@Override
	public int updateEmployeeSalary(EmployeePOJO employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String update = "update employee_table set salary =? where id=?";
		PreparedStatement prepareStatement = con.prepareStatement(update);
		prepareStatement.setInt(1,employee.getSalary());
		prepareStatement.setInt(2,employee.getId());
		
		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
	}

	@Override
	public int deleteEmployee(EmployeePOJO employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Connection con = EmployeeImpl.getConnection();
		String delete = "delete from employee_table where id=?";
		PreparedStatement prepareStatement = con.prepareStatement(delete);
		
		System.out.print("Enter Employee id to delete: ");
		employee.setId(sc.nextInt());
		prepareStatement.setInt(1,employee.getId());
		
		int executedelete = prepareStatement.executeUpdate();
		return executedelete;
	}

	@Override
	public List<EmployeePOJO> employeeList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String display = "select id,name,department,salary from employee_table";
		PreparedStatement prepareStatement = con.prepareStatement(display);
		ResultSet rs = prepareStatement.executeQuery();
		ArrayList List = new ArrayList();
		while (rs.next()) {
			int id= rs.getInt(1);
			String name = rs.getString(2);
			String department = rs.getString(3);
			int salary = rs.getInt(4);
			EmployeePOJO employee = new EmployeePOJO();
			employee.setId(id);
			employee.setName(name);
			employee.setDepartment(department);
			employee.setSalary(salary);
			List.add(employee);
		}
		return List;
	}

	@Override
	public void findById(EmployeePOJO employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String find = "select id,name,department,salary from employee_table where id=?";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		prepareStatement.setInt(1,employee.getId());
		
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}
		
	}

	@Override
	public void findByName(EmployeePOJO employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String find = "select id,name,department,salary from employee_table where name=?";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		prepareStatement.setString(1,employee.getName());
		
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}
	}

	@Override
	public void findByDepartment(EmployeePOJO employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String find = "select id,name,department,salary from employee_table where department=?";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		prepareStatement.setString(1,employee.getDepartment());
		
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}
	}

	@Override
	public void findBySalary(EmployeePOJO employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = EmployeeImpl.getConnection();
		String find = "select id,name,department,salary from employee_table where salary=?";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		prepareStatement.setInt(1,employee.getSalary());
		
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}
	}
}
