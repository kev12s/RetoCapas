/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.FactoryModelBD;
import model.FactoryModelFile;
import model.User;
import model.UserDAO;

/**
 * Controlador encargado de gestionar la lógica de inicio de sesión.
 * <p>
 * Esta clase utiliza dos fábricas de modelos para obtener implementaciones de
 * acceso a datos (DAO): una basada en base de datos y otra en ficheros. 
 * Permite validar usuarios contra ambas implementaciones.
 * </p>
 * 
 * @author 2dami
 */
public class LoginController {
    /**
     * Fábrica que crea la implementación del modelo basada en base de datos.
     */
    FactoryModelBD factoryModel = new FactoryModelBD();
    
    /**
     * Objeto DAO obtenido a partir de la fábrica de base de datos.
     */
    UserDAO dao = factoryModel.abrirImplementacion();
    
    /**
     * Fábrica que crea la implementación del modelo basada en ficheros.
     */
    FactoryModelFile factoryModelFile = new FactoryModelFile();
    
    /**
     * Objeto DAO obtenido a partir de la fábrica de ficheros.
     */
    UserDAO daoFile = factoryModelFile.abrirImplementacion();
    
    /**
     * Verifica si un usuario existe en la implementación de base de datos.
     * 
     * @param user objeto {@link User} con las credenciales a validar
     * @return el usuario validado si existe en la BD, 
     *         o {@code null} si no se encuentra
     */
    public User checkUser(User user){
        return dao.checkUser(user);
    }
    
    /**
     * Verifica si un usuario existe en la implementación de ficheros.
     * 
     * @param user objeto {@link User} con las credenciales a validar
     * @return el usuario validado si existe en el fichero, 
     *         o {@code null} si no se encuentra
     */
    public User checkUserFile(User user){
        return daoFile.checkUser(user);
    }
}
