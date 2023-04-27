package cys.training.dao;

import java.sql.SQLException;

import cys.training.model.Student;



public interface StudentDAO {
	public int insertStudentDetails(Student std)throws ClassNotFoundException, SQLException;
	public int updateStudentAddress(int id,String address)throws ClassNotFoundException, SQLException;
	public int deleteStudentDetails(int id)throws ClassNotFoundException, SQLException;
	public void findByStudentName(String name)throws ClassNotFoundException, SQLException;
	public void findByStudentId(int id)throws ClassNotFoundException, SQLException;
	public void studentList()throws ClassNotFoundException, SQLException;

}
