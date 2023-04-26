package cys.training.test;

import java.sql.SQLException;
import java.util.Scanner;

import cys.training.dao.StudentImpl;
import cys.training.model.Student;

public class StudentTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		StudentImpl student = new StudentImpl();
		Student stu = new Student();
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert Student details" + "\n 2.Udate Student Address"
					+ "\n 3.delete Student details" + "\n 4.Find Student details" + "\n 5.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter Student Id: ");
				int id = sc.nextInt();
				if (id > 0) {
					stu.setId(id);
					System.out.print("Enter Student name: ");
					String name = sc.next();
					if (name != null) {
						stu.setName(name);
						System.out.print("Enter Department: ");
						String department = sc.next();
						if (department != null) {
							stu.setDepartment(department);
							System.out.print("Enter Address: ");
							String address = sc.next();
							if (address != null) {
								stu.setAddress(address);
								System.out.println(student.insertStudentDetails(stu) + " Inserted successfully");
								System.out.println("\n");
							} else
								System.out.println("Invalid input");
						} else
							System.out.println("Invalid input");
					} else
						System.out.println("Invalid input");
				} else
					System.out.println("Invalid input");
			}
				break;
			case 2: {

				System.out.print("Enter Student Id:");
				int id = sc.nextInt();
				if (id > 0) {
					System.out.print("Enter New Address:");
					String address = sc.next();
					if (address != null) {
						System.out.println(student.updateStudentAddress(id, address) + " Updated successfully ");
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				} else
					System.out.println("Invalid input");
			}
				break;

			case 3: {
				System.out.print("Enter Student Id:");
				int id = sc.nextInt();
				if (id > 0) {
					System.out.println(student.deleteStudentDetails(id) + " Deleted successfully");
					System.out.println("\n");
				} else
					System.out.println("Invalid input");
			}
				break;
			case 4: {
				System.out.println("select the option" + "\n 1.Find by Id" + "\n 2.Find by name");
				int option1 = sc.nextInt();
				switch (option1) {
				case 1: {
					System.out.print("Enter Student Id to find:");
					int id = sc.nextInt();
					if (id > 0) {
						student.findByStudentId(id);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				}
					break;
				case 2: {
					System.out.print("Enter Student name to find:");
					String name = sc.next();
					if (name != null) {
						student.findByStudentName(name);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				}
					break;
				}
				break;
			}
			case 5: {
				System.out.println("Thank You");
				loop = 0;
			}
				break;
			}

		} while (loop == 1);
	}
}
