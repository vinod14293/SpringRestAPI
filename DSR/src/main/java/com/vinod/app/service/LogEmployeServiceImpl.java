package com.vinod.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vinod.app.model.EmployeActivity;
import com.vinod.app.model.Employee;
import com.vinod.app.repository.EmployeRepository;
import com.vinod.app.repository.LogActivityRepository;

@Service
public class LogEmployeServiceImpl implements LogEmployeService {

	@Autowired
	private LogActivityRepository logActRepo;
	
	@Autowired
	private EmployeRepository empRepo;
	
	@Override
	public void logActivity(EmployeActivity emplAct,String userName) {
		Employee e = (Employee) empRepo.findByEmail(userName);
		emplAct.setEmploye(e);
		logActRepo.save(emplAct);
	}

	@Override
	public Page<EmployeActivity> getActivityById(String emial, int PageNumber, int PageSize) {
		Employee e = (Employee) empRepo.findByEmail(emial);
		System.out.println("page number recieved in service  "+PageNumber+"  and page size"+PageSize);
		Pageable pageable = PageRequest.of(PageNumber, PageSize, Sort.by("duration"));
		return logActRepo.getActivityById(e.getEmployeeId(), pageable);
	}
	
	@Override
	public Page<EmployeActivity> getActivityById2(long employeID, int PageNumber, int PageSize) {
		Pageable pageable = PageRequest.of(PageNumber, PageSize, Sort.by("duration"));
		return logActRepo.getActivityById(employeID, pageable);
	}

	@Override
	public Page<EmployeActivity> getActivityAll(int PageNumber, int PageSize) {
		Pageable pageable = PageRequest.of(PageNumber, PageSize, Sort.by("duration"));
		return logActRepo.findAll(pageable);
	}

}
