package com.lucatic.grupo2.app.users.repositories;

import com.lucatic.grupo2.app.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Clase repository UserRepository para las conexiones a BBDD. Extende de
 * JpaRepository.
 * 
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByEmail(String email);
}
