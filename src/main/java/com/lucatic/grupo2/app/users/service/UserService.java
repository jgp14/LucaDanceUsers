package com.lucatic.grupo2.app.users.service;

import java.util.List;

import com.lucatic.grupo2.app.users.exceptions.UserExistException;
import com.lucatic.grupo2.app.users.model.User;
import com.lucatic.grupo2.app.users.model.dto.UserRequest;
import com.lucatic.grupo2.app.users.exceptions.EmptyListException;

/**
 * Interfaz de servicio
 * 
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 18-03-2024
 */
public interface UserService {

	List<User> findAll() throws EmptyListException;

	User findById(Long id);

	User update(User event);

    /**
     * Elimina un registro de la base de datos con un objeto que tiene el id de parametro
     * @param id parametro de un registro a borrar
     */
    void deleteById(Long id);
	
	User save(UserRequest event) throws UserExistException;
}
