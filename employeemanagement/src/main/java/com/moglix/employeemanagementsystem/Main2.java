package com.moglix.employeemanagementsystem;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.dto.Manager;

public class Main2 {
	
	public  final int a ;
	public Main2() {
		// TODO Auto-generated constructor stub
		this.a=10;
	}
	
	public static void main(String[] args) {
//		Manager manager= new Manager();
		Employee manager= new Manager();
		
		Employee manager1= new Manager("12111","manoj","kumar",25000.00f,"employeemanagement",10000.00f,"","",""); 
		System.out.println(manager1);
		
		System.out.println(manager1.calculateSalary());
		
	}

}
