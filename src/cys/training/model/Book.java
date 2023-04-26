package cys.training.model;

public class Book {
	private Integer ISBN;
	private String name;
	private Integer rackNo;
	private String author;
	private String edition;

	public Book() {
	}

	public Book(Integer ISBN, String name, Integer rackNo, String author, String edition) {
		this.ISBN = ISBN;
		this.name = name;
		this.rackNo = rackNo;
		this.author = author;
		this.edition = edition;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRackNo() {
		return rackNo;
	}

	public void setRackNo(int rackNo) {
		this.rackNo = rackNo;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookEdition() {
		return edition;
	}

	public void setBookEdition(String edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Books [isbn=" + ISBN + ", bookName=" + name + ", rackNo=" + rackNo + ", author=" + author
				+ ", bookEdition=" + edition + "]";
	}
}