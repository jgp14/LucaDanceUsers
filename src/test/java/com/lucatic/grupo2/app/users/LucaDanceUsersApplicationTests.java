package com.lucatic.grupo2.app.users;

import com.lucatic.grupo2.app.users.exceptions.EmptyListException;
import com.lucatic.grupo2.app.users.exceptions.UserException;
import com.lucatic.grupo2.app.users.exceptions.UserExistException;
import com.lucatic.grupo2.app.users.models.dto.UserRequest;
import com.lucatic.grupo2.app.users.repositories.UserRepository;
import com.lucatic.grupo2.app.users.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LucaDanceUsersApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		Assertions.assertThat(true).isTrue();
	}

	@Test
	public void getAllIfValues() throws EmptyListException {
        assertFalse(userService.findAll().isEmpty());
	}

	@Test
	public void saveIfNull() {
		assertThrows(UserException.class, () -> userService.save(null));
	}

	@Test
	public void saveIfExist() {
		UserRequest userRequest = new UserRequest("AAA", "aaa", "marina@gmail.com", "aaaa", "01-01-2024 18:00");
		assertThrows(UserExistException.class, () -> userService.save(userRequest));
	}

	@Test
	public void saveIfNoExist() {

		UserRequest userRequest = new UserRequest("AAA", "aaaa", String.valueOf(new Random().nextInt(1000)), "aaaa", "01-01-2024 18:00");
		assertDoesNotThrow(() -> userService.save(userRequest));
	}
}
