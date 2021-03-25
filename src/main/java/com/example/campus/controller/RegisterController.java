package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.campus.entity.Questions;
import com.example.campus.service.QuestionService;

//フロントエンドとサーバーサイドの入出力の管理を行う
@Controller
@SessionAttributes(types = Questions.class)
public class RegisterController {

	/**
     * Questionサービスクラスへのアクセス
     */
	@Autowired
	private QuestionService service;

	/**
	 * 入力値を取得してconfirmに返す
	 * @return 入力値
	 */
	@ModelAttribute("questionForm")
	public Questions getQuestion() {
		return new Questions();
	}

	/**
	 * 登録画面に遷移する
	 * @return 登録画面へのパス
	 */
	@RequestMapping("/register")
	public String register(@ModelAttribute("questionForm") Questions questions) {
		return "register";
	}

	/**
	 * 確認画面に遷移する
	 * @return 確認画面へのパス
	 */
	@PostMapping("/confirm")
	public String confirm(@ModelAttribute("questionForm") Questions questions) {
		return "confirm";
	}

	@GetMapping("/confirm")
	public String getData(@ModelAttribute("questionForm") Questions questions) {
		return "confirm";
	}

	/**
	 * 一覧画面に遷移する
	 * @return 一覧画面へのパス
	 */
	@PostMapping("/insert")
	public String insertQuestin(@ModelAttribute Questions questions, Model model) {
		service.insertQuestion(questions); //DBにinsert
		return "redirect:/list";
	}

	@GetMapping("/insert")
	public String insert(@ModelAttribute Questions questions, Model model) {
		service.insertQuestion(questions); //DBにinsert
		return "redirect:/list";
	}


}
