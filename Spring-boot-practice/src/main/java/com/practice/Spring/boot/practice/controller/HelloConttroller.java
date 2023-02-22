package com.practice.Spring.boot.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConttroller {

	@GetMapping(value="/hi")
	public String HelloWorld() {
		return "Welcome";
		
	}
}
