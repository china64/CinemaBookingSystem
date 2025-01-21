package com.myproject.cinemabookingsystem_backend.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String phone;
    private String account;
    private String email;
    private String password;



    private String name;
    private int role;

    public User(String account, String password) {//登入驗證用
        super();
        this.account = account;
        this.password = password;
    }

    public User(String phone, String account, String email, String password) {
        super();
        this.phone = phone;
        this.account = account;
        this.email = email;
        this.password = password;
    }

    public User(Integer id, String phone, String account, String email, String password,String name) {
        super();
        this.id = id;
        this.phone = phone;
        this.account = account;
        this.email = email;
        this.password = password;
        this.name=name;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", phone=" + phone + ", account=" + account + ", email=" + email + ", password="
                + password + ", role=" + role + "]";
    }

}
