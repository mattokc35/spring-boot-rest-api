package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	// Add a new employee
	public Employee createEmployee(Employee emp) {
		return empRepository.save(emp);
	}

	// Get All Employees
	public List<Employee> getEmployees() {
		return empRepository.findAll();
	}

	// Find and return an employee by ID
	public Employee findEmployee(Long empId) {
		return empRepository.findById(empId).get();
	}

	// Update Employee Details
	public Employee updateEmployee(Long empId, Employee employeeDetails) {
		Employee emp = empRepository.findById(empId).get();
		emp.setFirstName(employeeDetails.getFirstName());
		emp.setLastName(employeeDetails.getLastName());
		emp.setRole(employeeDetails.getRole());
		emp.setSalary(employeeDetails.getSalary());

		return empRepository.save(emp);
	}

	// Delete an employee
	public void deleteEmployee(Long empId) {
		empRepository.deleteById(empId);
	}

}
