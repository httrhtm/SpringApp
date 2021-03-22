package com.example.campus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//システムに対して最初にアクセスがあったときに処理するコントローラー
public class RootControllre {

	//rootにアクセスがあった時はindex.htmlを表示する
	@RequestMapping("/")
	public String root() {
		return "login";
	}

	//index
//	@PostMapping("/index")
//	public String index() {
//		return "index";
//	}

	//login
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	//top
	@GetMapping("/top")
	public String top() {
		return "top";
	}

	//list
	@PostMapping("/list")
	public String list() {
		return "list";
	}
}
