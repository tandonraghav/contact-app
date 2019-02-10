package com.plivo.contactapp.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;


public class CachedRequest extends OncePerRequestFilter{
	private static Logger logger = Logger.getLogger(MultipleReadHttpRequest.class);
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpServletRequest currentRequest = (HttpServletRequest) request;
        MultipleReadHttpRequest wrappedRequest = new MultipleReadHttpRequest(currentRequest);
        filterChain.doFilter(wrappedRequest, response);
	}	
}
