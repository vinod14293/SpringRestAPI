package com.vinod.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinod.app.exception.EmployeeNotFoundException;
import com.vinod.app.model.EmployeActivity;
import com.vinod.app.model.Employee;
import com.vinod.app.service.EmployeService;
import com.vinod.app.service.LogEmployeService;
import com.vinod.app.util.JwtRequestFilter;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeController {

	@Autowired
	private EmployeService employeService;
	
	@Autowired
	private LogEmployeService logEmpService;

	
	@GetMapping("/getEmployee")
	public ResponseEntity<List<Employee>> getEmployees(){
		//System.out.println();
		return ResponseEntity.ok(employeService.getAllEmployes());  
	}
	
	@GetMapping("/getEmployee/{Id}")
	public ResponseEntity<Employee> getEmployeById(@PathVariable("Id") long Id) throws EmployeeNotFoundException, Exception{
		try {
			Employee ea = new Employee();
			ea = employeService.getAllEmployeById(Id);
			if(Id == 1240762) {
				throw new Exception();
			}
			if(ea == null) {
				throw new EmployeeNotFoundException();
			}
			else {
				return ResponseEntity.ok(ea); 
			}
		}
		catch(EmployeeNotFoundException exception){
			throw new EmployeeNotFoundException("Employee Not Found");
		}
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee empl){
		System.out.println("Employee Object recieved from client "+empl.toString());
		return ResponseEntity.ok(employeService.saveEmployee(empl));
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<?> deleteEmploy(@PathVariable("id") long id){
		employeService.deleteEmployee(id);
		return ResponseEntity.ok("employee Deleted");
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<?> updateEmployeeRole(@PathVariable("id") String id, @RequestBody Employee empl, @RequestHeader("user") String user){
		employeService.saveEmployee(empl);
		return ResponseEntity.ok(empl);
	
	}
	
	@PostMapping("/logActivity/{employId}")
	public ResponseEntity<String> logActivity(@RequestBody EmployeActivity employeActivity, @PathVariable("employId") long employId){
		String userName = JwtRequestFilter.usernameExt;
		logEmpService.logActivity(employeActivity,userName);
		return ResponseEntity.ok("Activity created successfully");
	}
	
	@GetMapping("/getLogActivity")
	public ResponseEntity<Page<EmployeActivity>> logActivity(@RequestParam(value="PageNumber", required=false) int PageNumber, 
			@RequestParam(value="PageSize", required=false) int PageSize, @RequestParam(value="role", required=false) String role, @RequestParam(value="EmployeId", required=false) String EmployeId, @RequestParam(value="From", required = false) Date from, @RequestParam(value = "to", required = false) Date to){
		String userName = JwtRequestFilter.usernameExt;
		System.out.println("Page Number --> "
		+PageNumber+
		"  and page size is "+PageSize 
		+"role is --> "+role
		+"Employee ID is --> "+EmployeId);
		
		System.out.println(" Employee id retrieved from Request Parameters before rtrieving manager Role --> "+EmployeId);
		
		if(role.equals("Manager")) {
			
			System.out.println(" EMployee id retrieved from Request Parameters --> "+EmployeId);
			if(EmployeId != null && !EmployeId.equals("")) {
			Page<EmployeActivity> data=logEmpService.getActivityById2(Integer.parseInt(EmployeId), PageNumber, PageSize);
			System.out.println("data retrieved from DB "+data.toString());
			return ResponseEntity.ok(data);
			}
			else {
			Page<EmployeActivity> data=logEmpService.getActivityAll(PageNumber, PageSize);
			System.out.println("data retrieved from DB "+data.toString());
			return ResponseEntity.ok(data);
			}
			
		}
		else {
		Page<EmployeActivity> data=logEmpService.getActivityById(userName,PageNumber, PageSize);
		System.out.println("data retrieved from DB "+data.toString());
		return ResponseEntity.ok(data);
		}
	}
	
	//For getting Employee Drop Down
	@GetMapping("/getEmployList")
	public ResponseEntity<List<Long>> getEmployeeList(){
		List<Long> employList = employeService.findDistinctEmployeeId();
		return ResponseEntity.ok(employList);
				
	}
	
	
	
	@GetMapping("/getLogActivity2")
	public ResponseEntity<List<EmployeActivity>> logActivity2(@RequestParam(value="employeID", required = false) String employeID 
			, @RequestParam(value="email", required = false) String email,
					@RequestParam(value="from", required = false) String from,
							@RequestParam(value="tp", required = false) String to){
		
		
		return ResponseEntity.ok(logEmpService.findByCriteria(employeID, email));
	}
	
	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable("email") String email){
		return ResponseEntity.ok(employeService.findByCriteria(email));
	}
	
	//for getting the records of all employees
	/*
	 * @GetMapping("/getLogActivity1") public ResponseEntity<Page<EmployeActivity>>
	 * logAllActivity(@RequestParam("PageNumber") int PageNumber,
	 * 
	 * @RequestParam("PageSize") int PageSize){ //String userName =
	 * JwtRequestFilter.usernameExt;
	 * //System.out.println("Page Number "+PageNumber+"  and page size is "+PageSize
	 * ); //PageNumber=0; //PageNumber=10; Page<EmployeActivity>
	 * data=logEmpService.getActivityAll(PageNumber, PageSize);
	 * System.out.println("data retrieved from DB "+data.toString()); return
	 * ResponseEntity.ok(data); }
	 */
	
	//optimize this extra method
	/*
	 * @GetMapping("/getLogActivity2") public ResponseEntity<Page<EmployeActivity>>
	 * logActivity(@RequestParam("PageNumber") int PageNumber,
	 * 
	 * @RequestParam("PageSize") int PageSize, @RequestParam("EmployeId") String
	 * EmployeId){ Page<EmployeActivity>
	 * data=logEmpService.getActivityById2(Integer.parseInt(EmployeId), PageNumber,
	 * PageSize); System.out.println("data retrieved from DB "+data.toString());
	 * return ResponseEntity.ok(data); }
	 */
	
		
}
