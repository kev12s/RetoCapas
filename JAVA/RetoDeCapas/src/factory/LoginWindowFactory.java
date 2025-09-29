/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;

/**
 * Factoría concreta que se encarga de crear la ventana de inicio de sesión.
 * <p>
 * Implementa el método de creación de la ventana de login definida en la 
 * clase abstracta {@link FactoryProducer}. La creación de la ventana principal
 * no se implementa en esta factoría, ya que no corresponde a su responsabilidad.
 * </p>
 * 
 * @author kevin
 */
public class LoginWindowFactory extends FactoryProducer {
  
    /**
     * Crea y devuelve la ventana de login de la aplicación.
     * <p>
     * Carga la interfaz desde el archivo FXML correspondiente y la muestra en 
     * un {@link Stage}. En caso de error al cargar la vista, lanza una excepción
     * en tiempo de ejecución.
     * </p>
     * 
     * @return un objeto {@link Stage} con la escena del login configurada
     * @throws RuntimeException si ocurre un error al cargar el archivo FXML
     */
    @Override
    public Stage createLoginWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginView.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.setResizable(false);
            
            return stage;
            
        } catch (IOException e) {
            throw new RuntimeException("Error creating login window", e);
        }
    }

    /**
     * Este método no se implementa en esta factoría, ya que su responsabilidad
     * es únicamente la creación de la ventana de login.
     * 
     * @param user objeto {@link User} con la información del usuario autenticado
     * @return nunca retorna un valor ya que lanza una excepción
     * @throws UnsupportedOperationException siempre, ya que no está soportado
     */
    @Override
    public Stage createMainWindow(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // No se usa este metodo en esta factoria
    }
    
}
