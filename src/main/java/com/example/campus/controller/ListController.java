package com.example.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.campus.service.AnswerService;
import com.example.campus.service.QuestionService;

@Controller
public class ListController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    //Get
    @GetMapping("/list")
    public String getList(Model model) {
        //questionServiceから受け取ったデータをView側に渡す。
        model.addAttribute("questionList", questionService.findAll());
        model.addAttribute("answerList", answerService.findAll());
        return "list";
    }

	//Post
	@PostMapping("/list")
	public String postList(Model model) {
		//questionServiceから受け取ったデータをView側に渡す。
        model.addAttribute("questionList", questionService.findAll());
        model.addAttribute("answerList", answerService.findAll());
		return "list";
	}

}
