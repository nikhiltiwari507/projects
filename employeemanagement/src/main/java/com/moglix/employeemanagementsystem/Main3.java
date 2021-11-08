package com.moglix.employeemanagementsystem;

import java.util.HashSet;
import java.util.TreeSet;

import com.moglix.employeemanagementsystem.dto.Employee;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		HashSet<Employee> employees= new HashSet<Employee>();
		TreeSet<Employee> employees= new TreeSet<Employee>();
		
		Employee employee   = new Employee("12166","Nikhil","Tiwari",25000.f,"","","");
		Employee  employee2 = new Employee("12167","price","Tiwari",25000.f,"","","");
		Employee employee3  = new Employee("12168","manoj","kumar",25000.f,"","","");
		Employee employee4  = new Employee("12168","","",00f,"","","");
		
		
		employees.add(employee);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.remove(employee4);
		 
//		HashSet<Employee> employees1  = (HashSet<Employee>) employees.clone();
//		System.out.println(employees1);
//		
//		
//		boolean result = employees.contains(employee2);
//		System.out.println(result);
//		
		System.out.println(employees);
//		System.out.println(employees.size());
		

	}

}
