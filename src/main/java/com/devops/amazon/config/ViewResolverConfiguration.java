package com.devops.amazon.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.devops")// search
public class ViewResolverConfiguration {
	
	//DataSource Connection with Database 
	
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		System.out.println("Datasource called");
		DriverManagerDataSource  dataSource=new DriverManagerDataSource(); // Driver Manager in JDBC
		dataSource.setDriverClassName("org.h2.Driver"); // Class used for H2 Db Connection
		dataSource.setUsername("sa"); // Authentication Details
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/amazon");// URl of Db 
		return dataSource;
	}
	
	// ViewResolver
	 @Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();// View Resolver for Spring
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/"); //Place where Views will be stored
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
}
