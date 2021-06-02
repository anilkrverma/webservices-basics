package com.anil.rest.webservicesbasics.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping (value = "/users")
    public List<User> getAllUsers(){
        return userDaoService.findAllUsers();
    }

    @GetMapping (value = "/users/{id}")
    public User getUser(@PathVariable Integer id){
        return userDaoService.findUser(id);
    }

    @PostMapping(value = "/users")
    public User getUser(@RequestBody User user){
        return userDaoService.createUser(user);
    }

}
