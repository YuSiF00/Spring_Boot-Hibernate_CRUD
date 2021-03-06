package com.luv2code.springboot.Spring_boot_CRUD_Hibernate.dao;

import java.util.List;

import com.luv2code.springboot.Spring_boot_CRUD_Hibernate.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee getEmployee(int employeeId);
	
	public void save(Employee employee);
	
	public void delete(int employeeId);
}
