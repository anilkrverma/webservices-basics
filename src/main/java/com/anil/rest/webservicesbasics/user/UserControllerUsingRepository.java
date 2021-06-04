package com.anil.rest.webservicesbasics.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserControllerUsingRepository {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @GetMapping (value = "/jpa/users")
    public List<User> getAllUsers(){
        return userRepositoryService.findAll();
    }

    @GetMapping (value = "/jpa/users/{id}")
    public User getUser(@PathVariable Integer id){
        Optional<User> user = userRepositoryService.findById(id);
        if (!user.isPresent()){
            throw new UserNotFoundException("User with id - " + id + " is not found.");
        }

        return user.get();
    }

    @PostMapping(value = "/jpa/users")
    public ResponseEntity createUser(@RequestBody User user){
        User user1 = userRepositoryService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping (value = "/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userRepositoryService.deleteById(id);
    }

}
