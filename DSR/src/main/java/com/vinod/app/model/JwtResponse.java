package com.vinod.app.model;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse implements Serializable {
private static final long serialVersionUID = -8091879091924046844L;
private final String jwttoken;
private final String userName;
private final Collection<? extends GrantedAuthority> roles;

public JwtResponse(String token, String userName2, Collection<? extends GrantedAuthority> authorities) {
	this.jwttoken = token;
	this.userName = userName2;
	this.roles=authorities;
}
public String getUserName() {
	return userName;
}
public String getToken() {
return this.jwttoken;
}
public Collection<? extends GrantedAuthority> getRoles() {
	return roles;
}
}
