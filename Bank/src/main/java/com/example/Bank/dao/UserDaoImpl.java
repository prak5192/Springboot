package com.example.Bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Bank.entity.Customer;
import com.example.Bank.entity.User;

@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUserDetailsToDao(User user) {
		System.out.println("[UserDaoImpl]:[UserDaoImpl]: Input: " + user.toString() );
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		
	}
	
	@Override
	public List<User> getUserExtraDetails(){
		System.out.println("[UserDaoImpl]:[UserDaoImpl]: Input: " );
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> userList = (List<User>) query.list();
		tx.commit();
		if(userList != null) {
			System.out.println("Fetch User Extra details  : " + userList.toString());
		}
		return userList;
		
	}

	

}
