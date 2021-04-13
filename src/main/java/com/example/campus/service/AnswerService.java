package com.example.campus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campus.entity.Answers;
import com.example.campus.repository.AnswerRepository;



@Service //SpringのDIコンテナの管理対象であることを示す
public class AnswerService {

	/**
     * テーブルへアクセスする
     */
	@Autowired //依存性注入の対象であることを示す、QuestionRepositoryのインスタンス化をDIコンテナが勝手にやってくれる
	private AnswerRepository repository;

	/**
     * テーブルの全件を取得する
     * @return テーブル全件
     */
	public List<Answers> findAll() {
		return repository.findAll();
	}

	 /**
     * レコードを新規作成する
     */
	public void create(Answers answers) {
		repository.create(answers);
	}

	/**
     * レコードをを更新
     */
	public void update(Answers answers) {
		repository.update(answers);
	}

	/**
     * レコードをを削除
     */
	public void delete(Answers answers) {
		repository.delete(answers);

	}

	public void insert(Answers answers) {
		repository.insert(answers);

	}

	public void deleteById(Answers answers) {
		repository.deleteById(answers);
	}

}
