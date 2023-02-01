package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
 public class EmployeeController {
    
	
	private EmployeeService employeeservice;
     

	public EmployeeController(EmployeeService employeeservice) { 
		super();
		this.employeeservice = employeeservice;
	}
	@PostMapping()
	public ResponseEntity<Employee>saveEmployee(@RequestBody Employee  employee){
	return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee),HttpStatus.CREATED);	
	}
	@GetMapping
	public List<Employee>getEmployee()
  {
	return employeeservice.getAllEmployees();
			}
	@GetMapping("{id}")
	public ResponseEntity<Employee>getEmpById(@PathVariable Long id){
		return new ResponseEntity<Employee>(employeeservice.getById(id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity <String> deleteEmployee(@PathVariable Long id) {
		employeeservice.deleteEmployee(id);
		return new ResponseEntity <String>("Delete Employee Succesfully",HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeservice.updateEmployee(employee, id),HttpStatus.OK);
	}
	}
