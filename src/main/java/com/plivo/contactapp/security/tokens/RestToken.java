package com.plivo.contactapp.security.tokens;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class RestToken extends AbstractAuthenticationToken{

	private static final long serialVersionUID = 1L;

	private String username;
	
	public RestToken(Collection<? extends GrantedAuthority> authorities,String principal) {
		super(authorities);
		this.username=principal;
	}

	@Override
	public Object getCredentials() {
		return Math.random();
	}

	@Override
	public Object getPrincipal() {
		return username;
	}

}
