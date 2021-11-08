package com.moglix.employeemanagementsystem.service;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.repository.EmployeeDAO;

public class EmployeeServiceOld {
	
	EmployeeDAO employeeDAO= new EmployeeDAO();
	
	public String  addEmployee(Employee employee) {
		
		return employeeDAO.addEmployee(employee);
	}
	
	public Employee getEmployeeById (String EmpID) {
		return employeeDAO.getEmployeeById(EmpID);
		
		
	}
	
	public Employee[]  getEmployees() {
		return employeeDAO.getEmployees();
	}
	
	public void deleteAllEmployees() {
		 employeeDAO.deleteAllEmployees();
		
	}
	
	public void updateEmployee(String empID,Employee employee) {
		String update= employeeDAO.updateEmployees(empID, employee);
	System.out.println(update);
	}
//	public float calculateSalary(Employee employee) {
//		return employeeDAO.calculateSalary();
//	}
}
