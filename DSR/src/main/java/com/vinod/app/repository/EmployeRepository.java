package com.vinod.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vinod.app.model.Employee;

@Repository
public interface EmployeRepository extends CrudRepository<Employee, Long>{

	public List<Employee> findByEmployeeId(long employeeId);
	
}
