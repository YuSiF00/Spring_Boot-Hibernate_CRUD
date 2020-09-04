package com.luv2code.springboot.Spring_boot_CRUD_Hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.Spring_boot_CRUD_Hibernate.dao.EmployeeDao;
import com.luv2code.springboot.Spring_boot_CRUD_Hibernate.dao.EmployeeDaoHibernateImpl;
import com.luv2code.springboot.Spring_boot_CRUD_Hibernate.entity.Employee;

@Service
public class EmployeServiceHibernateImpl implements EmployeeService {
	
	private EmployeeDao employeeDAO;
	
	@Autowired
	public EmployeServiceHibernateImpl(EmployeeDao employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployee(int employeeId) {
		return employeeDAO.getEmployee(employeeId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void delete(int employeeId) {
		employeeDAO.delete(employeeId);
	}

}
