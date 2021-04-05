package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.entity.Users;
import com.example.campus.service.UserDetailsImplService;

@Controller
public class UserDeleteController {

	@Autowired
	private UserDetailsImplService userService;

	/**
	 * 確認画面に遷移する
	 * @return 確認画面へのパス
	 */
	@PostMapping("/userDeleteConfirm")
	public String confirm(@ModelAttribute("id") int id,
			Model model) {

		model.addAttribute("user", userService.findByUsersId(id));
		return "userDeleteConfirm";
	}

	/**
	 * 一覧画面に遷移する
	 * >deleteflagに1を入れる
	 * @return 一覧画面へのパス
	 */
	@PostMapping("/userDelete")
	public String userUpdate(@ModelAttribute("id") int id,
			Users users) {

		users.setId(id);

		userService.delete(users);
		return "redirect:/userLists";
	}

}
