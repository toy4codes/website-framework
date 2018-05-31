package com.toy4codes.website.framework.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextLoaderListener extends ContextLoaderListener implements ServletContextListener {

	private static final Logger log = Logger.getLogger(SpringContextLoaderListener.class);

	private static ServletContext servletContext;

	private static WebApplicationContext springContext;

	// private static

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		log.debug("spring container initialized.");
		super.contextInitialized(event);

		SpringContextLoaderListener.servletContext = event.getServletContext();
		SpringContextLoaderListener.springContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		log.debug("spring container destroyed.");
		super.contextDestroyed(event);
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static WebApplicationContext getSpringContext() {
		return springContext;
	}

}
