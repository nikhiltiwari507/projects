package com.moglix.employeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.service.EmployeeService;

import sun.security.krb5.Config;


public class Main5 {
	
//	@Autowired
//	EmployeeService employeeService; 

	public static void main(String[] args) {
	AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(com.moglix.employeemanagementsystem.config.Config.class);
	
	DataSource dataSource =applicationContext.getBean("mysqlDataSource",DataSource.class);
	System.out.println(dataSource!=null);
	
	
//	//get bean
////    applicationContext.scan("com.moglix.employeemanagementsystem.repository");
////    applicationContext.scan("com.moglix.employeemanagementsystem.service");
////    applicationContext.refresh();
	EmployeeService employeeService= applicationContext.getBean(EmployeeService.class);
	
	String result=	employeeService.addEmployee(new Employee("15556hhh6646","nikhil","tiwari",1200.0f,"abc","abc","abc"));	
	 System.out.println(result);
	 
	String result1=	employeeService.updateEmployee("1244664446",new Employee("1244664446","nikhil","tiri",1200.0f,"abc","abc","abc"));	
	 System.out.println(result1);
	 
		String result3=	employeeService.deleteEmployeeById("126");
		System.out.println(result3);

	 List<Employee> employees= new ArrayList<Employee>();
	 employees=employeeService.getEmployees();
	 System.out.println(employees);
	 
	 EmployeeService employeeService2=applicationContext.getBean(EmployeeService.class);
	 System.out.println(employeeService==employeeService2);
	 System.out.println(employeeService.hashCode());
	 System.out.println(employeeService2.hashCode());
	 System.out.println(employeeService.equals(employeeService2));
	
	 
	}

}
