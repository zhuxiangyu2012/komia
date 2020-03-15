package com.komia.common.listener;

import javax.servlet.ServletContextEvent;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;

public class KomiaLogbackConfigListener extends LogbackConfigListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String attribute = event.getServletContext().getInitParameter("spring.profiles.active");
	    System.setProperty("Active_Profile", attribute);
		super.contextInitialized(event);
	}
	
}
