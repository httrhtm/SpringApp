package com.example.campus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.campus.entity.Answers;
import com.example.campus.entity.Questions;
import com.example.campus.service.AnswerService;
import com.example.campus.service.QuestionService;

@Controller
public class ListController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping("/list")
    public String list(Model model) {

    	List<Questions> questionList = questionService.findAll();
    	List<Answers> answerList = answerService.findAll();

    	//questionが1つも登録されていなかった場合
    	if(questionList.size() == 0) {
    		return "register";

		} else {
			model.addAttribute("questionList", questionList);
			model.addAttribute("answerList", answerList);
			return "list";
		}

    }

}
