/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import factory.LoginWindowFactory;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author 2dami
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Usar la fábrica específica para login
        LoginWindowFactory loginFactory = new LoginWindowFactory();
        
        
        // Crear la ventana login usando la fábrica específica
        Stage loginStage = loginFactory.createLoginWindow();
        loginStage.show();
    }
   
    
    public static void main(String[] args) {
        launch(args);
    }

}
