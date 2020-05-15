package com.vinod.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vinod.app.exception.EmployeeNotFoundException;
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
	
	
	@Override
	public List<Employee> findByCriteria(String email){
		
		return employeRepo.findAll(new Specification<Employee>() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 8115620406014252277L;

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				
				List<Predicate> predicates = new ArrayList<>();
                if(email!=null && !(email.equals("null"))) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("email.getEmail()"), email)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
				
	}

	@Override
	public List<Long> findDistinctEmployeeId() {
		// TODO Auto-generated method stub
		return employeRepo.findDistinctEmployeeId();
	}
	

	/*
	 * @Override public Employee updateEMployee(Employee empl) {
	 * employeRepo.save(empl); return empl; }
	 */
}
