package com.myproject.cinemabookingsystem_backend.controller;

import com.myproject.cinemabookingsystem_backend.service.UserService;
import com.myproject.cinemabookingsystem_backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.myproject.cinemabookingsystem_backend.utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;

import com.myproject.cinemabookingsystem_backend.model.User;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/jwt") // 路徑基底
public class JwtController {

    private User user;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserServiceImpl userserviceimpl;

    // 模擬登入驗證並生成 JWT Token
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User logindata) {

        Map<String, String> response=new HashMap<>();
        try {
            User user = userserviceimpl.LoginByAccount(logindata);// 查詢資料庫中的使用者
            if (user!=null && user.getPassword().equals(logindata.getPassword())) {
                String token = jwtUtil.generateToken(user);
                response = new HashMap<>();
                response.put("token", token);
                System.out.print("已生成一個用戶ID為"+user.getId()+"的tokten\n");
            }else {
                throw new RuntimeException("輸入的密碼錯誤或者沒有該使用者");
            }
            // 生成 JWT

        } catch (RuntimeException e) {
            response.put("error", e.getMessage());

        }

        return response;
    }


    // 驗證 Token 是否有效
    @GetMapping("/validate")
    public Map<String, Object> validateToken(@RequestParam String token) {
        Map<String, Object> response = new HashMap<>();
        try {
            User user = jwtUtil.validateToken(token); // 驗證 Token
            response.put("valid", true);
            response.put("user", user); // 返回用戶詳細資訊
        } catch (RuntimeException e) {
            response.put("valid", false);
            response.put("error", e.getMessage());
        }
        return response;
    }


    // （可選）刷新 Token
    @PostMapping("/refresh")
    public Map<String, String> refreshToken(@RequestParam String token) {
        try {
            User user = jwtUtil.validateToken(token); // 驗證並解析原始 Token
            String newToken = jwtUtil.generateToken(user); // 生成新 Token
            Map<String, String> response = new HashMap<>();
            response.put("token", newToken);
            return response;
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid token, cannot refresh");
        }
    }
    // 新增獲取使用者資訊的 API
    @GetMapping("/userinfo")//RequestParam String token
    public Map<String, Object> getUserInfo(@RequestHeader("Authorization") String authHeader) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 驗證並解析 Token
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new RuntimeException("未提供有效的 Token");
            }
            String token = authHeader.substring(7); // 去掉 Bearer 前綴
            User user = jwtUtil.validateToken(token); // 使用 jwtUtil 驗證並獲取 User 資訊

            // 返回使用者資訊
            response.put("account", user.getAccount());
            response.put("name", user.getName());
            response.put("email", user.getEmail());
        } catch (RuntimeException e) {
            response.put("error", e.getMessage());
        }
        return response;
    }



}