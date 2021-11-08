package com.moglix.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moglix.employeemanagementsystem.dto.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	

	
	
	
}

