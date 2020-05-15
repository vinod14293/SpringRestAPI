package com.vinod.app.repository;


import javax.transaction.Transactional;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vinod.app.model.Employee;

@Repository
public interface UserRepository extends CrudRepository<Employee, String> {


	public Employee findByEmail(String email);
	
	/*
	 * @Transactional
	 * 
	 * @Query(
	 * value="select e from Employee e where e.email = : email or e. employeeId = :employeeId"
	 * ) public Employee findByEmailOrEmployeeId(@Param("email") String email,
	 * 
	 * @Param("employeeId") long employeeId);
	 */
	
	@Transactional
	@Query(value="INSERT INTO EMPLOYEE e (e.employeeId, e.employeeName, e.email, e.employeeRole, e.password) VALUES  (:employID, :employeName, :email, :employeeRole, :password)", nativeQuery = true)
	public void createUser(@Param("email") String email,@Param("password") String password,@Param("employeName") String employeeName,@Param("employID") long employeeId,
			@Param("employeeRole")String employeeRole);

	public Employee findByEmailOrEmployeeId(String email, long employeeId);


}
