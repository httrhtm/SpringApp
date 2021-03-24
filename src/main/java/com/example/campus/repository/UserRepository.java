package com.example.campus.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.User;

@Mapper
public interface UserRepository {

	public User identifyUser(String id);

}
