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
 * Clase principal de la aplicación.
 * <p>
 * Extiende de {@link Application} para inicializar la aplicación JavaFX y
 * lanzar la primera ventana de la interfaz gráfica. En este caso, se utiliza
 * la factoría {@link LoginWindowFactory} para crear y mostrar la ventana de login.
 * </p>
 * 
 * @author 2dami
 */
public class Main extends Application {
    
    /**
     * Punto de entrada de la aplicación JavaFX.
     * <p>
     * Inicializa la aplicación mostrando la ventana de login a través de la
     * factoría correspondiente.
     * </p>
     * 
     * @param primaryStage el escenario principal proporcionado por JavaFX (no utilizado directamente)
     */
    @Override
    public void start(Stage primaryStage) {
        // Usar la fábrica específica para login
        LoginWindowFactory loginFactory = new LoginWindowFactory();
        
        // Crear la ventana login usando la fábrica específica
        Stage loginStage = loginFactory.createLoginWindow();
        loginStage.show();
    }
   
    /**
     * Método main de la aplicación.
     * <p>
     * Lanza la aplicación JavaFX llamando al método {@link #launch(String...)}.
     * </p>
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }

}
