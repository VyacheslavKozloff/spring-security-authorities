package ru.vkozlov.authorities;

import java.util.Optional;
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
	public void saveToken(CsrfToken scrfToken, HttpServletRequest request, HttpServletResponse response) {
		String identifier = request.getHeader("X-IDENTIFIER");
		Optional<Token> existingToken = tokenRepository.findTokenByIdentifier(identifier);
		if (existingToken.isPresent()) { 
			Token token = existingToken.get(); 
			token.setToken(token.getToken());
		} else { 
			Token token = new Token(); 
			token.setToken(token.getToken()); 
			token.setIdentifier(identifier); 
			tokenRepository.save(token);
		}
	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		String identifier = request.getHeader("X-IDENTIFIER");
		Optional<Token> existingToken = tokenRepository.findTokenByIdentifier(identifier);
		if (existingToken.isPresent()) {
			Token token = existingToken.get();
			return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token.getToken());
		}
			return null;
		}
			
	}
