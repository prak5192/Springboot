package com.example.Bank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Bank.entity.Customer;

@Component
public class CustomerAtmDaoImpl implements CustomerAtmDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveCustomerDetails(Customer customer) {
		System.out.println("[CustomerAtmDaoImpl]:[saveCustomerDetails]: Input: " + customer.toString() );
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
	
		
	}
	@Override
	public void saveAllCustomerList(List<Customer> customerList) {
		System.out.println("[CustomerAtmDaoImpl]:[saveAllCustomerList]: Input: " + customerList);	
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		for(Customer temp : customerList ) {
			session.saveOrUpdate(temp);
		}
		tx.commit();
	}
	
	@Override
	public Customer fetchCustomerBypanNo( String panNo) {
		System.out.println("[CustomerAtmDaoImpl]:[fetchCustomerBypanNo]: Input: " + panNo );
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Customer where panNo= :panNofromUI ");
		query.setString("panNofromUI", panNo);
		Customer cust = (Customer) query.uniqueResult();
		tx.commit();
		if(cust != null) {
			System.out.println("Customer details on basis of unique panNo : " + cust.toString());
		}
		return cust;
	}

	@Override
	public List<Customer> getCustomerDetails() {
		System.out.println("[CustomerAtmDaoImpl]:[fetchCustomerBypanNo]: Input: "  );
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Customer");
		@SuppressWarnings("unchecked")
		List<Customer> custList = (List<Customer>)query.list();
		tx.commit();
		return custList;
	}

	@Override
	public void deleteCustomer(String panNo) {
		System.out.println("[CustomerAtmDaoImpl]:[deleteCustomer]: Input: "  );
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Customer where panNo= :panNofromUI ");
		query.setString("panNofromUI", panNo);
		Customer cust = (Customer) query.uniqueResult();
		session.delete(cust);
		tx.commit();
		
	}
	
	@Override
	public void saveTransactionDetails(com.example.Bank.entity.Transaction transaction) {
		System.out.println("[CustomerAtmDaoImpl]:[saveTransactionDetails]: Input: " + transaction.toString() );
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(transaction);
		tx.commit();
	}
	
	@Override
	public List<com.example.Bank.entity.Transaction> getMiniStatementForGivenUser(String panNo) {
		System.out.println("[CustomerAtmDaoImpl]:[getMiniStatementForGivenUser]: Input: " + panNo.toString() );
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Transaction where panNo= :panNofromUI ");
		query.setString("panNofromUI", panNo);
		List<com.example.Bank.entity.Transaction> trans = (List<com.example.Bank.entity.Transaction>) query.list();
		tx.commit();
		return trans;
	}

}
