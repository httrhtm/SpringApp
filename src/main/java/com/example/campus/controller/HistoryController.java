package com.example.campus.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.entity.Histories;
import com.example.campus.service.HistoryService;

@Controller
public class HistoryController {

	@Autowired
    private HistoryService historyService;
	@Autowired
    private HttpSession session;

	/**
	 * 採点結果履歴画面に遷移する
	 * > ログイン中のユーザーの履歴を表示する
	 * @return  採点結果履歴画面へのパス
	 */
	@PostMapping("/history")
	public String postHistory(Model model) {
		int user_id = Integer.valueOf(String.valueOf(session.getAttribute("user_id")));
		List<Histories> historyList = historyService.findByUsersId(user_id);
		model.addAttribute("historyList", historyList);

		return "history";
	}

	/**
	 * 【※URL直打ちの場合】
	 */
	@GetMapping("/history")
	public String getHistory(Model model) {
		int user_id = Integer.valueOf(String.valueOf(session.getAttribute("user_id")));
		List<Histories> historyList = historyService.findByUsersId(user_id);
		model.addAttribute("historyList", historyList);

		return "history";
	}
}
