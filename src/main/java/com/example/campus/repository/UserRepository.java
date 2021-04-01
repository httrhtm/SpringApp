package com.example.campus.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.Users;

@Mapper
public interface UserRepository {

	public Users identifyUser(String id);

	public Users findByUsersId(int id);

}
