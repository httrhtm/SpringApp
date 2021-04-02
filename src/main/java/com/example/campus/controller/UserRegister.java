package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.campus.entity.Users;
import com.example.campus.service.UserDetailsImplService;

@Controller
public class UserRegister {

	@Autowired
	private UserDetailsImplService userService;

	/**
	 * 登録画面に遷移する
	 * @return 登録画面へのパス
	 */
	@RequestMapping("/userRegister")
	public String userRegister() {
		return "userRegister";
	}

	/**
	 * 確認画面に遷移する
	 * @return 確認画面へのパス
	 */
	@PostMapping("/userRegisterConfirm")
	public String confirm(@ModelAttribute("name") String name,
			@ModelAttribute("pass") String pass,
			@ModelAttribute("confirm_pass") String confirm_pass,
			@ModelAttribute("admin_check") String adminCheck,
			Model model) {

		if(adminCheck.isEmpty()) {
			model.addAttribute("admin_check", "0");
		} else {
			model.addAttribute("admin_check", "1");
		}

		model.addAttribute("name", name);
		model.addAttribute("pass", pass);
		model.addAttribute("confirm_pass", confirm_pass);
		return "userRegisterConfirm";
	}

	/**
	 * 一覧画面に遷移する
	 * @return 一覧画面へのパス
	 */
	@PostMapping("/insertUser")
	public String insertUser(@ModelAttribute("name") String name,
			@ModelAttribute("pass") String pass,
			@ModelAttribute("admin") String str_admin,
			Users users) {

		byte admin_flag = Byte.parseByte(str_admin);

		users.setName(name);
		users.setPassword(pass);
		users.setAdminFlag(admin_flag);

		userService.create(users);
		return "redirect:/userLists";
	}




}
