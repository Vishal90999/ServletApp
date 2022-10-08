package com.vny.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ContextListener implements ServletRequestListener{

	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		
		ServletRequestListener.super.requestInitialized(sre);
		System.out.println("ContextListener.requestInitialized()");
		System.out.println(sre.getServletContext());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		ServletRequestListener.super.requestDestroyed(sre);
		System.out.println("ContextListener.requestDestroyed()");
	}

	
}
