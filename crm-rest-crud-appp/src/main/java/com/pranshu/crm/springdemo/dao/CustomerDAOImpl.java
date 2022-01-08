package com.pranshu.crm.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranshu.crm.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// create a session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get current session
		Session session = sessionFactory.getCurrentSession();
		// create query
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName",Customer.class);
		// make query
		List<Customer> customers = theQuery.getResultList();
		// return the list
		return customers;
	}

	@Override
	public Customer getCustomer(int theId) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// ask for the required customer
		Customer theCustomer = session.get(Customer.class, theId);
		// return the customer
		return theCustomer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// save / update the customer
		session.saveOrUpdate(theCustomer);
	}	

	@Override
	public void deleteCustomer(int theId) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// query for deletion
		Query<?> theQuery = session.createQuery("delete from Customer where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", theId);
		// execute the query
		theQuery.executeUpdate();
	}

}
