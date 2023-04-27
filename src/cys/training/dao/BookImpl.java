package cys.training.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cys.training.model.Book;
import cys.training.util.ConnectionUtil;

public class BookImpl implements BookDAO {

	@Override
	public int insertBookDetails(Book book) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();

		String insert = "insert into book(ISBN,name,rack_no,author,edition) values(?,?,?,?,?)";
		PreparedStatement prepareStatement = con.prepareStatement(insert);

		prepareStatement.setInt(1, book.getISBN());
		prepareStatement.setString(2, book.getName());
		prepareStatement.setInt(3, book.getRackNo());
		prepareStatement.setString(4, book.getAuthor());
		prepareStatement.setString(5, book.getBookEdition());

		int execute = prepareStatement.executeUpdate();
		return execute;
	}

	@Override
	public int updateBookRack(int ISBN,int rack) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String update = "update book set rack_no ='"+rack+"' where ISBN='"+ISBN+"'";
		PreparedStatement prepareStatement = con.prepareStatement(update);
		
		int executeUpdate = prepareStatement.executeUpdate();
		return executeUpdate;
		

	}

	@Override
	public int deleteBookDetails(int ISBN) throws ClassNotFoundException, SQLException {
		
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String delete = "delete from book where ISBN='"+ISBN+"'";
		PreparedStatement prepareStatement = con.prepareStatement(delete);
		
		int executedelete = prepareStatement.executeUpdate();
		return executedelete;

	}

	@Override
	public void findByBookName(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select ISBN,name,rack_no,author,edition from book where name='"+name+"'";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getInt(3) + "\s" + rs.getString(4)+ "\s" + rs.getString(5));
		}

	}

	@Override
	public void findByBookISBN(int ISBN) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select ISBN,name,rack_no,author,edition from book where isbn='"+ISBN+"'";
		PreparedStatement prepareStatement = con.prepareStatement(find);
		
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\s" + rs.getString(2) + "\s" + rs.getInt(3) + "\s" + rs.getString(4)+ "\s" + rs.getString(5));
		}

	}

	@Override
	public void bookList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String display = "select ISBN,name,rack_no,author,edition from book";
		PreparedStatement prepareStatement = con.prepareStatement(display);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4)+ "\t" + rs.getString(5));
		}
	}

}
