package com.vinod.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="EMPLOYEE_ID")
	private long employeeId;
	
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="EMPLOYEE_ROLE")
	private String employeeRole;
	
	public Employee() {
	}
	
	public Employee(long enmployId, String employeeName, String email, String employeeRole) {
		super();
		this.employeeId = enmployId;
		this.employeeName = employeeName;
		this.email = email;
		this.employeeRole = employeeRole;
	}

	@Override
	public String toString() {
		return "Employee [enmployId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", employeeRole=" + employeeRole + "]";
	}

	public long getEnmployId() {
		return employeeId;
	}

	public void setEnmployId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	
	
	
}
