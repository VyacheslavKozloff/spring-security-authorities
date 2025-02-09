package ru.vkozlov.authorities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
	Optional<Token> findTokenByIdentifier(String identifier);
}
