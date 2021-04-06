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
public class UserRegister {

	@Autowired
	private UserDetailsImplService userService;

	@Autowired
    PasswordEncoder passwordEncoder;
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

		//nameの入力値が空、もしくは半角英数字でなかった場合、ユーザー登録画面に戻す
		if(name == null || !name.matches("^[A-Za-z0-9]+$")){
			model.addAttribute("error_msg", "ユーザ名を半角英数字で入力してください");
			return "userRegister";

		//passwordの入力値が空、もしくは半角英数字でなかった場合、ユーザー登録画面に戻す
		}else if(pass == null || !pass.matches("^[A-Za-z0-9]+$")){
			model.addAttribute("error_msg", "パスワードを半角英数字で入力してください");
			return "userRegister";

		//passwordがpassword_confirmと一致しなかった場合、ユーザー登録画面に戻す
		}else if(!pass.equals(confirm_pass)) {
			model.addAttribute("error_msg", "PWとPW確認が一致しませんでした");
			return "userRegister";

		//passwordの長さが8文字より短かった場合、ユーザー登録画面に戻す
		}else if(pass.length() < 8) {
			model.addAttribute("error_msg", "パスワードを8文字以上で入力してください");
			return "userRegister";
		}

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
		users.setPassword(passwordEncoder.encode(pass));
		users.setAdminFlag(admin_flag);

		userService.create(users);
		return "redirect:/userLists";
	}

}
