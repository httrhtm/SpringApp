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
	List<Answers> findAll();

	/**
	 * 新規作成
	 */
	public void create(Answers answers);

	/**
	 * 更新
	 */
	public void update(Answers answers);

	/**
	 * 削除
	 */
	void delete(Answers answers);

}
