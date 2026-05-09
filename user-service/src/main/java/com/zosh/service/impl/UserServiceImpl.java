package com.zosh.service.impl;

import com.zosh.entity.User;
import com.zosh.exception.UserException;
import com.zosh.payload.response.UserResponse;
import com.zosh.repository.UserRepository;
import com.zosh.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        throw new UserException("user with id " + id + " not found");
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    @Override
    public User updateUser(User user, Long id) throws UserException {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isEmpty()){
            throw new UserException("user with id " + id + " not found");
        }
        opt.get().setFullName(user.getFullName());
        opt.get().setRole(user.getRole());
        opt.get().setPhone(user.getPhone());
        opt.get().setEmail(user.getEmail());
        opt.get().setUpdatedAt(LocalDateTime.now());
        return userRepository.save(opt.get());
    }

    @Override
    public void deleteUser(Long id) throws UserException {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isEmpty()){
            throw new UserException("user with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }
}
