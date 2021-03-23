package com.example.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TopController {

	//Get
	@GetMapping("/top")
	public String top() {
		return "top";
	}

	//Post
	@PostMapping("/top")
	public String postTop() {
		return "top";
	}

}
