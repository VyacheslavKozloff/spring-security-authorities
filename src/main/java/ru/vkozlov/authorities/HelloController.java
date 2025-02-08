package ru.vkozlov.authorities;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/hello")
	public String postHello() {
		return "hello";
	}
	
	@GetMapping("/ciao")
	public String ciao() {
		return "ciao";
	}
	
}
