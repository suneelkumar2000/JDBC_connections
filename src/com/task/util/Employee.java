package com.task.util;

import java.sql.SQLException;

public interface Employee {
	public  void saveEmployee() throws ClassNotFoundException, SQLException;
	public  void deleteEmployee() throws ClassNotFoundException, SQLException;
}
