package com.vinod.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vinod.app.model.EmployeActivity;

public interface LogEmployeService {

	void logActivity(EmployeActivity emplAct, String userName);

	
	Page<EmployeActivity> getActivityById(String employId, int PageNumber, int PageSize);
	
	Page<EmployeActivity> getActivityAll(int PageNumber, int PageSize);

	Page<EmployeActivity> getActivityById2(long employeID, int PageNumber, int PageSize);
}
