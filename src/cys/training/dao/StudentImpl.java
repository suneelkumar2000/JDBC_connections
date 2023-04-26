package cys.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cys.training.model.Student;
import cys.training.util.ConnectionUtil;

public class StudentImpl implements StudentDAO {

	@Override
	public int insertStudentDetails(Student std) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();

		String insert = "insert into Student_table(id,name,department,address) values(?,?,?,?)";
		PreparedStatement prepareStatement = con.prepareStatement(insert);

		prepareStatement.setInt(1, std.getId());
		prepareStatement.setString(2, std.getName());
		prepareStatement.setString(3, std.getDepartment());
		prepareStatement.setString(4, std.getAddress());

		int execute = prepareStatement.executeUpdate();
		return execute;
	}

	@Override
	public int updateStudentAddress(int id, String address) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update Student_table set address ='" + address + "' where id='" + id + "'";
		PreparedStatement prepareStatement = con.prepareStatement(update);

		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
	}

	@Override
	public int deleteStudentDetails(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from Student_table where id='" + id + "'";
		PreparedStatement prepareStatement = con.prepareStatement(delete);

		int executedelete = prepareStatement.executeUpdate();
		return executedelete;
	}

	@Override
	public void findByStudentName(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,name,department,address from Student_table where name='" + name + "'";
		PreparedStatement prepareStatement = con.prepareStatement(find);

		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}
	}

	@Override
	public void findByStudentId(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id,name,department,address from Student_table where id='" + id + "'";
		PreparedStatement prepareStatement = con.prepareStatement(find);

		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getString(3) + "\s" + rs.getString(4));
		}

	}

}
