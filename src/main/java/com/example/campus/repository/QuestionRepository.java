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

	void create(Questions question);

}
