package com.vinod.app.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {
private static final long serialVersionUID = 5926468583005150707L;
private String email;
private String password;
//need default constructor for JSON Parsing

public JwtRequest() {
	super();

}

public JwtRequest(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}
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



}
