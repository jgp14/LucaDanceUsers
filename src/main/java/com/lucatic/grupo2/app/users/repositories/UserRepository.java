package com.lucatic.grupo2.app.users.repositories;

import com.lucatic.grupo2.app.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
