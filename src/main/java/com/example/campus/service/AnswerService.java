package com.example.campus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campus.entity.Answers;
import com.example.campus.repository.AnswerRepository;



@Service //SpringのDIコンテナの管理対象であることを示す
public class AnswerService {
	@Autowired //依存性注入の対象であることを示す、QuestionRepositoryのインスタンス化をDIコンテナが勝手にやってくれる
	private AnswerRepository answerRepository;

	public List<Answers> findAll() {
		return answerRepository.findAll();
	}

}
