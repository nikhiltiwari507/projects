package com.moglix.employeemanagementsystem.dto;

public class Manager extends Employee{
	
	private String projectName;
	private float projectAllowance;
	public String getProjectName() {
		return projectName;
	}
	
	
	
	
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public float getProjectAllowance() {
		return projectAllowance;
	}
	public void setProjectAllowance(float projectAllowance) {
		this.projectAllowance = projectAllowance;
	}
	
	public Manager(String empID, String empFirstName, String empLastName, float empSalary, String projectName ,float projectAllowance, String address, String aadhar, String panCard) {
		super(empID, empFirstName, empLastName, empSalary, aadhar, address, panCard);
		this.projectName= projectName;
		this.projectAllowance= projectAllowance;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return super.toString() + "Manager [projectName=" + projectName + ", projectAllowance=" + projectAllowance + "]";
	}
	public Manager() {
	// TODO Auto-generated constructor stub
		super("12111","manoj","kumar",25000.00f, "address", "aadhar", "panCard");
		
	 System.out.println("hello from manager constructor");

	}
	@Override
	public float calculateSalary() {
		// TODO Auto-generated method stub
		return super.calculateSalary() + this.projectAllowance;
	}
}
