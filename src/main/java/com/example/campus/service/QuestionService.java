package com.example.campus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campus.entity.Question;
import com.example.campus.repository.QuestionRepository;

@Service //SpringのDIコンテナの管理対象であることを示す
public class QuestionService {
	@Autowired //依存性注入の対象であることを示す、QuestionRepositoryのインスタンス化をDIコンテナが勝手にやってくれる
	private QuestionRepository questionRepository;

	public List<Question> findAll() {
		return questionRepository.findAll();
	}
}
