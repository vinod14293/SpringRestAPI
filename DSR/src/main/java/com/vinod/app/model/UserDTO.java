package com.vinod.app.model;

public class UserDTO {
	private String email;
	private String password;
	
	public UserDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", password=" + password + ", employeId=" + employeId + ", employeRole="
				+ employeRole + ", employeName=" + employeName + "]";
	}

	public UserDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public UserDTO(String email, String password, long employeId, String employeRole, String employeName) {
		super();
		this.email = email;
		this.password = password;
		this.employeId = employeId;
		this.employeRole = employeRole;
		this.employeName = employeName;
	}
	private long employeId;
	private String employeRole;
	private String employeName;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getEmployeId() {
		return employeId;
	}
	public void setEmployeId(long employeId) {
		this.employeId = employeId;
	}
	public String getEmployeRole() {
		return employeRole;
	}
	public void setEmployeRole(String employeRole) {
		this.employeRole = employeRole;
	}
	public String getEmployeName() {
		return employeName;
	}
	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}
	
	
	
	


}