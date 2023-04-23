package com.task.util;

import java.sql.SQLException;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		EmployeeImpl object = new EmployeeImpl();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert Employee details" + "\n 2.Udate Employee details"
					+ "\n 3.delete Employee details" + "\n 4.Find Employee details"+"\n 5.show Employee List"+"\n 6.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.println(object.saveEmployee() + " Inserted successfully");
				object.employeeList();
				System.out.println("\n");
			}
				break;
			case 2: {
				System.out.println("select the option" + "\n 1.To update Id" + "\n 2.To update name"
						+ "\n 3.To update department" + "\n 4.To update salary");
				int option1 = sc.nextInt();
				switch (option1) {
				case 1: {
					System.out.print("Enter Employee Id:");
					int id = sc.nextInt();
					System.out.print("Enter new Employee Id:");
					int newId = sc.nextInt();
					System.out.println(object.updateEmployeeId(id,newId) + " Updated successfully ");
					object.employeeList();
					System.out.println("\n");
				}
					break;
				case 2: {
					System.out.print("Enter Employee Id:");
					int id = sc.nextInt();
					System.out.print("Enter new name:");
					String name = sc.next();
					System.out.println(object.updateEmployeeName(id, name) + " Updated successfully ");
					object.employeeList();
					System.out.println("\n");
				}
					break;
				case 3: {
					System.out.print("Enter Employee Id:");
					int id = sc.nextInt();
					System.out.print("Enter new department:");
					String department = sc.next();
					System.out.println(object.updateEmployeeDepartment(id, department) + " Updated successfully ");
					object.employeeList();
					System.out.println("\n");
				}
					break;
				case 4: {
					System.out.print("Enter Employee Id :");
					int id = sc.nextInt();
					System.out.print("Enter new salary:");
					int salary = sc.nextInt();
					System.out.println(object.updateEmployeeSalary(id,salary) + " Updated successfully ");
					object.employeeList();
					System.out.println("\n");
				}
					break;
				}
			}
				break;
			case 3: {
				object.employeeList();
				System.out.println(object.deleteEmployee() + " Deleted successfully");
			}
				break;
			case 4: {
				System.out.println("select the option" + "\n 1.Find by Id" + "\n 2.Find by name"
						+ "\n 3.Find by department " + "\n 4.Find by salary");
				int option2 = sc.nextInt();
				switch (option2) {
				case 1: {
					System.out.print("Enter Employee Id to find:");
					int id = sc.nextInt();
					object.findById(id);
					System.out.println("\n");
				}
					break;
				case 2: {
					System.out.print("Enter Employee name to find:");
					String name = sc.next();
					object.findByName(name);
					System.out.println("\n");
				}
					break;
				case 3: {
					System.out.print("Enter Employee department to find:");
					String department = sc.next();
					object.findByDepartment(department);
					System.out.println("\n");
				}
					break;
				case 4: {
					System.out.print("Enter Employee salary to find:");
					int salary = sc.nextInt();
					object.findBySalary(salary);
					System.out.println("\n");
				}
					break;
				}
			}break;
			case 5:{
				object.employeeList();
				System.out.println("\n");
			}break;
			case 6: {
				System.out.println("Thank You");
				loop = 0;
			}
				break;
			}
			
		} while (loop == 1);
	}
}
