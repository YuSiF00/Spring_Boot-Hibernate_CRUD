package com.luv2code.springboot.Spring_boot_CRUD_Hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.Spring_boot_CRUD_Hibernate.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee getEmployee(int employeeId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Employee tempEmployee = currentSession.get(Employee.class, employeeId);

		return tempEmployee;
	}

	@Override
	public void save(Employee employee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(employee);

	}

	@Override
	public void delete(int employeeId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee tempEmployee = currentSession.get(Employee.class, employeeId);
		
		currentSession.delete(tempEmployee);

	}

}
