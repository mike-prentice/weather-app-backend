package com.weatherapp.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapp.models.User;
import com.weatherapp.service.UserService;



@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    UserService userService;

   

    @PostMapping("/users")
    public ResponseEntity<User> save(@RequestBody User user) throws URISyntaxException {
        User result = userService.save(user);
        return ResponseEntity
                .created(new URI("/user/" + result.getUserName()))
                .body(result);
    }

    @PutMapping("/users")
    public ResponseEntity<User> update(@RequestBody User user) {
        User result = userService.save(user);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/users")
    void delete(@RequestBody User user) {
        String userName = user.getUserName();
        if (!userName.isEmpty()) {
            userService.delete(user);
        }
    }
    
    @GetMapping("/users/userAuth")
    public ResponseEntity<Boolean> match(
        @RequestParam(value = "user") String username,
            @RequestParam(value = "password") String password) {
        return new ResponseEntity<>(userService.match(username, password), HttpStatus.OK);
    }
        
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
