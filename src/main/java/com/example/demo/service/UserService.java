package com.example.demo.service;

import com.example.demo.model.dto.request.UserUpdate;
import com.example.demo.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User getUserByFullname(String fullname);

    User InsertUser(User user);

    User UpdateUser(UserUpdate userUpdate, Integer id);

    void DeleteUser(Integer id);

}
