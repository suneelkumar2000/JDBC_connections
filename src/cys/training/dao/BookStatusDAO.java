package cys.training.dao;

import java.sql.SQLException;

import cys.training.model.BookStatus;

public interface BookStatusDAO {
	public int insertBookStatus(BookStatus bookStatus)throws ClassNotFoundException, SQLException;
	public int updateDate(int issue_id,String date)throws ClassNotFoundException, SQLException;
	public int deleteBookStatus(int issue_id)throws ClassNotFoundException, SQLException;
	public void findByIssueId(int issue_id)throws ClassNotFoundException, SQLException;
	public void findByStudentId(int student_id)throws ClassNotFoundException, SQLException;
	public void statusList()throws ClassNotFoundException, SQLException;
}
