package com.moglix.employeemanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


//public  class Employee{
public  class Employee implements Comparable<Employee> {
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aadhar == null) ? 0 : aadhar.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((empFirstName == null) ? 0 : empFirstName.hashCode());
		result = prime * result + ((empID == null) ? 0 : empID.hashCode());
		result = prime * result + ((empLastName == null) ? 0 : empLastName.hashCode());
		result = prime * result + Float.floatToIntBits(empSalary);
		result = prime * result + ((panCard == null) ? 0 : panCard.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (aadhar == null) {
			if (other.aadhar != null)
				return false;
		} else if (!aadhar.equals(other.aadhar))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (empFirstName == null) {
			if (other.empFirstName != null)
				return false;
		} else if (!empFirstName.equals(other.empFirstName))
			return false;
		if (empID == null) {
			if (other.empID != null)
				return false;
		} else if (!empID.equals(other.empID))
			return false;
		if (empLastName == null) {
			if (other.empLastName != null)
				return false;
		} else if (!empLastName.equals(other.empLastName))
			return false;
		if (Float.floatToIntBits(empSalary) != Float.floatToIntBits(other.empSalary))
			return false;
		if (panCard == null) {
			if (other.panCard != null)
				return false;
		} else if (!panCard.equals(other.panCard))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empSalary=" + empSalary + ", address=" + address + ", panCard=" + panCard + ", aadhar=" + aadhar
				+ "]";
	}
	
	public  float calculateSalary() {
		float salary=getEmpSalary();
		float hra= (float) (0.1*salary);
		float ta= (float) (0.1*salary);
		float da= (float) (0.1*salary);
		float totalSalary= hra+ ta + da + salary;
		return totalSalary;
		
	}
	
	
	private String empID;
		
	
	public Employee(String empID, String empFirstName, String empLastName, float empSalary, String address,
			String panCard, String aadhar) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empSalary = empSalary;
		this.address = address;
		this.panCard = panCard;
		this.aadhar = aadhar;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
		
		System.out.println("inside the employee constructor.");
	}
	private String empFirstName;
	private String empLastName;
	private float empSalary;
	private String address;
	private String panCard;
	private String aadhar;
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.empID.compareTo(o.empID);
	}
	
	
}