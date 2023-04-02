package com.example.mywebapp.services;

import com.example.mywebapp.Entities.users;
import org.springframework.stereotype.Service;

import com.example.mywebapp.dataAcces.userDao;

import java.util.List;
import java.util.Optional;

@Service

public class userService {

    userDao userDao;

    public userService(userDao userRepository) {
        this.userDao = userRepository;
    }


    public List<users> getAllUsers() {
        return userDao.findAll();
    }

    public users saveOneUser(users newUser) {
        return userDao.save(newUser);
    }

    public users getOneUser(int user_id) {
        return userDao.findById(user_id).orElse(null);
    }

    public users updateOneUser(int user_id, users newUser) {

        Optional<users> users = userDao.findById(user_id);
        if (users.isPresent()) {
            users foundUser = users.get();
            foundUser.setName(newUser.getName());
            foundUser.setPassword(newUser.getPassword());

            userDao.save(foundUser);
            return foundUser;
        } else {
            return null;
        }

    }

    public void deleteById(int user_id) {
        userDao.deleteById(user_id);
    }
}
