package com.example.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	//rootにアクセスがあった時、ログインページへ
	@RequestMapping("/")
	public String root() {
		return "login";
	}

}
