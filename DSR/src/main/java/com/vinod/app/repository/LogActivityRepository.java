package com.vinod.app.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vinod.app.model.EmployeActivity;

@Repository
public interface LogActivityRepository extends JpaRepository<EmployeActivity, Long>{

	@Query("SELECT e from EmployeActivity e where e.employe.employeeId = ?1")
	Page<EmployeActivity> getActivityById(Long employId, Pageable pageable);
	
	@Query("SELECT e from EmployeActivity e where e.employe.email = ?1")
	Page<EmployeActivity> findByEmail(String email, Pageable pageable);

}
