package com.vinod.app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vinod.app.model.Employee;

@Repository
public interface UserRepository extends CrudRepository<Employee, String> {

	public Employee findByEmail(String email);


}
