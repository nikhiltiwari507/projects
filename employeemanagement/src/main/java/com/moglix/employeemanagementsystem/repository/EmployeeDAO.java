package com.moglix.employeemanagementsystem.repository;

import com.moglix.employeemanagementsystem.dto.Employee;

public class EmployeeDAO {
	private static int counter = 0;
	
	Employee  employees[]= new Employee[10];
	public String addEmployee(Employee employee) {

		if(counter<employees.length) {
			
			employees[counter++]=employee;
			return "success";
		}
			
	
	else {
		return "array is full";
		
	}
		
	}
	public Employee getEmployeeById(String id) {
		
		for (Employee employee : employees) {
			if(employee!=null && id.equals(employee.getEmpID())) {
				return employee;
			}
			
		}
		return null;
		
	}
	public Employee[] getEmployees() {
		return employees;
	}
	private int getIndex(String id) {
		for(int i=0; i< employees.length;i++) {
			if(employees[i]!=null && employees[i].getEmpID().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
public String updateEmployees(String empId, Employee employee) {
	int index= this.getIndex(empId);
	
	if(index!=-1) {
		employees[index]=employee;
		return "success";
	}
	else {
		return"not found";
	}
	
}	

	
	public String deleteEmployeeById(String id) {
		
		Employee employee = this.getEmployeeById(id);
		
		int index = this.getIndex(id);
		
		if(index!=-1) {
			employees[index]=null;
			return "success";
		}
		else
		
		return "not found";
	}
		
	
	
	public void deleteAllEmployees() {
		employees=null;
		
	}
//	public String updateEmployee(String empID,Employee employee) {
//		for (Employee emp : employees) {
//			if (emp != null && emp.getEmpID().equalsIgnoreCase(empID)) {
//				emp.setEmpFirstName("manoj");
//		
//			}
//		}
//		System.out.println("update");
//			return "updated Successfully";
//			
//	}
//	
}



	
