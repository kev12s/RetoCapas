/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Clase FactoryModelBD que actúa como fábrica para crear instancias
 * de implementaciones de acceso a datos (DAO) para usuarios.
 * 
 * @author 2dami
 */
public class FactoryModelBD {

    /**
     * Abre la implementación concreta del UserDAO.
     * <p>
     * Este método crea una instancia de {@link ImplementsBD} y la devuelve
     * como un objeto de tipo {@link UserDAO}.
     * </p>
     * 
     * @return una instancia de {@link UserDAO} correspondiente a {@link ImplementsBD}
     */
    public UserDAO abrirImplementacion(){
        UserDAO dao = new ImplementsBD();
         
        return dao;
    }
}
