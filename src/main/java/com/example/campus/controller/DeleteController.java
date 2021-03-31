package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.entity.Answers;
import com.example.campus.entity.Questions;
import com.example.campus.service.AnswerService;
import com.example.campus.service.QuestionService;

@Controller
public class DeleteController {

	/**
     * サービスクラスへのアクセス
     */
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;

	/**
     * 削除確認画面に遷移する
     * > idが一致する問題を表示
     * > questions.idとcorrect_answers.questions_idが一致する答えを表示
     * @return 確認画面へのパス
     */
	@PostMapping("/deleteConfirm")
	public String deleteConfirm(@ModelAttribute("id") int id, Model model) {
		model.addAttribute("question", questionService.findOne(id));
		model.addAttribute("answerList", answerService.findAll());
        return "deleteConfirm";
    }

	/**
	 * 一覧画面に遷移する
	 * > データベースから対象の問題と答えを削除
	 * @return 一覧画面へのパス
	 */
	@PostMapping("/delete")
	public String delete(@ModelAttribute("id") int id,
			@ModelAttribute("questions_id") int questions_id,
			Questions questions, Answers answers) {

		//questions.idとcorrect_answers.questions_idが一致した場合
		if(id == questions_id) {
			//entityにセット
			questions.setId(id);
			answers.setQuestionsId(questions_id);
			//delete
			questionService.delete(questions);
			answerService.delete(answers);
		}
		return "redirect:/list";
	}
}
