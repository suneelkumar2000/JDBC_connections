package com.task.util;

import java.sql.SQLException;

public interface Employee {
	public int saveEmployee() throws ClassNotFoundException, SQLException;
	public int updateEmployeeId(int value1,int value2) throws ClassNotFoundException, SQLException;
	public int updateEmployeeName(int value1, String value2) throws ClassNotFoundException, SQLException;
	public int updateEmployeeDepartment(int value1,String value2) throws ClassNotFoundException, SQLException;
	public int updateEmployeeSalary(int value1,int value2) throws ClassNotFoundException, SQLException;
	public int deleteEmployee() throws ClassNotFoundException, SQLException;
	public void employeeList() throws ClassNotFoundException, SQLException;
	public void findById(int id)throws ClassNotFoundException, SQLException;
	public void findByName(String name)throws ClassNotFoundException, SQLException;
	public void findByDepartment(String department)throws ClassNotFoundException, SQLException;
	public void findBySalary(int salary)throws ClassNotFoundException, SQLException;
}
