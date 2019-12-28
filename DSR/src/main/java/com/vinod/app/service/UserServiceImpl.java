package com.vinod.app.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user =  userRepositoy.findByUserName(username);
		
		System.out.println("User Details Extracted from DB are  "+user.getUserName());

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(UserDTO user) {
		User user1 = new User();
		user1.setUserName(user.getUsername());
		user1.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepositoy.save(user1);
	}

}
