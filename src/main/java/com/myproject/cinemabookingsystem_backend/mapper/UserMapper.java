package com.myproject.cinemabookingsystem_backend.mapper;


import com.myproject.cinemabookingsystem_backend.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(Integer id);//尋找ID
    void insertUser(User user);//新增使用者
    void updateUser(User user);//更新使用者
    int deleteById(Integer id);//刪除使用者
    User LoginByAccount(User user);
}