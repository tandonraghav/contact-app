package com.plivo.contactapp.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.session.ExpiringSession;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestRestController {
	@Autowired FindByIndexNameSessionRepository<? extends ExpiringSession> sessionRepository;
	private static Logger logger = Logger.getLogger(TestRestController.class); 
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public String create(){
		return "Spring POST is Woring !!!";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.CREATED)
	public String get(){
		updateSession();
		return "Spring GET is Woring !!!";
	}

	private void updateSession() {
		logger.info("Entering sessionAuthstrategy");
		//HttpSession session=request.getSession();
		String username=String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		//Principal p=(Principal)authentication.getPrincipal();
		logger.info("username="+username);
		
		Collection<? extends ExpiringSession> userSessions = sessionRepository
				.findByIndexNameAndIndexValue(
				FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME,username).values();
		
		logger.info("userSessionsSize="+userSessions.size());
		
		for(ExpiringSession userSession : userSessions){
			logger.info(userSession.getId());
			sessionRepository.delete(userSession.getId());
		}
	}
	
	
	
	
}
