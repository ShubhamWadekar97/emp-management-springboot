package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repositary.EmployeeRepositary;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
     private EmployeeRepositary employeeRepositary;
     
     
	public EmployeeServiceImpl(EmployeeRepositary employeeRepositary) {
		super();
		this.employeeRepositary = employeeRepositary;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepositary.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepositary.findAll();
	}


	@Override
	
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee= employeeRepositary.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}else
			throw new ResourceNotFoundException("Employee", "id" ,id);
		
	}


	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepositary.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
		employeeRepositary.deleteById(id);
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		Employee exitingemployee=employeeRepositary.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
		exitingemployee.setName(employee.getName());
		exitingemployee.setAge(employee.getAge());
		exitingemployee.setDesignation(employee.getDesignation());
		exitingemployee.setSalary(employee.getSalary());
		employeeRepositary.save(exitingemployee);
		return exitingemployee;
	}



}
