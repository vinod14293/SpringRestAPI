package com.vinod.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinod.app.model.Employee;
import com.vinod.app.service.EmployeService;

@RestController
public class EmployeController {

	@Autowired
	private EmployeService employeService;
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployees(){
	  return employeService.getAllEmployes(1240762);
	}
	
	
}
