package cys.training.model;

public class Student {
	private Integer id;
	private String name;
	private String department;
	private String address;
	
	public Student() {}
	
	public Student(Integer id, String name, String department,String address) {
		this.id=id;
		this.name=name;
		this.department=department;
		this.address=address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department=department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String toString() {
		return "Employee[id= "+id+", name= "+name+", department= "+department+", address= "+address+"]";
	}

}
