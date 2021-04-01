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
     * 全件取得
     * @return 全件
     */
    public List<Questions> findAll() {
    	return repository.findAll();
    }

    /**
     * 全件取得（ランダム）
     * @return 全件（ランダム）
     */
    public List<Questions> RandomAll() {
		return repository.RandomAll();
	}

    /**
     * 指定IDのレコードを取得
     * @return 指定IDのレコード
     */
	public Questions findOne(int id) {
		return repository.findOne(id);
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
     * idが一致したレコードを削除する
     */
	public void delete(Questions questions) {
		repository.delete(questions);

	}

}
