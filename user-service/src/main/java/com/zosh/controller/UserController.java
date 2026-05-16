package com.zosh.controller;

import com.zosh.entity.User;
import com.zosh.exception.UserException;
import com.zosh.repository.UserRepository;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUser(){
        List<User> list = userService.getUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserException {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) throws UserException{
        User updatedUser = userService.updateUser(user,id);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/api/user/")
    public ResponseEntity<String> delete(@PathVariable Long id) throws UserException{
        return new ResponseEntity<>("user deleted",HttpStatus.ACCEPTED);
    }
}
