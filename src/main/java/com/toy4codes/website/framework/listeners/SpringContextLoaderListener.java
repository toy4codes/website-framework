package com.toy4codes.website.framework.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

public class SpringContextLoaderListener extends ContextLoaderListener implements ServletContextListener {

	private static final Logger log = Logger.getLogger(SpringContextLoaderListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.debug("spring container initialized.");
		super.contextInitialized(event);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		log.debug("spring container destroyed.");
		super.contextDestroyed(event);
	}

}
