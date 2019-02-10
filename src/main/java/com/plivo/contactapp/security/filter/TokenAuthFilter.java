package com.plivo.contactapp.security.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plivo.contactapp.models.ErrorCode;
import com.plivo.contactapp.models.Response;
import com.plivo.contactapp.security.providers.RestTokenAuthProvider;
import com.plivo.contactapp.security.tokens.RestToken;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class TokenAuthFilter extends OncePerRequestFilter {

    private static Logger logger = Logger.getLogger(TokenAuthFilter.class);

    private RestTokenAuthProvider restTokenAuthProvider;

    private static final String X_AUTH_TOKEN = "x-auth-token";

    public TokenAuthFilter() {
    }

    public TokenAuthFilter(RestTokenAuthProvider restTokenAuthProvider) {
        this.restTokenAuthProvider = restTokenAuthProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        boolean authReqd = isAuthReqd(request);
        if (!authReqd) {
            filterChain.doFilter(request, response);
            return;
        }
        if (request.getHeader(X_AUTH_TOKEN) != null && request.getHeader(X_AUTH_TOKEN).equals("123456")) {
            //Authentication authentication=restTokenAuthProvider.authenticate(new RestToken(null));
            SecurityContextHolder.getContext().setAuthentication(new RestToken(null, "contact-app"));

        } else {
            updateFailureResponse(request, response);
            return;
        }
        //}
        filterChain.doFilter(request, response);
    }

    private void updateFailureResponse(HttpServletRequest request,
        HttpServletResponse response) {
        try {
            //RuleServiceException ex = new RuleServiceException(error);
            Response output = new Response();
            response.setStatus(HttpServletResponse.SC_OK);
            output.setSuccess(false);
            output.setErrorCode(ErrorCode.AUTH_FAILED);
            output.setErrorMessage(ErrorCode.AUTH_FAILED.name());
            response.setContentType("application/json");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getWriter().write(convertObjectToJson(output));

            logger.debug("Auth Failed: ");

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private boolean isAuthReqd(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if(
            (pathInfo.endsWith(".html")
                || pathInfo.endsWith(".png")
                || pathInfo.endsWith(".js")
                || pathInfo.endsWith(".css"))
                || pathInfo.endsWith("/v2/api-docs")
                || pathInfo.contains("swagger")
                || pathInfo.contains("/webjars/") ){
            return false;
        }
        return true;
    }

}
