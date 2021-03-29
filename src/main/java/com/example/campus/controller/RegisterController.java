package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.campus.entity.Answers;
import com.example.campus.entity.Questions;
import com.example.campus.service.AnswerService;
import com.example.campus.service.QuestionService;

//フロントエンドとサーバーサイドの入出力の管理を行う
@Controller
public class RegisterController {

	/**
     * Questionサービスクラスへのアクセス
     */
	@Autowired
	private QuestionService questionService;
	private AnswerService answerService;

	/**
	 * 登録画面に遷移する
	 * @return 登録画面へのパス
	 */
	//question
	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	/**
	 * 確認画面に遷移する
	 * @return 確認画面へのパス
	 */
	//question
	@PostMapping("/confirm")
	public String confirm(@ModelAttribute("question") String question, @ModelAttribute("answer") String answer, Model model) {
		model.addAttribute(question, "question");
		model.addAttribute(answer, "answer");
		return "confirm";
	}

	/**
	 * 一覧画面に遷移する
	 * @return 一覧画面へのパス
	 */
	//question
	@PostMapping("/insert")
	public String insert(Questions question, Answers answer) {
		//insert
		questionService.create(question);
		answerService.create(answer);

		return "redirect:/list";
	}



}
