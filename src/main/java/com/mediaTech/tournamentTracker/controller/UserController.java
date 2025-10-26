package com.mediaTech.tournamentTracker.controller;

import com.mediaTech.tournamentTracker.Entity.Users;
import com.mediaTech.tournamentTracker.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userservice;

    @GetMapping
    public ResponseEntity<List<Users>> getUsers(){
        return new ResponseEntity<>(userservice.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody Users user){

        return new ResponseEntity<>(userservice.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Users>> getById(@PathVariable ObjectId id){
        return new ResponseEntity<>(userservice.getByID(id), HttpStatus.OK);
    }

//    @GetMapping("/user")
//    public ResponseEntity<Optional<Users>> getIDFromCredentials(@RequestParam String username, @RequestParam String password){
//        com.mediaTech.tournamentTracker.Entity.Users user = userservice.getIDFromUsername(username, password);
//
//        if (user!= null){
//            return new ResponseEntity<>(userservice.getByID(user.getId()),HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED) ;
//        }

    @PostMapping("/login")
    public ResponseEntity<Users> loginUser(@RequestBody Users loginUser) {
        Users user = userservice.getIDFromUsername(loginUser.getUserName(), loginUser.getPassword());
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }






}
