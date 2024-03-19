package com.lucatic.grupo2.app.users.service;

import java.util.List;

import com.lucatic.grupo2.app.users.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucatic.grupo2.app.users.repositories.UserRepository;
import com.lucatic.grupo2.app.users.models.User;
import com.lucatic.grupo2.app.users.models.dto.UserRequest;
import com.lucatic.grupo2.app.users.exceptions.UserExistException;
import com.lucatic.grupo2.app.users.models.adapter.UserAdapter;
import com.lucatic.grupo2.app.users.exceptions.EmptyListException;

/**
 * Clase que implementa el servicio de Usuarios
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 18-03-2024
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * Auto instancia el objeto de repositorio para eventos
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Auto instancia el objeto adaptador, realiza el trato de DTOs
	 */
	@Autowired
	private UserAdapter userAdapter;

	/**
	 * Lista todos los usuarios almacenados
	 * 
	 * @return devuelve una lista de objetos User
	 * @throws EmptyListException gestiona este tipo de excepcion
	 */
	@Override
	public List<User> findAll() throws EmptyListException {
		List<User> users = userRepository.findAll();
		if (users.isEmpty())
			throw new EmptyListException("Lista de usuarios vacía");
		else
			return users;
	}

	/**
	 * Devuelve un objeto tipo User filtrado por un id concreto
	 * 
	 * @param id tiene el id de un objeto User
	 * @return devuelve un objeto tipo User
	 */
	@Override
	public User findById(Long id) {
		return null;
	}

	/**
	 * Actualiza un usuario concreto
	 * 
	 * @param event recibe un objeto User preparado para actualizar
	 * @return devuelve un USer actualizado
	 */
	@Override
	public User update(User user) {
		return null;
	}

	/**
	 * Elimina un objeto con un id determinado
	 * 
	 * @param id recibe un id de un objeto a borrar
	 */
	@Override
	public void deleteById(Long id) {

	}

	/**
	 * Metodo que guarda un usuario concreto
	 * 
	 * @param userRequest se encarga de coger datos tratables a guardar
	 * @return devuelve un objeto tipo User tratado
	 */

	@Override
	public User save(UserRequest userRequest) throws UserException {

		if (userRequest == null)
			throw new UserException("Intentando dar de alta un usuario nulo");

		if (userRepository.findUserByEmail(userRequest.getEmail()) != null) {
			throw new UserExistException("No se puede dar de alta porque ya existe el usuario");
		}

		User user = userAdapter.fromUserRequest(userRequest);
		user = userRepository.save(user);
		return user;
	}
	public boolean userFindById(long id) {
		if(userRepository.findById(id).isPresent()) {
			return true;
		}
		return false;
	}

}
