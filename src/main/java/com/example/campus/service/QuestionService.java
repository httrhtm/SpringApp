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
     * @return questionsテーブル全件
     */
    public List<Questions> findAll() {
    	return repository.findAll();
    }

    /**
     * レコードを新規作成する
     */
	public void create(Questions question) {
		repository.create(question);
	}

	/**
     * レコードをを更新
     * @return updateする値
     */
	public void update(Questions questions) {
		repository.update(questions);
	}

	/**
     * idが一致したレコードを取得する
     * @return idが一致したレコード
     */
	public Questions findOne(int id) {
		return repository.findOne(id);
	}

	/**
     * idが一致したレコードを削除する
     */
	public void delete(Questions questions) {
		repository.delete(questions);

	}


}
