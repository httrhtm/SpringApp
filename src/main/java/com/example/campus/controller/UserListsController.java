package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.service.UserDetailsImplService;

@Controller
public class UserListsController {

	@Autowired
	private UserDetailsImplService userService;

	@PostMapping("/userLists")
	public String postUserLists(Model model){

		model.addAttribute("userList", userService.findAll());
		return "userLists";

	}

	@GetMapping("/userLists")
	public String getUserLists(Model model){

		model.addAttribute("userList", userService.findAll());
		return "userLists";

	}

}
