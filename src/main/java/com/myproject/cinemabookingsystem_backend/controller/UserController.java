package com.myproject.cinemabookingsystem_backend.controller;

import com.myproject.cinemabookingsystem_backend.DTO.UserDTO;
import com.myproject.cinemabookingsystem_backend.model.User;
import com.myproject.cinemabookingsystem_backend.service.UserService;
import com.myproject.cinemabookingsystem_backend.service.impl.UserServiceImpl;
import com.myproject.cinemabookingsystem_backend.utils.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    private User user;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserServiceImpl userserviceimpl;
    @PostMapping("/add")//使用者註冊
    public void insertUser(@RequestBody @Valid UserDTO userDTO) {
        User user = new User();
        user.setPhone(userDTO.getPhone());
        user.setAccount(userDTO.getAccount());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        userserviceimpl.insertUser(user);
        System.out.println(user.getName()+"註冊了新帳號");
    }
    @PostMapping("/login")//使用者登入
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
    @GetMapping("/validate")//驗證使用者的token
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
    @GetMapping("/userinfo")//利用token查看使用者資訊
    public Map<String, Object> getUserInfo(@RequestHeader("Authorization") String authHeader) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 驗證 Token 並取得使用者 ID
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new RuntimeException("未提供有效的 Token");
            }
            String token = authHeader.substring(7); // 去掉 Bearer 前綴
            User tokenUser = jwtUtil.validateToken(token); // 驗證 Token 並取得基本使用者資訊

            // 根據 Token 中的 ID 從資料庫獲取完整使用者資料
            User userFromDb = userserviceimpl.findById(tokenUser.getId());
            System.out.println(userFromDb.getName()+"剛瀏覽了自己的用戶數據");
            if (userFromDb == null) {
                throw new RuntimeException("用戶資料不存在");
            }

            // 返回完整使用者資訊
            response.put("id", userFromDb.getId());
            response.put("account", userFromDb.getAccount());
            response.put("name", userFromDb.getName());
            response.put("email", userFromDb.getEmail());
            response.put("phone", userFromDb.getPhone()); // 假設有 phone 欄位
        } catch (RuntimeException e) {
            response.put("error", e.getMessage());
        }
        return response;
    }

}