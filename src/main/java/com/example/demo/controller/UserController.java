package com.example.demo.controller;

import com.example.demo.model.dto.request.UserUpdate;
import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@Valid @PathVariable String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }
    @GetMapping("/fullname/{fullname}")
    public ResponseEntity<User> getUsersByFullname(@Valid @PathVariable String fullname) {
        return new ResponseEntity<>(userService.getUserByFullname(fullname),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.InsertUser(user), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable Integer id, @Valid @RequestBody UserUpdate userUpdate) {
        return new ResponseEntity<>(userService.UpdateUser(userUpdate, id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@Valid @PathVariable Integer id) {
        userService.DeleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
