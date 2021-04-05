package com.example.campus.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.campus.entity.Users;

@Mapper
public interface UserRepository {

	public Users identifyUser(String id);

	public Users findByUsersId(int id);

	public List<Users> findAll();

	public void create(Users users);

	public void edit(Users users);

	public void delete(Users users);

}
