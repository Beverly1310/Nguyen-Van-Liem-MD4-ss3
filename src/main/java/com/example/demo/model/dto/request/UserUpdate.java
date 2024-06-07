package com.example.demo.model.dto.request;

import com.example.demo.validation.PasswordMatching;
import com.example.demo.validation.UserNameExist;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@PasswordMatching(password = "password",confirmPassword = "confirmPassword",message = "Password does not match")
public class UserUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Username is blank")
    private String username;
    @NotBlank(message = "Password is blank")
    private String password;
    @NotBlank(message = "Email is blank")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Email is not valid")
    private String email;
    @NotBlank(message = "Phone is blank")
    @Pattern(regexp = "^((\\+84)|0)(3|5|7|8|9|2[0-9])[0-9]{8}$",message = "Phone is not valid")
    private String phone;
    @NotBlank(message = "Address is blank")
    private String address;
    @NotBlank(message = "Full name is blank")
    private String fullName;
    private Boolean status=true;
    @NotBlank(message = "Confirm password is blank")
    private String confirmPassword;

}