package com.example.campus.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.Histories;

@Mapper // MybatisでxmlのSQLが対応づけられる
public interface HistoryRepository {

	/**
	 * レコードの新規作成
	 */
	public void create(Histories histories);

}
