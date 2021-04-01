package com.example.campus.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.Histories;

@Mapper // MybatisでxmlのSQLが対応づけられる
public interface HistoryRepository {

	/**
	 * レコードの新規作成
	 */
	public void create(Histories histories);

	public List<Histories> findAll();

	public List<Histories> findByUsersId(int user_id);

}
