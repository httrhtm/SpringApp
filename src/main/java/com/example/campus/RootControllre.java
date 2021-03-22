package com.example.campus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//システムに対して最初にアクセスがあったときに処理するコントローラー
public class RootControllre {

	//リクエストを処理するメソッド
	@RequestMapping("/")
	//rootにアクセスがあった時はindexを表示する
	public String root() {
		return "index";
	}

	@PostMapping("/index") //postで送信されたリクエストを処理
	public String index() {
		return "index";
	}

	@GetMapping("/login") //getで送信されたリクエストを処理
	public String login() {
		return "login";
	}
}
