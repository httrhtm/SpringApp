package com.example.campus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.entity.Answers;
import com.example.campus.entity.Histories;
import com.example.campus.entity.Questions;
import com.example.campus.entity.Users;
import com.example.campus.service.AnswerService;
import com.example.campus.service.HistoryService;
import com.example.campus.service.QuestionService;
import com.example.campus.service.UserDetailsImplService;

@Controller
public class TestController {

	/**
     * サービスクラスへのアクセス
     */
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private HistoryService historyService;

	/**
	 * テスト画面に遷移する
	 * > 問題をランダムに全て表示
	 * @return テスト画面へのパス
	 */
	@PostMapping("/test")
	public String postTest(Model model) {
		model.addAttribute("questionList", questionService.RandomAll());
		return "test";
	}

	/**
	 * 【※URL直打ちの場合】
	 */
	@GetMapping("/test")
	public String getTest(Model model) {
		model.addAttribute("questionList", questionService.RandomAll());
		return "test";
	}

	/**
	 * テスト結果画面に遷移する
	 * > ログインユーザーを表示する
	 * > 問題数と正解数を表示する
	 * > 得点を表示する = {(正解数 ×100) / 問題数}
	 * > 現在時刻を表示する
	 * @return テスト結果画面へのパス
	 */
	@PostMapping("/testResult")
	public String postTestResult(HttpServletRequest request,
			@AuthenticationPrincipal UserDetailsImplService userDetails,
//			@ModelAttribute("answer") String[] answers,
			Users users, Histories histories, Model model) {

		/**
		 * 採点するための処理
		 */
		String[] array_answer = request.getParameterValues("answer");

		List<Questions> questionList = questionService.findAll();
		List<Answers> answerList = answerService.findAll();

		//問題数を取得
		int total = questionList.size();
		System.out.println(total);
		//pointを定義
		int point = 0;

		//【問題】繰り返し処理
		for(int i = 0; i < total; i++){
			//【答え】繰り返し処理
			for(int j=0; j < answerList.size(); j++){
				System.out.println(answerList.size());
				//【条件】idとquestion_idが同じでない場合、以下の処理をスキップ
				if(questionList.get(i).getId() != answerList.get(j).getQuestionsId()){
					continue;
				}
				//【入力値】繰り返し処理（※配列の長さ⚪︎ 文字列×）
				for(int k=0; k < array_answer.length; k++) {
					//【条件】correct_answers.answerと入力値が同じ場合（string:equalsメソッド）
					if(answerList.get(j).getAnswer().equals(array_answer[k])) {
						System.out.println(array_answer[k]);
						point++;
						System.out.println(point);
					}
				}
			}
		}
		//得点の計算
		long score = 0;
		score = Math.round((point * 100) / total);

		/**
		 * 現在時刻をフォーマットで取得するための処理
		 */
		SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
		String date = format.format(new Date());

		/**
		 * entityにセット
		 */
//		int user_id = (int)userDetails.getId(); //user_idを取得
		int int_score = (int)score;			//得点をintに変換

//		histories.setId(user_id);
		histories.setPoint(int_score);

		/**
		 * create
		 */
//		historyService.create(histories);

		/**
		 * ビューに値を渡す
		 */
		model.addAttribute("total", total); //問題数
		model.addAttribute("point", point); //正解数
		model.addAttribute("score", score); //得点
		model.addAttribute("date", date);	//現在時刻
		return "testResult";
	}

}
