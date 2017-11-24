package com.devops.amazon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{ViewResolverConfiguration.class}; //on Load loads View Resolver
	}
	@Override
	protected Class<?>[] getServletConfigClasses() { // Servlet details if any
		
		return null;
	}
	@Override
	protected String[] getServletMappings() {
		return  new String[]{"/"};// Default Path of the App
	}

}

