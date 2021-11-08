package com.moglix.employeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.service.EmployeeService;

@SpringBootApplication  // config + component scan reading prop file
public class EmpsApplication {

	public static void main(String[] args) {
		//ApplicationContext applicationContext= SpringApplication.run(EmpsApplication.class, args);

		
				SpringApplication.run(EmpsApplication.class, args);
//		
//		EmployeeService employeeService=applicationContext.getBean(EmployeeService.class);
//		
//		String result =employeeService.addEmployee(new Employee("12333775","abc","bbb",100.0f,"gg","jj","jj"));
//		System.out.println(result);
//		
//		String result1=	employeeService.updateEmployee("1233355",new Employee("1233355","nikhil","tiri",1200.0f,"abc","abc","abc"));	
//		 System.out.println(result1);
//		 
//		Employee result2=employeeService.getEmployeeById("1233355");	
//		System.out.println(result2);
//		
//		 
//		String result3=	employeeService.deleteEmployeeById("1233355");
//		System.out.println(result3);
//		
//		
//		String result4=	employeeService.deleteAllEmployees();
//		System.out.println(result4);
		
		
	}

}
