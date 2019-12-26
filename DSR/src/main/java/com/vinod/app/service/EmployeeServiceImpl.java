package com.vinod.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinod.app.model.Employee;
import com.vinod.app.repository.EmployeRepository;

@Service
public class EmployeeServiceImpl implements EmployeService{

	@Autowired
	private EmployeRepository employeRepo;
	
	@Override
	public List<Employee> getAllEmployes(long employeeId) {
		
		List<Employee> employes = employeRepo.findByEmployeeId(employeeId);
		
		return employes;
	}

}
