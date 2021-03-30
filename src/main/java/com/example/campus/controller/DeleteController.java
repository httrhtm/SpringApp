package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.entity.Questions;
import com.example.campus.service.QuestionService;

@Controller
public class DeleteController {

	/**
     * サービスクラスへのアクセス
     */
	@Autowired
	private QuestionService questionService;

	@PostMapping("/deleteConfirm")
	public String deleteConfirm(@ModelAttribute("id") int id, Model model) {
		model.addAttribute("question", questionService.findOne(id));
        return "deleteConfirm";
    }

	@PostMapping("/delete")
    public String delete(@ModelAttribute("id") int id, Questions questions) {
		questions.setId(id);
        questionService.delete(questions);
        return "redirect:/list";
    }
}
