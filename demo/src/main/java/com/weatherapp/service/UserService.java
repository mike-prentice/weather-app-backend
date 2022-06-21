package com.weatherapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapp.models.User;
import com.weatherapp.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
        
    public User update(User user) {
        return userRepository.save(user);
    }

    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    public boolean match(String user, String password) {
        User data = userRepository.findByUserName(user);
        if (data != null) {
            String password1 = data.getPassword();
            return password.equals(password1);
        } else {
            return false;
        }
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
        
    }
    }

