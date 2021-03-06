package com.vinod.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinod.app.model.Employee;
import com.vinod.app.repository.EmployeRepository;

@Service
public class EmployeeServiceImpl implements EmployeService{

	@Autowired
	private EmployeRepository employeRepo;
	
	@Override
	public List<Employee> getAllEmployes() {
		
		List<Employee> employes = (List<Employee>) employeRepo.findAll();
		
		return employes;
	}

	@Override
	public Employee saveEmployee(Employee empl) {
		employeRepo.save(empl);
		return empl;
	}

	@Override
	public void deleteEmployee(long id) {
		employeRepo.deleteById(id);
		
	}


	@Override
	public Employee getAllEmployeById(long id) {
		Optional<Employee> e= employeRepo.findById(id);
		Employee ea = null;
		if(e.isPresent()) {
			ea=e.get();
		}
		return ea;
	}

	@Override
	public Optional<Employee> getEmployById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public Employee updateEMployee(Employee empl) {
	 * employeRepo.save(empl); return empl; }
	 */
}
