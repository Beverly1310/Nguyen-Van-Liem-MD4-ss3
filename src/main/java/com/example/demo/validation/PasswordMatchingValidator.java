package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching, Object> {
    private String password;
    private String confirmPassword;

    @Override
    public void initialize(PasswordMatching constraintAnnotation) {
        password=constraintAnnotation.password();
        confirmPassword=constraintAnnotation.confirmPassword();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object passwordObj=new BeanWrapperImpl(o).getPropertyValue(password);
        Object confirmPasswordObj=new BeanWrapperImpl(o).getPropertyValue(confirmPassword);
        return Objects.equals(passwordObj,confirmPasswordObj);
    }
}
