package com.example.campus.controller;

import javax.servlet.http.HttpServletRequest;

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
     * サービスクラスへのアクセス
     */
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;

	/**
	 * 登録画面に遷移する
	 * @return 登録画面へのパス
	 */
	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	/**
	 * 確認画面に遷移する
	 * @return 確認画面へのパス
	 */
	@PostMapping("/confirm")
	public String confirm(
			@ModelAttribute("question") String question,
			HttpServletRequest request,
			Model model) {

		String[] array_answer = request.getParameterValues("answer");

		//questionの入力値が空の場合
		if(question.length() == 0){
			model.addAttribute("error_msg", "問題を入力してください");
			return "register";

		//questionの入力値が500文字より長いの場合
		}else if(question.length() > 500) {
			model.addAttribute("error_msg", "問題の文字数が500文字を超えています");
			return "register";

		}else{
			//answerの配列の長さ分、ループ処理
			for(int j=0; j<array_answer.length; j++){

				//answerの文字列の長さが0だった場合 = 入力値が空だった場合
				if(array_answer[j].length() == 0) {
					model.addAttribute("error_msg", "答えを入力してください");
					return "register";

				//answerが200文字以上だった場合
				}else if (array_answer[j].length() > 200) {
					model.addAttribute("error_msg", "答えの文字数が200文字を超えています");
					return "register";
				}
			}
		}
		model.addAttribute("question", question);
		model.addAttribute("array_answer", array_answer);
		return "confirm";
	}

	/**
	 * 一覧画面に遷移する
	 * @return 一覧画面へのパス
	 */
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute("question") String question,
			Questions questions,
			Answers answers,
			HttpServletRequest request
			) {

		String[] array_answer = request.getParameterValues("answer");

		questions.setQuestion(question);
		questionService.create(questions);

		for (int i = 0; i < array_answer.length; i++) {
			answers.setAnswer(array_answer[i]);
			answerService.create(answers);
		}

		return "redirect:/list";
	}

}
