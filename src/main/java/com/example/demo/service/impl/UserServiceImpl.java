package com.example.demo.service.impl;

import com.example.demo.model.dto.request.UserUpdate;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User not found"));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new NoSuchElementException("User not found"));
    }

    @Override
    public User getUserByFullname(String fullname) {
        return userRepository.findByFullName(fullname).orElseThrow(()-> new NoSuchElementException("User not found"));
    }

    @Override
    public User InsertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User UpdateUser(UserUpdate userUpdate, Integer id) {
        User user1 = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User not found"));
        user1=User.builder().
                id(id).
                address(userUpdate.getAddress()).
                email(userUpdate.getEmail()).
                fullName(userUpdate.getFullName()).
                password(userUpdate.getPassword()).
                phone(userUpdate.getPhone()).
                status(userUpdate.getStatus()).
                username(userUpdate.getUsername()).
                build();

        return userRepository.save(user1);
    }

    @Override
    public void DeleteUser(Integer id) {
         User user = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User not found"));
         user.setStatus(false);
         userRepository.save(user);
    }
}
