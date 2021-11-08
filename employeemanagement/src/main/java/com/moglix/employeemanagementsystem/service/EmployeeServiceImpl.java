package com.moglix.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.repository.EmployeeRepository;
//@Component
@Service  //specific service k liye wrna component bhi use krkte h.
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
//	EmployeeDAO employeeDAO= new EmployeeDAO();

	
  //EmployeeRepository employeeRepository = EmployeeRepositoryImpl.getInstance();

//	private static EmployeeService employeeService;

//	public static EmployeeService getInstance() {
//
//		if (employeeService == null) {
//
//			employeeService = new EmployeeServiceImpl();
//			return employeeService;
//		} else {
//
//			return employeeService;
//
//		}
//
//	}
	
	
	

	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addEmployee(Employee employee) {
		return employeeRepository.addEmployee(employee);
	}

	@Override
	public String updateEmployee(String id, Employee employee) {
		return employeeRepository.updateEmployee(id, employee);
	}

	@Override
	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
	}

	@Override
	public String deleteEmployeeById(String id) {
		return employeeRepository.deleteEmployeeById(id);
	}

	@Override
	public void deleteAllEmployees() {
		this.employeeRepository.deleteAllEmployees();
	}
	
	@Override
	public List<Employee> getEmployees() {
		return this.employeeRepository.getEmployee();
	}
	

}
