package com.vinod.app.service;

import java.util.List;
import java.util.Optional;

import com.vinod.app.model.Employee;

public interface EmployeService {

	List<Employee> getAllEmployes();

	Employee saveEmployee(Employee empl);

	void deleteEmployee(long id);
	
	Optional<Employee> getEmployById(long id);

	Employee getAllEmployeById(long id);
	
	List<Employee> findByCriteria(String email);
	
	List<Long> findDistinctEmployeeId();

	//Employee updateEMployee(Employee empl);
	
}
