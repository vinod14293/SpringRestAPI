package com.vinod.app.service;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.vinod.app.model.Employee;
import com.vinod.app.model.User;
import com.vinod.app.model.UserDTO;
import com.vinod.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService  {

	@Autowired
	private UserRepository userRepositoy;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	/*
	 * @Override public User findByUserName(String User) { User user =
	 * userRepositoy.findByUserName(User);
	 * 
	 * System.out.println("User Details Extracted from DB are  "+user.getUserName())
	 * ; return user; }
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		Employee user =  userRepositoy.findByEmail(email);
		
		System.out.println("User Details Extracted from DB are  "+user.getEmail());

		String userRoles[]= new String[1];
		userRoles[0] = user.getEmployeeRole();
		
		System.out.println("User Details Extracted for Role are  "+userRoles[0]);
		
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				authorities);
	}

	public Employee save(UserDTO user) {
		Employee user1 = new Employee();
		user1.setEmail(user.getEmail());
		user1.setPassword(bcryptEncoder.encode(user.getPassword()));
		user1.setEmployeeName(user.getEmployeName());
		user1.setEmployeeId(user.getEmployeId());
		user1.setEmployeeRole(user.getEmployeRole());
		
		System.out.println("user object created before logging");
		
		return userRepositoy.save(user1);
	}

}
