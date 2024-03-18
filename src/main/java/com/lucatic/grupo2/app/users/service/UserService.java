package com.lucatic.grupo2.app.users.service;

import java.util.List;

import com.lucatic.grupo2.app.users.exceptions.UserException;
import com.lucatic.grupo2.app.users.exceptions.UserExistException;
import com.lucatic.grupo2.app.users.models.User;
import com.lucatic.grupo2.app.users.models.dto.UserRequest;
import com.lucatic.grupo2.app.users.exceptions.EmptyListException;

/**
 * Interfaz de servicio
 * 
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 18-03-2024
 */
public interface UserService {

	/**
	 * Lista todos los usuarios almacenados
	 * @return devuelve una lista de objetos User
	 * @throws EmptyListException gestiona este tipo de excepcion
	 */
	List<User> findAll() throws EmptyListException;

    /**
     * Selecciona un usuario segun el id de este
     * @param id parametro con id de un User
     * @return devuelve un objeto tipo User
     */
	User findById(Long id);

    /**
     * Actualiza un usuario y lo devuelve
     * @param usuario recibe un evento de parametro a actualizar
     * @return comprueba que el usuario este actualizado
     */
	User update(User event);

    /**
     * Elimina un registro de la base de datos con un objeto que tiene el id de parametro
     * @param id parametro de un registro a borrar
     */
    void deleteById(Long id);
	
    /**
     * Guarda un objeto de tipo UserRequest
     * @param event recupera un objeto de tipo USerRequest
     * @return devuelve un objeto tipo User
     * @throws UserExistException Gestiona este tipo de excepcion
     */
	User save(UserRequest event) throws UserException;
}
