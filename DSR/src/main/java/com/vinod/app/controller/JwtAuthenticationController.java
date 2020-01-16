package com.vinod.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinod.app.model.JwtRequest;
import com.vinod.app.model.JwtResponse;
import com.vinod.app.model.User;
import com.vinod.app.model.UserDTO;
import com.vinod.app.service.UserService;
import com.vinod.app.service.UserServiceImpl;
import com.vinod.app.util.JWTUtil;


import org.springframework.security.core.userdetails.UserDetails;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
		final UserDetails userDetails = (UserDetails) userService
				.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtUtil.generateToken(userDetails);
		final String userName = userDetails.getUsername();
		
		System.out.println("User details extracted from spring security  -- "+userName+" and user Role --"+userDetails.getAuthorities());
		return ResponseEntity.ok(new JwtResponse(token, userName, userDetails.getAuthorities()));
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		System.out.println("user DTO recieved before transfering to data base"+user);
		return ResponseEntity.ok(userService.save(user));
	}



}

