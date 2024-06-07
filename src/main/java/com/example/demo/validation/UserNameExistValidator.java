package com.example.demo.validation;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNameExistValidator implements ConstraintValidator<UserNameExist, String> {
    @Autowired
    private  UserRepository userRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (userRepository==null) return true;
        return userRepository.findByUsername(s).isEmpty();
    }
}
