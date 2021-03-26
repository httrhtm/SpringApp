package com.example.campus.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.campus.entity.Answers;

@Repository
@Mapper
public interface AnswerRepository {

	public List<Answers> findAll();

	public void create(String answer);

}
