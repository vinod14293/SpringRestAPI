package com.vinod.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinod.app.model.Employee;

@Repository
@Transactional
public interface EmployeRepository extends CrudRepository<Employee, Long>,JpaSpecificationExecutor<Employee>{

	Employee findByEmployeeId(long employeeId);
	
	Employee findByEmail(String email);
	
	@Query("select distinct employeeId from Employee")
	List<Long> findDistinctEmployeeId();
	
}
