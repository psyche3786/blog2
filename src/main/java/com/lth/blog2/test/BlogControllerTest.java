package com.lth.blog2.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {
	
	@GetMapping("/hello/test")
	public String hello() {
		return "<h1>hello spring boot</h1>";
	}

}
