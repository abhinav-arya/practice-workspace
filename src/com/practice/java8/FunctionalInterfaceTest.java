package com.practice.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Consumer;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("aaa", "id1", 95000));
		empList.add(new Employee("bbb", "id2", 85000));
		empList.add(new Employee("ccc", "id3", 185000));
		empList.add(new Employee("ddd", "id4", 245000));
		
		
		Predicate<Employee> salaryGreaterThan1L = emp -> emp.salary > 100000;
		Consumer<Employee> displayEmployee = emp -> System.out.println(emp.name + ", " + emp.id + ", INR " + emp.salary + "/-");
		
		List<Employee> resultList = empList.stream().filter(salaryGreaterThan1L).collect(Collectors.toList());
		resultList.stream().forEach(displayEmployee);
		
		Collections.sort(empList);
		System.out.println(empList);
	}
}

class Employee implements Comparable<Employee> {
	String name;
	String id;
	double salary;
	
	Employee(String name, String id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee employee) {
		return (employee.salary > this.salary ? -1 : (employee.salary < this.salary ? 1 : 0));
	}
	
	@Override
	public String toString() {
		return (this.id + ", " + this.name + ", " + this.salary + "\n");
	}
}
