package com.lucatic.grupo2.app.users.models.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String lastName;
    private String email;
    private String password;

    // Formato fecha dd-MM-yyyy HH:mm
    private String registerDate;
}
