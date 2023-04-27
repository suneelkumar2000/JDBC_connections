package cys.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cys.training.model.BookStatus;
import cys.training.util.ConnectionUtil;

public class BookStatusImpl implements BookStatusDAO {
	public int insertBookStatus(BookStatus booksts) throws ClassNotFoundException, SQLException
	{
	// TODO Auto-generated method stub
	Connection con=ConnectionUtil.getConnection();
	String s="insert into book_status(issue_id,date,student_id,book_id)values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(s);
	ps.setInt(1,booksts.getIssueId());
	ps.setString(2, booksts.getDate());
	ps.setInt(3,booksts.getStudentId());
	ps.setInt(4,booksts.getBookId());
	int executeUpdate = ps.executeUpdate();
	return executeUpdate;
	}

	@Override
	public int updateDate(int issue_id,String date) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update book_status set date ='"+date+"' where issue_id='"+issue_id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(update);
		
		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
	}

	@Override
	public int deleteBookStatus(int issue_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from book_status where issue_id='"+issue_id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(delete);
		
		int executedelete = prepareStatement.executeUpdate();
		return executedelete;
	}

	@Override
	public void findByIssueId(int issue_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select issue_id,date,student_id,book_id from book_status where issue_id='"+issue_id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getInt(3) + "\s" + rs.getString(4));
		}
	}

	@Override
	public void findByStudentId(int student_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select issue_id,date,student_id,book_id from book_status where student_id='"+student_id+"'";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getInt(3) + "\s" + rs.getString(4));
		}
	}

	@Override
	public void statusList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select issue_id,date,student_id,book_id from book_status";
		PreparedStatement prepareStatement = con.prepareStatement(display);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
		}
	}
}
