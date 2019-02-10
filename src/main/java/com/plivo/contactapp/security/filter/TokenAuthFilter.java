package com.plivo.contactapp.security.filter;

import com.plivo.contactapp.security.tokens.RestToken;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.plivo.contactapp.security.providers.RestTokenAuthProvider;


public class TokenAuthFilter extends OncePerRequestFilter{

	private static Logger logger = Logger.getLogger(TokenAuthFilter.class); 
	
	private RestTokenAuthProvider restTokenAuthProvider;

	private static final String X_AUTH_TOKEN="x-auth-token";
	
	public TokenAuthFilter() {
		// TODO Auto-generated constructor stub
	}
	
	public TokenAuthFilter(RestTokenAuthProvider restTokenAuthProvider) {
		this.restTokenAuthProvider=restTokenAuthProvider;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//if(SecurityContextHolder.getContext().getAuthentication()==null){
			if(request.getHeader(X_AUTH_TOKEN)!=null && request.getHeader(X_AUTH_TOKEN).equals("123456")){
				//Authentication authentication=restTokenAuthProvider.authenticate(new RestToken(null));
				SecurityContextHolder.getContext().setAuthentication(new RestToken(null,"contact-app"));
				
			}else{
				response.setContentType("application/json");
				String errorResponse = "{'error':'Bad Key'}";
				response.getWriter().write(errorResponse);
			}
		//}
		filterChain.doFilter(request, response);
	}

}
