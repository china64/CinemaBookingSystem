package com.myproject.cinemabookingsystem_backend.service.impl;

import java.util.List;

import com.myproject.cinemabookingsystem_backend.mapper.UserMapper;
import com.myproject.cinemabookingsystem_backend.model.User;
import com.myproject.cinemabookingsystem_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		System.out.print("瀏覽過全部使用者\n");
		return userMapper.findAll();
	}

	@Override
	public User findById(Integer id) {
        return userMapper.findById(id);
	}

	@Override
	public void insertUser(User user) {
		if (userMapper.checkAccountOnly(user.getAccount())) {
			throw new RuntimeException("帳號已被使用，請選擇其他帳號！");
		} else {
			userMapper.insertUser(user);
		}
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
		
	}

	@Override
	public void deleteById(Integer id) {
		userMapper.deleteById(id); 
		
	}

	@Override
	public User LoginByAccount(User user){
		return userMapper.LoginByAccount(user);
	}


}
