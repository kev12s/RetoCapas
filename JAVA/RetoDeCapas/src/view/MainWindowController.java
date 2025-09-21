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
 *
 * @author 2dami
 */
public class MainWindowController implements Initializable {
    
    @FXML
    private Label lblUserName;
    
    @FXML
    private Label lblDNI;
    
    @FXML
    private Label lblEmail;
    
    @FXML
    private Label lblAge;
    
    private User logedUser;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       
       if (logedUser != null) {
            // Usar el método setUser con el usuario almacenado
            showUserData();
        } else {
            System.out.println("No hay usuario para mostrar");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void setUser(User user) {       
        this.logedUser = user;      
    }
    
    private void showUserData() {       
        lblUserName.setText(logedUser.getNombre());
        lblDNI.setText(logedUser.getDni());
        lblEmail.setText(logedUser.getEmail());
        lblAge.setText(String.valueOf(logedUser.getEdad()));
    }
    
    // Método para limpiar los Labels inicialmente
    private void clearUserData() {
        lblUserName.setText("");
        lblDNI.setText("");
        lblEmail.setText("");
        lblAge.setText("");
    }
    
}
