package com.example.newcapstone.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "id should not be empty")
    private String id;
    @NotEmpty(message = "Username should not be empty")
    @Size(min = 5,message = "User name must be more than 5")
    private String userName;
   // @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email invalid")
    private String email;
    @Pattern(regexp = "^(Admin|Customer)$")
    private String role;
    @NotNull(message = "Balance should not be empty")
    @Positive(message = "Balance mus be positive number")
    private double balance;
}
