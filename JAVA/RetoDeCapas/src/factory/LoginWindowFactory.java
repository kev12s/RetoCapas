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
 *
 * @author kevin
 */
public class LoginWindowFactory extends FactoryProducer {
  
    
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

    @Override
    public Stage createMainWindow(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //No se usa este metodo en esta factoria
    }
    
}
