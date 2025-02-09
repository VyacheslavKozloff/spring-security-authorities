package ru.vkozlov.authorities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String identifear;
	private String token;
	
	public Token() {}

	public Token(int id, String identifear, String token) {
		super();
		this.id = id;
		this.identifear = identifear;
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifear() {
		return identifear;
	}

	public void setIdentifear(String identifear) {
		this.identifear = identifear;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
