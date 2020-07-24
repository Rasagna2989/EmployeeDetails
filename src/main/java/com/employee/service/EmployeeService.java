package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;
import com.employee.exceptionhandler.EmployeeCommonException;
import com.employee.model.EmployeeModel;


public interface EmployeeService {

	Employee insertEmployeeRecord(EmployeeModel employee) throws EmployeeCommonException;
	
	List<Employee> readEmployees(String gender, int minAge, int maxAge) throws EmployeeCommonException;

}
