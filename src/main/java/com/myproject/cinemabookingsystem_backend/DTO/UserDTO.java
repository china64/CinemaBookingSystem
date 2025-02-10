package com.myproject.cinemabookingsystem_backend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDTO {

    @NotBlank(message = "電話號碼不能為空")
    @Pattern(regexp = "\\d{10}", message = "電話號碼必須是10位數字")
    private String phone;

    @NotBlank(message = "帳號不能為空")
    private String account;

    @NotBlank(message = "Email 不能為空")
    @Email(message = "請輸入有效的 Email 格式")
    private String email;

    @NotBlank(message = "密碼不能為空")
    private String password;

    @NotBlank(message = "名稱不能為空")
    private String name;

    private int role; // 角色欄位，通常不需要由前端傳入，這裡僅供展示

    // Constructor
    public UserDTO(String phone, String account, String email, String password, String name) {
        this.phone = phone;
        this.account = account;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserDTO() {
        super();
    }

    // Getters and Setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
