package com.example.campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.campus.model.QuestionService;

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

	//login Get
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	//top Get
	@GetMapping("/top")
	public String top() {
		return "top";
	}

	//top Post
	@PostMapping("/top")
	public String postTop() {
		return "top";
	}

	//list Get
    @Autowired
    private QuestionService questionService;

    @GetMapping("/list")
    public String getList(Model model) {
        //questionServiceから受け取ったデータをView側に渡す。
        model.addAttribute("questionList", questionService.findAll());
        return "list";
    }

	//list Post
	@PostMapping("/list")
	public String postList(Model model) {
		//questionServiceから受け取ったデータをView側に渡す。
        model.addAttribute("questionList", questionService.findAll());
		return "list";
	}

}
