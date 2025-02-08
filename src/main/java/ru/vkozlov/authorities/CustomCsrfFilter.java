package ru.vkozlov.authorities;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.security.web.csrf.CsrfToken;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class CustomCsrfFilter implements Filter {

	private Logger logger = Logger.getLogger(CustomCsrfFilter.class.getName());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		
		logger.info("CSRF Token: " + token.getToken());
		chain.doFilter(request, response);
		
	}

}
