package cys.training.test;

import java.sql.SQLException;
import java.util.Scanner;

import cys.training.dao.BookStatusImpl;
import cys.training.model.BookStatus;

public class BookStatusTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		BookStatusImpl object = new BookStatusImpl();
		BookStatus book = new BookStatus();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert Book status" + "\n 2.Udate Date"
					+ "\n 3.delete Book Status" + "\n 4.Find Status" + "\n 5.show status List" + "\n 6.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter Book Issue ID: ");
				int id = sc.nextInt();
				if (id > 0) {
					book.setIssueId(id);
					System.out.print("Enter date: ");
					String date = sc.next();
					if (date != null) {
						book.setDate(date);
						System.out.print("Enter student id : ");
						int student_id = sc.nextInt();
						if (student_id > 0) {
							book.setStudentId(student_id);
							System.out.print("Enter book id: ");
							int book_id = sc.nextInt();
							if (book_id > 0) {
								book.setBookId(book_id);
								System.out.println(object.insertBookStatus(book) + " Inserted successfully");
								System.out.println("\n");
							} else
								System.out.println("Invalid Book Id");
						} else
							System.out.println("Invalid student id");
					} else
						System.out.println("Invalid Date");
				} else
					System.out.println("Invalid Book Issue ID ");
			}
				break;
			case 2: {
				System.out.print("Enter Book Issue ID:");
				int issue_id = sc.nextInt();
				if (issue_id > 0) {
					System.out.print("Enter date:");
					String date = sc.next();
					if (date != null) {
						System.out.println(object.updateDate(issue_id, date) + " Updated successfully ");
						System.out.println("\n");
					} else
						System.out.println("Invalid date");
				} else
					System.out.println("Invalid Book Issue ID");
			}
				break;

			case 3: {
				System.out.print("Enter Book Issue ID: ");
				int id = sc.nextInt();
				if (id > 0) {
					System.out.println(object.deleteBookStatus(id) + " Deleted successfully");
					System.out.println("\n");
				} else
					System.out.println("Invalid input");
			}
				break;
			case 4: {
				System.out.println("select the option" + "\n 1.Find by Book Issue ID" + "\n 2.Find by Student Id");
				int option2 = sc.nextInt();
				switch (option2) {
				case 1: {
					System.out.print("Enter Book Issue ID:");
					int id = sc.nextInt();
					if (id> 0) {
						object.findByIssueId(id);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				}
					break;
				case 2: {
					System.out.print("Enter Student Id to find:");
					int std_id = sc.nextInt();
					
					if (std_id>0) {
						object.findByStudentId(std_id);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				}
					break;
				}
			}
				break;
			case 5: {
				object.statusList();
			}
				break;
			case 6: {
				System.out.println("Thank You");
				loop = 0;
			}
				break;
			}

		} while (loop == 1);
	}
}
