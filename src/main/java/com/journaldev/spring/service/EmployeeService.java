package com.journaldev.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.hibernate.data.Employee;

@Component
public class EmployeeService {
	@Autowired
	private SessionFactory sessionFactory;
	List<Employee> list=new ArrayList();

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void register(Employee emp) {
		// Acquire session
		Session session = sessionFactory.getCurrentSession();
		// Save employee, saving behavior get done in a transactional manner
		session.save(emp);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> displayEmployee() {
		
		List<Employee> list=sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		return list;
	}

}
