package cys.training.model;

public class BookStatus {
	private Integer issue_id;
	private String date;
	private Integer student_id;
	private Integer book_id;

	public BookStatus() { }
	public BookStatus(Integer issue_id, String date, Integer student_id, Integer book_id) {
		this.issue_id = issue_id;
		this.date = date;
		this.student_id = student_id;
		this.book_id = book_id;
	}

	public int getIssueId() {
		return issue_id;
	}

	public void setIssueId(int issue_id) {
		this.issue_id = issue_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public int getStudentId() {
		return student_id;
	}

	public void setStudentId(int student_id) {
		this.student_id = student_id;
	}
	public int getBookId() {
		return book_id;
	}

	public void setBookId(int book_id) {
		this.book_id = book_id;
	}

	@Override
	public String toString() {
		return "Books [issue_id=" + issue_id + ", Date=" + date + ", Student_Id=" + student_id + ", Book_Id=" + book_id+"]";
	}
}
