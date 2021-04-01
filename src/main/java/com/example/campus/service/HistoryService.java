package com.example.campus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campus.entity.Histories;
import com.example.campus.repository.HistoryRepository;

@Service //SpringのDIコンテナの管理対象であることを示す
public class HistoryService {

	/**
     * テーブルへアクセスする
     */
	@Autowired
	private HistoryRepository repository;

	 /**
     * レコードを新規作成する
     */
	public void create(Histories histories) {
		repository.create(histories);
	}

	 /**
     * 指定IDのレコードを取得
     */
	public List<Histories> findByUsersId(int user_id) {
		return repository.findByUsersId(user_id);
	}

}
