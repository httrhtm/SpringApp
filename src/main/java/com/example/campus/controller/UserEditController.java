package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.campus.entity.Users;
import com.example.campus.service.UserDetailsImplService;

@Controller
public class UserEditController {

	@Autowired
	private UserDetailsImplService userService;

	@Autowired
    PasswordEncoder passwordEncoder;

	/**
	 * 編集画面に遷移する
	 * @return 編集画面へのパス
	 */
	@RequestMapping("/userEdit")
	public String userEdit(@ModelAttribute("id") int id, Model model) {

		model.addAttribute("user", userService.findByUsersId(id));
		return "userEdit";
	}

	/**
	 * 確認画面に遷移する
	 * @return 確認画面へのパス
	 */
	@PostMapping("/userEditConfirm")
	public String confirm(@ModelAttribute("id") String id,
			@ModelAttribute("name") String name,
			@ModelAttribute("pass") String pass,
			@ModelAttribute("confirm_pass") String confirm_pass,
			@ModelAttribute("admin_check") String adminCheck,
			Model model) {

		if(adminCheck.isEmpty()) {
			model.addAttribute("admin_check", "0");
		} else {
			model.addAttribute("admin_check", "1");
		}

		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("pass", pass);
		model.addAttribute("confirm_pass", confirm_pass);
		return "userRegisterConfirm";
	}

	/**
	 * 一覧画面に遷移する
	 * @return 一覧画面へのパス
	 */
	@PostMapping("/userUpdate")
	public String userUpdate(@ModelAttribute("id") int id,
			@ModelAttribute("name") String name,
			@ModelAttribute("pass") String pass,
			@ModelAttribute("admin") String str_admin,
			Users users) {

		byte admin_flag = Byte.parseByte(str_admin);

		users.setId(id);
		users.setName(name);
		users.setPassword(passwordEncoder.encode(pass));
		users.setAdminFlag(admin_flag);

		userService.edit(users);
		return "redirect:/userLists";
	}

}
