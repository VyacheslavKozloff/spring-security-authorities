package ru.vkozlov.authorities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class ProjectConfiguration {
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		UserDetails user1 = User.withUsername("bob").password("123").roles("MANAGER").build();
		UserDetails user2 = User.withUsername("bill").password("123").roles("ADMIN").build();
		
		manager.createUser(user1);
		manager.createUser(user2);
		
		return manager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.formLogin(c -> c.defaultSuccessUrl("/main", true));
		http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
		
		return http.build();
	}
}
