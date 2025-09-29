/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import javafx.stage.Stage;
import model.User;

/**
 * Clase abstracta que actúa como productor de factorías de ventanas.
 * <p>
 * Define los métodos que deben implementar las subclases para crear las 
 * distintas ventanas de la aplicación (login y principal). 
 * De esta forma se sigue el patrón de diseño Factory Method.
 * </p>
 * 
 * @author kevin
 */
public abstract class FactoryProducer {
    
    /**
     * Crea la ventana de inicio de sesión.
     * 
     * @return objeto {@link Stage} correspondiente a la ventana de login
     */
    public abstract Stage createLoginWindow();
    
    /**
     * Crea la ventana principal de la aplicación.
     * 
     * @param user objeto {@link User} que representa al usuario autenticado
     * @return objeto {@link Stage} correspondiente a la ventana principal
     */
    public abstract Stage createMainWindow(User user);
}
