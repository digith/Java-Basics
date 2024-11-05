package com.digithkv.java.basics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableComparator {
	public static void main(String[] args) {
		List<Employee> employees
			= Arrays.asList(
					new Employee(23,12321,"Digith K V","FFS",LocalDate.of(2024, 10, 07)),
					new Employee(25,12312,"Samuel John","Insurance",LocalDate.of(2022, 10, 11)),
					new Employee(23,12231,"Ravi Shastri","AI",LocalDate.of(2012, 10, 07))
					);
		System.out.println("Without Sorting");
		employees.forEach(System.out::println);
		Collections.sort(employees);
		System.out.println("After sorting with Comparable");
		employees.forEach(System.out::println);
		System.out.println("After sorting with NameComparator");
		Collections.sort(employees,new NameComparator());
		employees.forEach(System.out::println);
		System.out.println("After sorting with JoinigDateComparator");

	}
}

class Employee implements Comparable<Employee> {
	private int age,id;
	private String name, department;
	private LocalDate joiningDate;
	
	public Employee(int age, int id, String name, String department, LocalDate joiningDate) {
		super();
		this.age = age;
		this.id = id;
		this.name = name;
		this.department = department;
		this.joiningDate = joiningDate;
	}

	@Override
	public int compareTo(Employee o) {
		return this.getId() - o.getId();
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", id=" + id + ", name=" + name + ", department=" + department
				+ ", joiningDate=" + joiningDate + "]";
	}
}

class NameComparator implements Comparator<Employee>{
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

class JoinigDateComparator implements Comparator<Employee>{
	public int compare(Employee o1, Employee o2) {
		return o1.getJoiningDate().compareTo(o1.getJoiningDate());
	}
}

