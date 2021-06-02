package com.anil.rest.webservicesbasics.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity createUser(@RequestBody User user){
        User user1 = userDaoService.createUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
