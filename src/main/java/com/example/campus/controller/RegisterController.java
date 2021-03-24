package com.example.campus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.campus.entity.Question;

@Controller
@SessionAttributes(types = Question.class)
public class RegisterController {

	@ModelAttribute("question")
	public Question createQuestion() {
		Question question = new Question();
		return question;
	}

	//入力画面の表示
	@GetMapping("/register")
	public String register(Question question) {
		return "register";
	}

	//確認画面に遷移する
	@PostMapping("/confirm")
	public String confirm(Model model, Question question) {
		model.addAttribute("question");
		return "confirm";
	}

}
