package cys.training.dao;

import java.sql.SQLException;

import cys.training.model.Book;

public interface BookDAO {
	public int insertBookDetails(Book book)throws ClassNotFoundException, SQLException;
	public int updateBookRack(int ISBN,int rack)throws ClassNotFoundException, SQLException;
	public int deleteBookDetails(int ISBN)throws ClassNotFoundException, SQLException;
	public void findByBookName(String name)throws ClassNotFoundException, SQLException;
	public void findByBookISBN(int ISBN)throws ClassNotFoundException, SQLException;
	public void bookList()throws ClassNotFoundException, SQLException;
}
