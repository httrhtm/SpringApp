package com.example.campus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.entity.Users;
import com.example.campus.service.UserDetailsImplService;

@Controller
public class TopController {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserDetailsImplService userService;

	/**
	 * トップ画面に遷移する
	 * > 管理者権限の有無で表示内容を変える
	 * @return トップ画面へのパス
	 */
	@PostMapping("/top")
	public String postTop(Model model) {
		int id = Integer.valueOf(String.valueOf(session.getAttribute("user_id")));
		Users user = userService.findByUsersId(id);

		model.addAttribute("user", user);
		return "top";
	}

	/**
	 * 【※URL直打ちの場合】
	 */
	@GetMapping("/top")
	public String top(Model model) {
		int id = Integer.valueOf(String.valueOf(session.getAttribute("user_id")));
		Users user = userService.findByUsersId(id);

		model.addAttribute("user", user);
		return "top";
	}

}
