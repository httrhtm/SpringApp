package com.example.campus.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.Answers;

@Mapper
public interface AnswerRepository {

	public List<Answers> findAll();

}
