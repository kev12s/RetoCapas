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
import view.MainWindowController;

/**
 * Factoría concreta que se encarga de crear la ventana principal de la aplicación.
 * <p>
 * Implementa el método de creación de la ventana principal definido en la clase
 * abstracta {@link FactoryProducer}. La creación de la ventana de login no se 
 * implementa en esta factoría, ya que no corresponde a su responsabilidad.
 * </p>
 * 
 * <p>
 * Se encarga de cargar el archivo FXML correspondiente a la vista principal,
 * inicializar su controlador e inyectar la información del {@link User}.
 * </p>
 * 
 * @author kevin
 */
public class MainWindowFactory extends FactoryProducer{

    /**
     * Este método no se implementa en esta factoría, ya que su responsabilidad
     * es únicamente la creación de la ventana principal.
     * 
     * @return nunca retorna un valor ya que lanza una excepción
     * @throws UnsupportedOperationException siempre, ya que no está soportado
     */
    @Override
    public Stage createLoginWindow() {
        throw new UnsupportedOperationException("Not supported yet."); // No se usa este metodo en esta factoria
    }

    /**
     * Crea y devuelve la ventana principal de la aplicación.
     * <p>
     * Carga la interfaz desde el archivo FXML {@code MainView.fxml}, inicializa
     * el controlador {@link MainWindowController} y le asigna el usuario
     * autenticado para personalizar la vista.
     * </p>
     * 
     * @param user objeto {@link User} que representa al usuario autenticado
     * @return un objeto {@link Stage} con la escena de la ventana principal configurada
     * @throws RuntimeException si ocurre un error al cargar el archivo FXML
     */
    @Override
    public Stage createMainWindow(User user) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
            Parent root = loader.load();
            
            MainWindowController controller = loader.getController();
            if (controller != null) {
                controller.setUser(user); 
            }
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Main Window");
            
            return stage;
            
        } catch (IOException e) {
            throw new RuntimeException("Error creating main window", e);
        }
    }
    
}
