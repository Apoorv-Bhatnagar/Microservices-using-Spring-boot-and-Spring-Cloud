package com.apoorv.user.service.UserService.controller;

import com.apoorv.user.service.UserService.entities.User;
import com.apoorv.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
      User user1=userService.saveUser(user);
           return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getsingleUser(@PathVariable String userId)
    {
        User user=userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<User>> getallUser()
    {
        List<User> users=userService.getallUser();
        return ResponseEntity.ok(users);
    }

}