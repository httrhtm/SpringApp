package com.example.campus.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.Questions;


//データベースへアクセスするためのインターフェース
@Mapper // MybatisでxmlのSQLが対応づけられる
public interface QuestionRepository {

	/**
	 * 全件取得
	 * @param 検索結果
	 */
	List<Questions> findAll();

	/**
	 * レコードの新規作成
	 */
	void create(Questions question);

	/**
	 * レコードの更新
	 */
	void update(Questions questions);

	/**
	 * 1件取得
	 */
	Questions findOne(int id);

	void delete(Questions questions);

}
