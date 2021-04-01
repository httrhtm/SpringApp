package com.example.campus.service;

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
}
