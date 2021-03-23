package com.example.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	//Get
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	//Post
	@PostMapping("/login")
	public String postLogin() {
		return "login";
	}
}
