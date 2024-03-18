package com.lucatic.grupo2.app.users.models.dto;

import com.lucatic.grupo2.app.users.models.Error;
import com.lucatic.grupo2.app.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseWithError {

    private Error error;
    private UserResponse userResponse;
    private boolean isErrorBool;

}
