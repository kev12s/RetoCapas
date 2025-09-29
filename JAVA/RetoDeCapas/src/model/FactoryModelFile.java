/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Clase FactoryModelFile que actúa como fábrica para crear instancias
 * de implementaciones de acceso a datos (DAO) para usuarios mediante archivos.
 * 
 * @author kevin
 */
public class FactoryModelFile {

    /**
     * Abre la implementación concreta del UserDAO basada en archivos.
     * <p>
     * Este método crea una instancia de {@link ImplementsFile} y la devuelve
     * como un objeto de tipo {@link UserDAO}.
     * </p>
     * 
     * @return una instancia de {@link UserDAO} correspondiente a {@link ImplementsFile}
     */
    public UserDAO abrirImplementacion(){
        UserDAO dao = new ImplementsFile();         
        return dao;
    }
}
