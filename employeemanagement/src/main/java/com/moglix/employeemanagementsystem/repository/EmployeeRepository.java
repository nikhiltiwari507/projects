package com.moglix.employeemanagementsystem.repository;

import java.util.List;

import com.moglix.employeemanagementsystem.dto.Employee;

public interface EmployeeRepository {
	
	public String addEmployee(Employee employee); 
	public String updateEmployee(String id ,Employee employee);
	public Employee getEmployeeById(String id); 
	public List<Employee> getEmployee();
	public String deleteEmployeeById(String id);
	public void deleteAllEmployees();
	
	
	
}

