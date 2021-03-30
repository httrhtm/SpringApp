package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.entity.Questions;
import com.example.campus.service.AnswerService;
import com.example.campus.service.QuestionService;

@Controller
public class EditController {

	/**
     * Questionサービスクラスへのアクセス
     */
	@Autowired
	private QuestionService questionService;
	private AnswerService answerService;

	/**
	 * 編集画面に遷移する
	 * > idの一致するquestionを表示
	 * > idとquestion_idが一致するanswerを表示
	 * @return 編集画面へのパス
	 */
	@PostMapping("/edit")
	public String edit(@ModelAttribute("id") int id, Model model) {
		model.addAttribute("question", questionService.findOne(id));
//		model.addAttribute("answerList", answerService.findAll());
		return "edit";
	}

	/**
	 * 確認画面に遷移する
	 * > 編集後の入力値を表示する
	 * @return 確認画面へのパス
	 */
	@PostMapping("/editConfirm")
	public String confirm(@ModelAttribute("id") String id, @ModelAttribute("question") String question,  Model model) {
		model.addAttribute("id", id);
		model.addAttribute("question", question);
		return "editConfirm";
	}

	/**
	 * 一覧画面に遷移する
	 * > データベースをUPDATE
	 * @return 一覧画面へのパス
	 */
	@PostMapping("update/{id}") //更新
	public String update(@PathVariable int id, @ModelAttribute Questions question) {
		question.setId(id);
		System.out.println(id);
		//update
		questionService.update(question);
//		answerService.update(answer);
		return "redirect:/list";
	}

}
