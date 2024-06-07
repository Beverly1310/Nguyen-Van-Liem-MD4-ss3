package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(
        validatedBy = {PasswordMatchingValidator.class}
)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatching {
    String password();
    String confirmPassword();
    String message() default "Password does not match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        PasswordMatching[] value();
    }
}