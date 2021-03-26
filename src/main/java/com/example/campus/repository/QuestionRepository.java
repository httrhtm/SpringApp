package com.example.campus.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.campus.entity.Questions;


//データベースへアクセスするためのインターフェース
@Repository // springのDIの対象となる
@Mapper // MybatisでxmlのSQLが対応づけられる
public interface QuestionRepository {

	/**
     * 全件取得
     * @param 検索結果
     */
	List<Questions> findAll();

	/**
     * 追加
     * @param 問題テーブル(questions)の追加データ
     */
	Questions insertQuestion(Questions questions);

}
