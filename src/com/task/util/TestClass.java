package com.task.util;

import java.sql.SQLException;

public class TestClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		EmployeeImpl object = new EmployeeImpl();
		object.saveEmployee();
		object.deleteEmployee();
	}
}
