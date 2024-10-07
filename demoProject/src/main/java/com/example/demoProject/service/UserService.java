package com.example.demoProject.service;

import com.example.demoProject.entity.User;
import com.example.demoProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> updateUserById(int id, User updateUser){
        return userRepository.findById(id).map(user->{
        updateUser.setName(updateUser.getName());
        updateUser.setPassword(updateUser.getPassword());
        updateUser.setEmail(updateUser.getEmail());
       return userRepository.save(updateUser);});

    }
    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }
}
