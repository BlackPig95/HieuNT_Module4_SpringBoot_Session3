package com.ra.module4_springboot_session3.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Username is blank")
    private String username;
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Password is blank")
    private String password;
    @Column(nullable = false, length = 100)
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
