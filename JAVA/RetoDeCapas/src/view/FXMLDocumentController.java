/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import factory.MainWindowFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

/**
 * Controlador para la ventana de login del sistema.
 * <p>
 * Implementa {@link Initializable} para inicializar los componentes de la
 * interfaz y manejar la interacción del usuario con los elementos de la ventana
 * de login (como campos de usuario, contraseña y mensajes de error).
 * </p>
 * 
 * <p>
 * Este controlador utiliza {@link LoginController} para verificar los usuarios,
 * y {@link MainWindowFactory} para abrir la ventana principal si las credenciales
 * son correctas.
 * </p>
 * 
 * @author 2dami
 */
public class FXMLDocumentController implements Initializable {

    /** Etiqueta para mostrar mensajes al usuario */
    @FXML
    private Label messageLabel;

    /** Campo de texto para ingresar el nombre de usuario */
    @FXML
    private TextField usernameTextField;

    /** Campo de texto para ingresar la contraseña */
    @FXML
    private PasswordField passwordTextField;
  
    /** Controlador de login para verificar usuarios */
    LoginController cont = new LoginController();

    /**
     * Maneja la acción del botón de login.
     * <p>
     * Obtiene el usuario y contraseña ingresados, verifica las credenciales
     * utilizando {@link LoginController}, y en caso de ser correctas, abre
     * la ventana principal utilizando {@link MainWindowFactory}. Si las credenciales
     * son incorrectas, muestra un mensaje de error en {@link #messageLabel}.
     * </p>
     * 
     * @param event Evento de acción generado al pulsar el botón
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        User user = new User(username, password);

        User correctUser = cont.checkUser(user);

        if (correctUser != null) {
            // Obtener la fábrica de ventanas main
            MainWindowFactory mainFactory = new MainWindowFactory();

            // Crear la ventana principal usando la fábrica específica
            Stage mainStage = mainFactory.createMainWindow(correctUser);

            // Cerrar ventana actual y mostrar la nueva
            Stage currentStage = (Stage) usernameTextField.getScene().getWindow();
            currentStage.close();
            mainStage.show();
        } else {
            User correctUserFile = cont.checkUserFile(user);
            
            if(correctUserFile != null){
            
                MainWindowFactory mainFactory = new MainWindowFactory();

                // Crear la ventana principal usando la fábrica específica
                Stage mainStage = mainFactory.createMainWindow(correctUserFile);

                // Cerrar ventana actual y mostrar la nueva
                Stage currentStage = (Stage) usernameTextField.getScene().getWindow();
                currentStage.close();
                mainStage.show();
            } else {
                messageLabel.setText("Usuario incorrecto");
            }
        }
    }

    /**
     * Inicializa el controlador después de que su raíz haya sido completamente
     * procesada.
     * <p>
     * Este método se invoca automáticamente al cargar la ventana FXML.
     * </p>
     * 
     * @param url URL usado para resolver rutas relativas de recursos
     * @param rb ResourceBundle para localizar la interfaz
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
