package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.exceptionhandler.EmployeeCommonException;
import com.employee.model.EmployeeModel;
import com.employee.serviceimpl.EmployeeServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is a controller that contains employee related REST API methods to 
 * handle employee creation and employee reading operations
 * @author RASAGNA
 *
 */
@RestController
@Slf4j
public class EmployeeController {
	
	private final EmployeeServiceImpl employeeService;
	
	@Autowired
	public EmployeeController(EmployeeServiceImpl employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping(value = "/employee", produces = "application/json")
    public ResponseEntity<Employee> postEntity(@RequestBody @Valid EmployeeModel request)
			throws EmployeeCommonException {
		log.info("Post request: ", request.toString());
		return ResponseEntity.ok(employeeService.insertEmployeeRecord(request));
		
	}
	
	@GetMapping(value = "/employees", produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam String gender, @RequestParam("minage") int minAge, @RequestParam("maxage") int maxAge)
			throws EmployeeCommonException {
		log.info("Get request: ", gender, minAge, maxAge);
		return ResponseEntity.ok(employeeService.readEmployees(gender, minAge, maxAge));
		
	}

}	
