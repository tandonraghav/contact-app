package com.plivo.contactapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class InvalidSessionStrategy implements org.springframework.security.web.session.InvalidSessionStrategy{

	private static Logger logger = Logger.getLogger(InvalidSessionStrategy.class); 
	
	
	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}

}
