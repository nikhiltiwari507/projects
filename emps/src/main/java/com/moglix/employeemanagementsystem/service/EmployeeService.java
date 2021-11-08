package com.moglix.employeemanagementsystem.service;

import java.util.List;

import com.moglix.employeemanagementsystem.dto.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee); 
//	public String addEmployee(Employee employee); 
	public Employee updateEmployee(String id ,Employee employee);
	public Employee getEmployeeById(String id);
	public String deleteEmployeeById(String id);
	public String deleteAllEmployees();
	public List<Employee> getEmployees();
	
	

}
