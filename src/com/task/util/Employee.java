package com.task.util;

import java.sql.SQLException;
import java.util.List;

public interface Employee {
	public int saveEmployee(EmployeePOJO employee) throws ClassNotFoundException, SQLException;
	public int updateEmployeeName(EmployeePOJO employee) throws ClassNotFoundException, SQLException;
	public int updateEmployeeDepartment(EmployeePOJO employee) throws ClassNotFoundException, SQLException;
	public int updateEmployeeSalary(EmployeePOJO employee) throws ClassNotFoundException, SQLException;
	public int deleteEmployee(EmployeePOJO employee) throws ClassNotFoundException, SQLException;
	public List<EmployeePOJO> employeeList() throws ClassNotFoundException, SQLException;
	public void findById(EmployeePOJO employee)throws ClassNotFoundException, SQLException;
	public void findByName(EmployeePOJO employee)throws ClassNotFoundException, SQLException;
	public void findByDepartment(EmployeePOJO employee)throws ClassNotFoundException, SQLException;
	public void findBySalary(EmployeePOJO employee)throws ClassNotFoundException, SQLException;
}
