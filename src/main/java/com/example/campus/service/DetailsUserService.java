package com.example.campus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.campus.entity.User;
import com.example.campus.repository.UserRepository;

@Service //SpringのDIコンテナの管理対象であることを示す
public class DetailsUserService implements UserDetailsService {

	@Autowired //依存性注入の対象であることを示す、UserRepositoryのインスタンス化をDIコンテナ
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = userRepository.identifyUser(id);
		if(user == null) {
			throw new UsernameNotFoundException(id + "is not found");
		} else {
			return user;
		}

	}

}
