package com.example.demoProject.controller;

import com.example.demoProject.entity.User;
import com.example.demoProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/save-user")
    public User saveUser(@RequestBody User users) {
        return userService.saveUser(users);
    }


    @PutMapping("/{id}")
        public Optional<User> updateUserById(@PathVariable int id, @RequestBody User updateuser) {
        return userService.updateUserById(id, updateuser);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}

