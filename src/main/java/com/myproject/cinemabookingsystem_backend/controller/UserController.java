package com.myproject.cinemabookingsystem_backend.controller;

import com.myproject.cinemabookingsystem_backend.model.User;
import com.myproject.cinemabookingsystem_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/ViewAll")
    public List<User> findAll() {

        return userService.findAll();
    }

    @GetMapping("/View/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/add")
    public void insertUser(@RequestBody User user) {
        userService.insertUser(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
