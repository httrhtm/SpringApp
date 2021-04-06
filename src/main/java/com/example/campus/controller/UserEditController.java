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
	public String confirm(@ModelAttribute("id") int id,
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

		//passwordの入力値が空、もしくは半角英数字でなかった場合、ユーザー登録画面に戻す
		if(pass == null || !pass.matches("^[A-Za-z0-9]+$")){
			model.addAttribute("error_msg", "パスワードを半角英数字で入力してください");
			model.addAttribute("user", userService.findByUsersId(id));
			return "userEdit";

			//passwordがpassword_confirmと一致しなかった場合、ユーザー登録画面に戻す
		}else if(!pass.equals(confirm_pass)) {
			model.addAttribute("error_msg", "PWとPW確認が一致しませんでした");
			model.addAttribute("user", userService.findByUsersId(id));
			return "userEdit";

			//passwordの長さが8文字より短かった場合、ユーザー登録画面に戻す
		}else if(pass.length() < 8) {
			model.addAttribute("error_msg", "パスワードを8文字以上で入力してください");
			model.addAttribute("user", userService.findByUsersId(id));
			return "userEdit";

		}

		return "userEditConfirm";
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
