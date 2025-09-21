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
 *
 * @author kevin
 */
public class MainWindowFactory implements IWindowFactory{

    @Override
    public Stage createLoginWindow() {
        throw new UnsupportedOperationException("Not supported yet."); //No se usa este metodo en esta factoria
    }

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
