package ru.vkozlov.authorities;

import java.util.UUID;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomCsrfTokenRepository implements CsrfTokenRepository {
	
	private final TokenRepository tokenRepository;
	
	public CustomCsrfTokenRepository(TokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}

	@Override
	public CsrfToken generateToken(HttpServletRequest httpServletRequest) {
		String uuid = UUID.randomUUID().toString();
		return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
	}

	@Override
	public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
