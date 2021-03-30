package com.example.campus.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.Answers;

@Mapper
public interface AnswerRepository {

	/**
	 * 全件取得
	 * @param 検索結果
	 */
	public List<Answers> findAll();

	/**
	 * 新規作成
	 */
	public void create(Answers answer);

	/**
	 * 更新
	 */
	public void update(Answers answer);

}
