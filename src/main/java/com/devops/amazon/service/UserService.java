package com.devops.amazon.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devops.amazon.dao.UserDAO;
import com.devops.amazon.model.User;

@Service
public class UserService implements UserDAO {
	
	@Autowired
	private SessionFactory factory;

	@Transactional(propagation=Propagation.SUPPORTS) //to enable transaction
	public int create(User u) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();			
		tx.begin();	
		session.saveOrUpdate(u);
		tx.commit();
		return 1;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public User read(User u) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Criteria c=session.createCriteria(User.class); 
		// to select a certain user
		c.add(Restrictions.eq("emailId", u.getEmailId()));
		return (User)c.uniqueResult(); // retreiving the result
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public int update(User u) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();			
		tx.begin();	
		session.update(u);
		tx.commit();
		return 1;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public int delete(User u) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();			
		tx.begin();	
		session.delete(u);
		tx.commit();
		return 1;
	}

	public List<User> getAllUsers() {// return all records
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Criteria c= session.createCriteria(User.class);
		return c.list();
	}

}
