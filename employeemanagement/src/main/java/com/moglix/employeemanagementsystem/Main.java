package com.moglix.employeemanagementsystem;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.repository.EmployeeDAO;
import com.moglix.employeemanagementsystem.service.EmployeeService;
import com.moglix.employeemanagementsystem.service.EmployeeServiceImpl;
import com.moglix.employeemanagementsystem.service.EmployeeServiceOld;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		EmployeeServiceOld employeeServiceOld= new EmployeeServiceOld();
	EmployeeService employeeService=  EmployeeServiceImpl.getInstance(); //for array list wala
		
		Employee employee = new Employee();
		
		employee.setEmpID("12166");
		employee.setEmpFirstName("Nikhil");
		employee.setEmpLastName("Tiwari");
		employee.setPanCard("BCLPT2124A");
		employee.setAadhar("123456789012");
		employee.setAddress("abc New Delhi ");
		employee.setEmpSalary(25000.00f);
		
		System.out.println(employee.getEmpFirstName());
		
		System.out.println(employee.getEmpID());
		System.out.println(employee.getEmpFirstName());
		System.out.println(employee.getEmpFirstName());
		System.out.println(employee.getEmpLastName());
		System.out.println(employee.getPanCard());
		System.out.println(employee.getAadhar());
		System.out.println(employee.getAddress());
		
		String result1 = employeeService.addEmployee(employee);
		System.out.println(result1);
		
		String result2 = employeeService.deleteEmployeeById("nikhil");
		System.out.println(result2);
         employee.setEmpID("EMP00000002");		
		String result3= employeeService.updateEmployee("12166",employee);
		System.out.println(result3);
		

//		
//		String result = employeeServiceOld.addEmployee(employee);
//		System.out.println(result);
//		if(result.equals("success")) {
//			System.out.println("employee added successfully");
//			
//		}
//		else {
//			System.out.println("employee added not successfully");
//		}
//		Employee employee2= employeeServiceOld.getEmployeeById("12166");
//		
//		if (employee2==null) {
//			System.out.println("employee id doesn't exist");
//			
//			
//		}
//		else {
//			System.out.println("employee exist");
//		}
//	
//		Employee employees[]=employeeServiceOld.getEmployees();
//		for(Employee employee3 : employees) {
//			if(employee3!=null) {
//				System.out.println(employee3);
//				System.out.println(employee3.toString());
//		}
//		 employeeServiceOld.deleteAllEmployees();
//
//}
////		employee.setEmpFirstName("manoj");
//		Employee employee4= new Employee();
//		employee4.setEmpFirstName("manoj");
//		employee4.setEmpID("12166");
//	     employeeServiceOld.updateEmployee("12166",employee4);
//		
//	     
//	     System.out.println(employeeServiceOld.getEmployeeById("12166"));
//		
//		
//}
//}
//
		
	}
	}