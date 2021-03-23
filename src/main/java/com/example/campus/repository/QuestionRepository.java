package com.example.campus.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.Question;


@Mapper
public interface QuestionRepository {

	public List<Question> findAll();

}
