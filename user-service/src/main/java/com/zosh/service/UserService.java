package com.zosh.service;

import com.zosh.entity.User;
import com.zosh.exception.UserException;

import java.util.List;

public interface UserService {
     User getUserById(Long id) throws UserException;
     List<User> getUsers();
     User createUser(User user);
     User updateUser(User user,Long id) throws UserException;
     void deleteUser(Long id) throws UserException;
}
