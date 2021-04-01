package com.example.campus.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.campus.entity.Users;
import com.example.campus.repository.UserRepository;

@Service //SpringのDIコンテナの管理対象であることを示す
public class UserDetailsImplService implements UserDetailsService {

	@Autowired //依存性注入の対象であることを示す、UserRepositoryのインスタンス化をDIコンテナ
	private UserRepository repository;
	@Autowired
	HttpSession session;


	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Users user = repository.identifyUser(id);
		if(user == null) {
			throw new UsernameNotFoundException(id + "is not found");
		} else {
			session.setAttribute("user_id", id);
			return user;
		}

	}

}
