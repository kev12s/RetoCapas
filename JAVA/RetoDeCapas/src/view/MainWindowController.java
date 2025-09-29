/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.User;

/**
 * Controlador para la ventana principal del sistema.
 * <p>
 * Implementa {@link Initializable} para inicializar los componentes de la interfaz.
 * Este controlador se encarga de mostrar los datos del usuario que ha iniciado sesión,
 * incluyendo nombre, DNI, correo electrónico y edad.
 * </p>
 * 
 * <p>
 * El usuario logueado se almacena en la variable {@link #logedUser} y se muestra
 * en los {@link Label} correspondientes de la interfaz.
 * </p>
 * 
 * @author 2dami
 */
public class MainWindowController implements Initializable {
    
    /** Label para mostrar el nombre del usuario */
    @FXML
    private Label lblUserName;
    
    /** Label para mostrar el DNI del usuario */
    @FXML
    private Label lblDNI;
    
    /** Label para mostrar el correo electrónico del usuario */
    @FXML
    private Label lblEmail;
    
    /** Label para mostrar la edad del usuario */
    @FXML
    private Label lblAge;
    
    /** Usuario actualmente logueado */
    private User logedUser;
    
    /**
     * Maneja la acción de un botón para mostrar los datos del usuario.
     * <p>
     * Si existe un usuario logueado, se llaman los métodos internos para
     * mostrar sus datos en la interfaz. Si no, se imprime un mensaje en consola.
     * </p>
     * 
     * @param event Evento de acción generado al pulsar el botón
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (logedUser != null) {
            // Usar el método setUser con el usuario almacenado
            showUserData();
        } else {
            System.out.println("No hay usuario para mostrar");
        }
    }
    
    /**
     * Inicializa el controlador después de que su raíz haya sido completamente procesada.
     * 
     * @param url URL usado para resolver rutas relativas de recursos
     * @param rb ResourceBundle para localizar la interfaz
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Establece el usuario que se va a mostrar en la ventana principal.
     * 
     * @param user Usuario que ha iniciado sesión
     */
    public void setUser(User user) {       
        this.logedUser = user;      
    }
    
    /**
     * Muestra los datos del usuario logueado en los Labels correspondientes.
     */
    private void showUserData() {       
        lblUserName.setText(logedUser.getNombre());
        lblDNI.setText(logedUser.getDni());
        lblEmail.setText(logedUser.getEmail());
        lblAge.setText(String.valueOf(logedUser.getEdad()));
    }
    
    /**
     * Limpia los Labels de la ventana principal, dejándolos vacíos.
     */
    private void clearUserData() {
        lblUserName.setText("");
        lblDNI.setText("");
        lblEmail.setText("");
        lblAge.setText("");
    }
}
