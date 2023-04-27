package cys.training.test;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
					+ "\n 3.delete Student details" + "\n 4.Find Student details" + "\n 5.show Student List"
					+ "\n 6.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter Student Id: ");
				int id = sc.nextInt();
				if (id > 0) {
					stu.setId(id);
					System.out.print("Enter Student name: ");
					String name = sc.next();
					Pattern p = Pattern.compile("[a-zA-Z]+");
					Matcher m = p.matcher(name);
					boolean b=m.matches();
					if (b && name != null) {
						stu.setName(name);
						System.out.print("Enter Department: ");
						String department = sc.next();
						Pattern p1 = Pattern.compile("[a-zA-Z]+");
						Matcher m1 = p1.matcher(department);
						boolean b1=m1.matches();
						if (b1 && department != null) {
							stu.setDepartment(department);
							System.out.print("Enter Address: ");
							String address = sc.next();
							if (address != null) {
								stu.setAddress(address);
								System.out.println(student.insertStudentDetails(stu) + " Inserted successfully");
								System.out.println("\n");
							} else
								System.out.println("Invalid Address");
						} else
							System.out.println("Invalid Department");
					} else
						System.out.println("Invalid name");
				} else
					System.out.println("Invalid Id");
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
						System.out.println("Invalid Address");
				} else
					System.out.println("Invalid Id");
			}
				break;

			case 3: {
				System.out.print("Enter Student Id:");
				int id = sc.nextInt();
				if (id > 0) {
					System.out.println(student.deleteStudentDetails(id) + " Deleted successfully");
					System.out.println("\n");
				} else
					System.out.println("Invalid Id");
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
					Pattern p = Pattern.compile("[a-zA-Z]+");
					Matcher m = p.matcher(name);
					boolean b=m.matches();
					if (b && name != null) {
						student.findByStudentName(name);
						System.out.println("\n");
					} else
						System.out.println("Invalid input");
				}
					break;
				}
			}
				break;
			case 5: {
				student.studentList();
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
