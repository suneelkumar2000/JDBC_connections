package com.task.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		EmployeeImpl object = new EmployeeImpl();
		EmployeePOJO emp= new EmployeePOJO();
		List<EmployeePOJO>employeeList=object.employeeList();
		Scanner sc = new Scanner(System.in);
		int loop = 1;
		do {
			System.out.println("select the option" + "\n 1.Insert Employee details" + "\n 2.Udate Employee details"
					+ "\n 3.delete Employee details" + "\n 4.Find Employee details"+"\n 5.show Employee List"+"\n 6.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter Employee Id: ");
				emp.setId(sc.nextInt());
				System.out.print("Enter Employee name: ");
				emp.setName(sc.next());
				System.out.print("Enter Department: ");
				emp.setDepartment(sc.next());
				System.out.print("Enter Employee salary: ");
				emp.setSalary(sc.nextInt());
				System.out.println(object.saveEmployee(emp) + " Inserted successfully");
				System.out.println("\n");
			}
				break;
			case 2: {
				System.out.println("select the option" + "\n 1.To update name"
						+ "\n 2.To update department" + "\n 3.To update salary");
				int option1 = sc.nextInt();
				switch (option1) {
				case 1: {
					System.out.print("Enter Employee Id:");
					emp.setId(sc.nextInt());
					System.out.print("Enter new name:");
					emp.setName(sc.next());
					System.out.println(object.updateEmployeeName(emp) + " Updated successfully ");
					System.out.println("\n");
				}
					break;
				case 2: {
					System.out.print("Enter Employee Id:");
					emp.setId(sc.nextInt());
					System.out.print("Enter new department:");
					emp.setDepartment(sc.next());
					System.out.println(object.updateEmployeeDepartment(emp) + " Updated successfully ");
					System.out.println("\n");
				}
					break;
				case 3: {
					System.out.print("Enter Employee Id :");
					emp.setId(sc.nextInt());
					System.out.print("Enter new salary:");
					emp.setSalary(sc.nextInt());
					System.out.println(object.updateEmployeeSalary(emp) + " Updated successfully ");
					System.out.println("\n");
				}
					break;
				}
			}
				break;
			case 3: {
				System.out.println(employeeList);
				System.out.println("\n");
				System.out.println(object.deleteEmployee(emp) + " Deleted successfully");
				System.out.println("\n");
			}
				break;
			case 4: {
				System.out.println("select the option" + "\n 1.Find by Id" + "\n 2.Find by name"
						+ "\n 3.Find by department " + "\n 4.Find by salary");
				int option2 = sc.nextInt();
				switch (option2) {
				case 1: {
					System.out.print("Enter Employee Id to find:");
					emp.setId(sc.nextInt());
					object.findById(emp);
					System.out.println("\n");
				}
					break;
				case 2: {
					System.out.print("Enter Employee name to find:");
					emp.setName(sc.next());
					object.findByName(emp);
					System.out.println("\n");
				}
					break;
				case 3: {
					System.out.print("Enter Employee department to find:");
					emp.setDepartment(sc.next());
					object.findByDepartment(emp);
					System.out.println("\n");
				}
					break;
				case 4: {
					System.out.print("Enter Employee salary to find:");
					emp.setSalary(sc.nextInt());
					object.findBySalary(emp);
					System.out.println("\n");
				}
					break;
				}
			}break;
			case 5:{
				System.out.println(employeeList);
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
