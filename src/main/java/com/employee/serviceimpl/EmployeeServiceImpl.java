package com.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exceptionhandler.EmployeeCommonException;
import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee insertEmployeeRecord(EmployeeModel employee) throws EmployeeCommonException {
		
		if(employeeRepository.findById(employee.getId()).isPresent())
			throw new EmployeeCommonException("Employee with Id already exists in Database, Please insert data with new ID");
		
		return employeeRepository.save(new Employee(employee.getId(), employee.getName(), employee.getAge(), employee.getGender()));
	}

	@Override
	public List<Employee> readEmployees(String gender, int minAge, int maxAge) throws EmployeeCommonException {
		
		if(employeeRepository.findByGenderEqualsAndAgeBetween(gender, minAge, maxAge).isEmpty())
			throw new EmployeeCommonException("No "+ gender + " Employees found with age between "+minAge+" and "+maxAge);
		
		
		return employeeRepository.findByGenderEqualsAndAgeBetween(gender, minAge, maxAge);
		
		
	}

	

}
