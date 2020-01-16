package com.vinod.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMPLOYEE_ID")
	private long employeeId;
	
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="EMPLOYEE_ROLE")
	private String employeeRole;
	
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", employeeRole=" + employeeRole + ", password=" + password + ", empActivity=" + "]";
	}

	
	public Employee() {
		super();
	}
	
	public Employee(long employeeId, String employeeName, String email, String employeeRole, String password,
			List<EmployeActivity> empActivity) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.employeeRole = employeeRole;
		this.password = password;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name = "PASSWORD")
	private String password;
	

	
}
