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

import com.devops.amazon.dao.CategoryDAO;
import com.devops.amazon.model.Category;
@Service
public class CategoryService implements CategoryDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public int create(Category c) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.getCurrentSession();
		Transaction tx=session.beginTransaction();			
		tx.begin();	
		session.saveOrUpdate(c);
		tx.commit();
		return 1;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public Category read(Category c) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.getCurrentSession();
		Criteria cr=session.createCriteria(Category.class);
		cr.add(Restrictions.eq("Id", c.getId()));
		return (Category)cr.uniqueResult();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public int update(Category c) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.getCurrentSession();
		Transaction tx=session.beginTransaction();			
		tx.begin();	
		session.update(c);
		tx.commit();
		return 1;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public int delete(Category c) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.getCurrentSession();
		Transaction tx=session.beginTransaction();			
		tx.begin();	
		session.delete(c);
		tx.commit();
		return 1;
	}

	public List<Category> readAll(){
		Session session=sessionfactory.getCurrentSession();
		Criteria cr=session.createCriteria(Category.class);
		return cr.list(); 
	}
}
