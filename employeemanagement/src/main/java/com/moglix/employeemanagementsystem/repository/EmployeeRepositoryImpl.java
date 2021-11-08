package com.moglix.employeemanagementsystem.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.utils.DBUtils;
import com.mysql.cj.protocol.Resultset;

@Repository  //repository impl k liye specific use krte h
//@Component  //ye bhi krskte h lekin repository lgaynge
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	private static final String employee= null;
	@Autowired
	DBUtils dbUtils;

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		String insertStatement = "INSERT INTO Employee (empID, empFirstName, empLastName, empSalary, address, aadhar,panCard)" 
				+ "VALUES (?,?,?,?,?,?,?)"; 
		
		PreparedStatement preparedStatement =null; 
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getEmpID());
			preparedStatement.setString(2, employee.getEmpFirstName());
			preparedStatement.setString(3, employee.getEmpLastName());
			preparedStatement.setFloat(4, employee.getEmpSalary());
			preparedStatement.setString(6, employee.getAadhar());
			preparedStatement.setString(7, employee.getPanCard());
			preparedStatement.setString(5, employee.getAddress());
			
			int res =preparedStatement.executeUpdate();
			
			if(res>0) {
				return "success";
				
			}else {
				return "fail";
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		String updateStatement="update Employee set EmpFirstName = ? ,EmpLastName = ? ,EmpSalary = ? ,Address = ?,Aadhar=?, PanCard =? where empID =?"; 
		
		PreparedStatement preparedStatement =null; 
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(7, employee.getEmpID());
			preparedStatement.setString(1, employee.getEmpFirstName());
			preparedStatement.setString(2, employee.getEmpLastName());
			preparedStatement.setString(4, employee.getAddress());
			preparedStatement.setString(5, employee.getAadhar());
			preparedStatement.setString(6, employee.getPanCard());
			preparedStatement.setFloat(3, employee.getEmpSalary());
			
			int res =preparedStatement.executeUpdate();
			
			if(res>0) {
				return "update success";
				
			}else {
				return "update failed";
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	

	@Override
	public  Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		Connection connection =dbUtils.getConnection();
		String getEmployeeByIdStatement="select * from  Employee where empID =?"; 
		
		PreparedStatement preparedStatement =null; 
		try {
			preparedStatement = connection.prepareStatement(getEmployeeByIdStatement);
			preparedStatement.setString(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			String empID = resultSet.getString("empID");
			String empFirstName = resultSet.getString("empFirstName");
			String empLastName = resultSet.getString("empLastName");
			float empSalary = resultSet.getFloat("empSalary");
			String Address = resultSet.getString("empaddress");
			String Adadhar = resultSet.getString("empaahar");
			String PanCard = resultSet.getString("empPanCard");
			Employee employee = new Employee(empID, empFirstName, empLastName,empSalary, Adadhar , Address,PanCard);
			return employee;
			}
			} catch (SQLException e) {
			e.printStackTrace();
			} finally {
			this.dbUtils.closeConnection(connection);
			}
			return null; 

	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement =null; 
		ResultSet resultset=null;
		String query ="select * from Employee";
		List<Employee> employees=new ArrayList<Employee>();
		
		try {
			
			preparedStatement = connection.prepareStatement(query);
			
			resultset= preparedStatement.executeQuery();
			while (resultset.next()) {
				//cursor
				Employee employee = new Employee(resultset.getString("empID"),resultset.getString("empFirstName"),resultset.getString("empLastName"),
													resultset.getFloat("empSalary"),resultset.getString("address"),resultset.getString("aadhar"),resultset.getString("panCard"));
				
				
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		
		
		
		return employees;
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		
		Connection connection=this.dbUtils.getConnection();
		String deleteStatement= "Delete from Employee where empID =?";
		try {
		PreparedStatement preparedStatement=connection.prepareStatement(deleteStatement);
		preparedStatement.setString(1, id);
		
		int res = preparedStatement.executeUpdate();
		
		if(res!=0)
			
		return "Entity Deleted successfully ";
		} 
		catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			
		this.dbUtils.closeConnection(connection);
		
		}

		return "Problem Occured while Deleting the entity"; 

	
}

	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub
		
		Connection connection=this.dbUtils.getConnection();
		String deleteStatement= "Delete from Employee";
		try {
		PreparedStatement preparedStatement=connection.prepareStatement(deleteStatement);
		
		
		int res = preparedStatement.executeUpdate();
		
		if(res!=0) {
			System.out.println("table deleted");
			
		} 
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			
		this.dbUtils.closeConnection(connection);
		
		}	
		
	}	
	
}


// YE SARA COMMENT KRDO KYUKI AUOWRIRED DBUTILS LGANE K BAAD UNIMPLIMENTED METHOD LGA DO

//	private static int counter = 0;
//	
////	private static EmployeeRepository employeeRepository;  //ye sab hamne @component use kiya to hataya kyuki spring b. khud krega
////	private EmployeeRepositoryImpl() {
////		
////		
////	}
////	
////	public static EmployeeRepository getInstance() {
////		if(employeeRepository==null) {
////			
////			employeeRepository= new EmployeeRepositoryImpl();
////			return employeeRepository;
////		}
////		return employeeRepository;
////		
////		
////		
////	}
//	
//	
////	Employee  employees[]= new Employee[10];
////	private List<Employee> employees =new ArrayList<Employee>();
//	private List<Employee> employees =new LinkedList<Employee>(); // linked list aur array list krne se same hoga;
//	
//	
//	@Override
//	public String addEmployee(Employee employee) {
////if(counter<employees.length) {          //its connected to line 32
////			
////			employees[counter++]=employee;
////			return "success";
////		}
////			
////	
////	else {
////		return "array is full";
////		
////	}
//		
//	//ab ham array list se krre hai
//		
//		boolean result = employees.add(employee);
//		
//		if(result) {
//			return "success....";
//		}
//		else {
//			return "fail";
//		}
//		
//	}
//	
//	
//
//	@Override
//	public List<Employee> getEmployee() {
//		// TODO Auto-generated method stub
//		return employees;
//	}
//
//	@Override
//	public String updateEmployee(String id, Employee employee) {
//		if (this.getEmployeeById(employee.getEmpID()) != null) {
//			int index = this.employees.indexOf(this.getEmployeeById(employee.getEmpID()));
//			this.employees.set(index, employee);
//			
//			return "Updated SuccessFully";
//			}
//		return "not updated "; 
//	}
//
//	@Override
//	public Employee getEmployeeById(String id) {
//		for(Employee employee : employees) {
//			if(id.equals(employee.getEmpID())) {
//				return employee;
//		}
//		
//		}
//		
//		return null;
//		
//	}
//
//	@Override
//	public String deleteEmployeeById(String id) {
//		// TODO Auto-generated method stub
////		return null;
//		
//		Employee employee = this.getEmployeeById(id);
//		if(employee!=null){
//			if (employees.remove(employee))
//	        return "success";
//			else 
//				return "Fail";
//		}
//		else {
//			return "not found...";
//		}
//		}
//			
//
//	@Override
//	public void deleteAllEmployees() {
//		// TODO Auto-generated method stub
//		
//		employees.clear();  //array wale k liye
//		
//	}
//	
//	
//
////	@Override
////	public String updateEmployee(String id, Employee employee) {
////		int index= this.getIndex(id);
////		
////		if(index!=-1) {
////			employees[index]=employee;
////			return "success";
////		}
////		else {
////			return"not found";
////		}
////	}
////		
////	
////	
////
////
////	@Override
////	public Employee getEmployeeById(String id) {
////		for (Employee employee : employees) {
////			if(employee!=null && id.equals(employee.getEmpID())) {
////				return employee;
////			}
////			
////		}
////		return null;
////		
////	}
////	private int getIndex(String id) {
////		for(int i=0; i< employees.length;i++) {
////			if(employees[i]!=null && employees[i].getEmpID().equals(id)) {
////				return i;
////			}
////		}
////		return -1;
////	}
////
////	@Override
////	public String deleteEmployeeById(String id) {
////		Employee employee = this.getEmployeeById(id);
////		
////		int index = this.getIndex(id);
////		
////		if(index!=-1) {
////			employees[index]=null;
////			return "success";
////		}
////		else
////		
////		return "not found";
////	}
////		
////
////	@Override
////	public void deleteAllEmployees() {
////		employees=null;
////
////	}
////
////}
//}
