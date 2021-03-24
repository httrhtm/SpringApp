package com.example.campus.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.Answer;

@Mapper
public interface AnswerRepository {

	public List<Answer> findAll();

}
