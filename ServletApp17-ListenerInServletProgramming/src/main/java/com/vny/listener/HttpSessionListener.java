//update httpsession application with listener
package com.vny.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class HttpSessionListener implements javax.servlet.http.HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		javax.servlet.http.HttpSessionListener.super.sessionCreated(se);
	System.out.println("HttpSessionListener.sessionCreated()");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		javax.servlet.http.HttpSessionListener.super.sessionDestroyed(se);
	System.out.println("HttpSessionListener.sessionDestroyed()");
	}

	
	
}
