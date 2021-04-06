package com.example.campus.controller;

import javax.servlet.http.HttpServletRequest;

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
     * サービスクラスへのアクセス
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
	public String confirm(@ModelAttribute("id") int id,
			@ModelAttribute("question") String question,
			@ModelAttribute("answer_id") String answer_id,
			@ModelAttribute("questions_id") String questions_id,
			HttpServletRequest request,
			Model model) {

		String[] array_answer = request.getParameterValues("answer");

		//questionの入力値が空の場合
		if(question.length() == 0){
			model.addAttribute("error_msg", "問題を入力してください");
			model.addAttribute("question", questionService.findOne(id));
			model.addAttribute("answerList", answerService.findAll());
			return "edit";

		//questionの入力値が500文字より長いの場合
		}else if(question.length() > 500) {
			model.addAttribute("error_msg", "問題の文字数が500文字を超えています");
			model.addAttribute("question", questionService.findOne(id));
			model.addAttribute("answerList", answerService.findAll());
			return "edit";

		}else{
			//answerの配列の長さ分、ループ処理
			for(int j=0; j<array_answer.length; j++){

				//answerの文字列の長さが0だった場合 = 入力値が空だった場合
				if(array_answer[j].length() == 0) {
					model.addAttribute("error_msg", "答えを入力してください");
					model.addAttribute("question", questionService.findOne(id));
					model.addAttribute("answerList", answerService.findAll());
					return "edit";

				//answerが200文字以上だった場合
				}else if (array_answer[j].length() > 200) {
					model.addAttribute("error_msg", "答えの文字数が200文字を超えています");
					model.addAttribute("question", questionService.findOne(id));
					model.addAttribute("answerList", answerService.findAll());
					return "edit";
				}
			}
		}
		model.addAttribute("id", id);
		model.addAttribute("question", question);
		model.addAttribute("answer_id", answer_id);
		model.addAttribute("questions_id", questions_id);
		model.addAttribute("array_answer", array_answer);

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

		questionService.update(questions);
		answerService.update(answers);
		return "redirect:/list";
	}

}
