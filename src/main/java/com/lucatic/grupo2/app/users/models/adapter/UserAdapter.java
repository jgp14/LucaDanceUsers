package com.lucatic.grupo2.app.users.models.adapter;

import com.lucatic.grupo2.app.users.models.User;
import com.lucatic.grupo2.app.users.models.dto.UserRequest;
import com.lucatic.grupo2.app.users.models.dto.UserResponse;
import com.lucatic.grupo2.app.users.models.dto.UserResponseWithError;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class UserAdapter {

    public UserResponseWithError toUserResponseWithError(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setLastName(user.getLastName());
        userResponse.setName(user.getName());
        userResponse.setRegisterDate(user.getRegisterDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        userResponse.setPassword(user.getPassword());

        return new UserResponseWithError(null, userResponse, false);
    }


    public User fromUserRequest(UserRequest eventRequest) {

        User user = new User();

        user.setEmail(eventRequest.getEmail());
        user.setLastName(eventRequest.getLastName());
        user.setName(eventRequest.getName());
        user.setPassword(eventRequest.getPassword());
        user.setRegisterDate(LocalDateTime.parse(eventRequest.getRegisterDate()));

        return user;
    }
}
