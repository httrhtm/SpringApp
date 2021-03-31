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
public class EditController {

	/**
     * Questionサービスクラスへのアクセス
     */
	@Autowired
	private QuestionService questionService;
	@Autowired
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
		model.addAttribute("answerList", answerService.findAll());
		return "edit";
	}

	/**
	 * 確認画面に遷移する
	 * > 編集後の入力値を表示する
	 * > idも一緒に渡す
	 * @return 確認画面へのパス
	 */
	@PostMapping("/editConfirm")
	public String confirm(@ModelAttribute("id") String id,
			@ModelAttribute("question") String question,
			@ModelAttribute("answer_id") String answer_id,
			@ModelAttribute("questions_id") String questions_id,
			@ModelAttribute("answer") String answer,
			Model model) {

		model.addAttribute("id", id);
		model.addAttribute("question", question);
		model.addAttribute("answer_id", answer_id);
		model.addAttribute("questions_id", questions_id);
		model.addAttribute("answer", answer);

		return "editConfirm";
	}

	/**
	 * 一覧画面に遷移する
	 * > データベースをUPDATE
	 * @return 一覧画面へのパス
	 */
	@PostMapping("/update")
	public String update(@ModelAttribute("id") int id,
			@ModelAttribute("question") String question,
			@ModelAttribute("answer_id") int answer_id,
			@ModelAttribute("questions_id") int questions_id,
			@ModelAttribute("answer") String answer,
			Questions questions, Answers answers) {

		//entityにセット
		questions.setId(id);
		questions.setQuestion(question);
		answers.setId(answer_id);
		answers.setQuestionsId(questions_id);
		answers.setAnswer(answer);

		//update
		questionService.update(questions);
		answerService.update(answers);
		return "redirect:/list";
	}

}
