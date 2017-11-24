package com.devops.amazon.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.devops.amazon.model.Category;
import com.devops.amazon.model.User;

@Configuration // Specify the system that this class is configuring Spring and Hibernate 
@ComponentScan("com") // will scan the Package for Controller (Spring) classes
@EnableTransactionManagement // Transactions Enabled (ACID Properties)
public class ApplicationConfiguration{
	
	//Hibernates Properties
	
	private  Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	//SessionFactory Bean (object) required for retreving session wtih db 
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		
		//Ecomerce Module
		
		localSessionFactoryBuilder.addAnnotatedClass(User.class);
		localSessionFactoryBuilder.addAnnotatedClass(Category.class);
		
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	//Hibernate Transaction
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
			HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
			return hibernateTransactionManager;			
	}
	
}


