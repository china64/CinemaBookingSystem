package com.myproject.cinemabookingsystem_backend.service;

import com.myproject.cinemabookingsystem_backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> findAll();

    public User findById(Integer id);

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteById(Integer id);

    public User LoginByAccount(User user);
}
