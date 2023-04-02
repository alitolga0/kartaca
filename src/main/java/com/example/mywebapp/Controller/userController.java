package com.example.mywebapp.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.mywebapp.dataAcces.userDao;
import com.example.mywebapp.Entities.users;
import  com.example.mywebapp.services.userService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class userController {

    private userService userService;

    public userController(userDao userRepository) {
        this.userService = userService;
    }

    @GetMapping
    public List<users> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public users creatUser(@RequestBody users newUser) {
        return userService.saveOneUser(newUser);
    }



    @GetMapping("/user_id")
    public users getOneUser(@PathVariable int user_id) {

        return userService.getOneUser(user_id);


    }

    @PutMapping("/user_id")
    public users updateOneUser(@PathVariable int user_id, @RequestBody users newUser) {

        return userService.updateOneUser(user_id,newUser);

    }

    @DeleteMapping("/user_id")
    public void deleteOneUser(@PathVariable int user_id ){
        userService.deleteById(user_id);


    }



}
