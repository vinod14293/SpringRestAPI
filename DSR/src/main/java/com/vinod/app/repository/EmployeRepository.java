package com.vinod.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vinod.app.model.Employee;

@Repository
public interface EmployeRepository extends CrudRepository<Employee, Long>{

	public Employee findByEmployeeId(long employeeId);
	
	public Employee findByEmail(String email);
	
}
