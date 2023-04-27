package cys.training.test;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cys.training.dao.BookImpl;
import cys.training.model.Book;

public class BookTestClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		BookImpl object = new BookImpl();
		Book book = new Book();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert Book details" + "\n 2.Udate Book Rack"
					+ "\n 3.delete Book details" + "\n 4.Find Book details" +"\n 5.show Book List" +"\n 6.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter Book ISBN: ");
				int ISBN = sc.nextInt();
				if (ISBN > 0) {
					book.setISBN(ISBN);
					System.out.print("Enter Book name: ");
					String name = sc.next();
					Pattern p = Pattern.compile("[a-zA-Z]+");
					Matcher m = p.matcher(name);
					boolean b=m.matches();
					if (b && name != null) {
						book.setName(name);
						System.out.print("Enter Rack Number : ");
						int rack = sc.nextInt();
						if (rack > 0) {
							book.setRackNo(rack);
							System.out.print("Enter Author name: ");
							String author = sc.next();
							Pattern p1 = Pattern.compile("[a-zA-Z]+");
							Matcher m1 = p1.matcher(author);
							boolean b1=m1.matches();
							if (b1 && author != null) {
								book.setAuthor(author);
								System.out.print("Enter Book Edition: ");
								String edition = sc.next();
								if (edition != null) {
									book.setBookEdition(edition);
									System.out.println(object.insertBookDetails(book) + " Inserted successfully");
									System.out.println("\n");
								} else
									System.out.println("Invalid Book Edition");
							} else
								System.out.println("Invalid Author name");
						} else
							System.out.println("Invalid Rack Number");
					} else
						System.out.println("Invalid name");
				} else
					System.out.println("Invalid ISBN value");
			}
				break;
			case 2: {
				System.out.print("Enter Book ISBN:");
				int ISBN = sc.nextInt();
				if (ISBN > 0) {
					System.out.print("Enter new Rack Number:");
					int rack = sc.nextInt();
					if (rack > 0) {
						System.out.println(object.updateBookRack(ISBN, rack) + " Updated successfully ");
						System.out.println("\n");
					} else
						System.out.println("Invalid Rack Number");
				} else
					System.out.println("Invalid ISBN value");
			}
				break;

			case 3: {
				System.out.print("Enter ISBN to delete: ");
				int ISBN = sc.nextInt();
				if (ISBN > 0) {
					System.out.println(object.deleteBookDetails(ISBN) + " Deleted successfully");
					System.out.println("\n");
				} else
					System.out.println("Invalid input");
			}
				break;
			case 4: {
				System.out.println("select the option" + "\n 1.Find by ISBN" + "\n 2.Find by Book name");
				int option2 = sc.nextInt();
				switch (option2) {
				case 1: {
					System.out.print("Enter Book ISBN to find:");
					int ISBN = sc.nextInt();
					if (ISBN > 0) {
						object.findByBookISBN(ISBN);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				}
					break;
				case 2: {
					System.out.print("Enter Book name to find:");
					String name = sc.next();
					Pattern p = Pattern.compile("[a-zA-Z]+");
					Matcher m = p.matcher(name);
					boolean b=m.matches();
					if (b && name != null) {
						object.findByBookName(name);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				}
					break;
				}
			}
				break;
			case 5: {
				object.bookList();
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
