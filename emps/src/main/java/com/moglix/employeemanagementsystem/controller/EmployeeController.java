package com.moglix.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@GetMapping(value="/hello")   //this mapping will work for get method
	
	public String sayHello() {
		return "hello from nikhil";
	}
	

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
		//return employee;
		
		
//		@PostMapping("/add")
//		public Employee addEmployee(@RequestBody Employee employee) {
//			 employeeService.addEmployee(employee);
//			//return employee;
//		
	}
	
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id")String id) {
    	return this.employeeService.getEmployeeById(id);
    	
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id")String id) {
    	return this.employeeService.deleteEmployeeById(id);
    	
}
    
    @DeleteMapping("/employee/deleteAll")
    public String deleteAll() {
    	return this.employeeService.deleteAllEmployees();
    }
}
