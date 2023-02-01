package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee); 
     List<Employee>getAllEmployees();
     Employee getById(long id);
     void deleteEmployee(long id);
     Employee updateEmployee(Employee employee, long id);
}
