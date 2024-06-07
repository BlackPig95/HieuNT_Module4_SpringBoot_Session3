package com.ra.module4_springboot_session3.model.dto.request;

import com.ra.module4_springboot_session3.customvalidator.ConfirmPasswordAnnotation;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ConfirmPasswordAnnotation(password = "password", passwordMatch = "confirmPassword")
public class UserRequest
{
    @NotBlank(message = "Username is blank")
    private String username;
    @NotBlank(message = "Password is blank")
    private String password;
    @NotNull(message = "Confirm password is blank")
    private String confirmPassword;
    @NotBlank(message = "Full name is blank")
    private String fullname;
    @NotNull(message = "Gender is empty")
    private Boolean gender;
    @NotBlank(message = "Email is blank")
    private String email;
    @NotNull(message = "Birthday is empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
