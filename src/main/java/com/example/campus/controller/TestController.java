package com.example.campus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.service.AnswerService;
import com.example.campus.service.QuestionService;
import com.example.campus.service.UserDetailsImplService;

@Controller
public class TestController {

	/**
     * サービスクラスへのアクセス
     */
	@Autowired
	private UserDetailsImplService userService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;

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
	public String postTestResult(@AuthenticationPrincipal UserDetailsImplService userDetails,
			@ModelAttribute("answer") String answer,
			Model model) {

		/**
		 * ログインユーザー名を取得するための処理
		 */

		/**
		 * 採点するための処理
		 */
		//問題数を取得
		int total = questionService.findAll().size();
		System.out.println(total);

		/**
		 * 現在時刻をフォーマットで取得するための処理
		 */
		SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
		String date = format.format(new Date());
		System.out.println(date);

		/**
		 * entityにセット
		 */

		/**
		 * create
		 */

		/**
		 * ビューに値を渡す
		 */
		//ユーザー名
		model.addAttribute("total", total); //問題数
		//正解数
		//得点
		model.addAttribute("date", date); //現在時刻
		return "testResult";
	}

}
