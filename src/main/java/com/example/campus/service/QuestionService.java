package com.example.campus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campus.entity.Questions;
import com.example.campus.repository.QuestionRepository;

//具体的な処理（ビジネスロジック）を記述するクラス
@Service
public class QuestionService {

	/**
     * questionsテーブルへアクセスするQuestionRepository(mapper)
     */
    @Autowired
    private QuestionRepository repository;

    /**
     * questionsテーブルの全件を取得する
     *
     * @return questionsテーブル全件
     */
    public List<Questions> findAll() {
    	return repository.findAll();
    }

	public void create(Questions question) {
		repository.create(question);
	}


}
