package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	
	//create employee (POST)
	@RequestMapping(value="/employees/post", method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) {
	    return empService.createEmployee(emp);
	}
	
	//get all employees (GET)
	@RequestMapping(value="/employees/getall", method=RequestMethod.GET)
	public List<Employee> readEmployees() {
	    return empService.getEmployees();
	}
	
	//find employee by id(GET)
	@RequestMapping(value="/employees/get/{empId}", method=RequestMethod.GET)
	public Employee findEmployee(@PathVariable(value = "empId") Long id) {
	    return empService.findEmployee(id);
	}
	
	//update employee details (PUT)
	@RequestMapping(value="/employees/put/{empId}", method=RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
	    return empService.updateEmployee(id, empDetails);
	}
	
	
	//delete employee by id (DEL)
	@RequestMapping(value="/employees/del/{empId}", method=RequestMethod.DELETE)
	public void deleteEmployees(@PathVariable(value = "empId") Long id) {
	    empService.deleteEmployee(id);
	}
}



