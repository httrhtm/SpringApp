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
	 * 全件取得（ランダム）
	 * @param 検索結果
	 */
	List<Questions> RandomAll();

	/**
	 * 指定IDのレコードを取得
	 */
	Questions findOne(int id);

	/**
	 * レコードの新規作成
	 */
	void create(Questions question);

	/**
	 * レコードの更新
	 */
	void update(Questions questions);

	/**
	 * レコードの削除
	 */
	void delete(Questions questions);

}
