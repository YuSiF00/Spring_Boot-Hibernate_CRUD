package com.luv2code.springboot.Spring_boot_CRUD_Hibernate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.Spring_boot_CRUD_Hibernate.entity.Employee;
import com.luv2code.springboot.Spring_boot_CRUD_Hibernate.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		List<Employee> employees = employeeService.findAll();
		
		return employees;
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getAllEmployee(@PathVariable int employeeId){
		Employee employee = employeeService.getEmployee(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Id not found..");
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.getEmployee(employeeId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.delete(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
	
}
