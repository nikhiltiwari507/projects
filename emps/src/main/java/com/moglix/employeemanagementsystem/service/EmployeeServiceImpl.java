package com.moglix.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

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
	public Employee addEmployee(Employee employee) {
		Employee employee2= employeeRepository.save(employee);
		
		if(employee2!=null) {
			return employee2;
		}
		else {
			return null;
		}
		
	}

	@Override
	public Employee updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		if(getEmployeeById(id)!=null)
		return addEmployee(employee); //save method yahi kaam krega
		else;
		return null;
	}

	@Override
	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional=  employeeRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		
		try {
			employeeRepository.deleteById(id);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String  deleteAllEmployees() {
		// TODO Auto-generated method stub
		employeeRepository.deleteAll();
		return "success";
		
		
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		return employeeRepository.findAll();
	}

	

	

}
