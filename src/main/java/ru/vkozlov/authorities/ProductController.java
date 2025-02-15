package ru.vkozlov.authorities;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

	private Logger logger = Logger.getLogger(ProductController.class.getName());
	
	@PostMapping("/add")
	public String addProduct(@RequestParam String name) {
		logger.info("adding product: " + name);
		
		return "main.html";
	}
	
}
