/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import factory.FactoryProducer;
import factory.IWindowFactory;
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
 *
 * @author 2dami
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label messageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;
  
    LoginController cont = new LoginController();

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        User user = new User(username, password);

        User correctUser = cont.checkUser(user);

        if (correctUser != null) {
            // Obtener la fábrica de ventanas main
            IWindowFactory mainFactory = FactoryProducer.getFactory(
            FactoryProducer.FactoryType.MAIN
            );

            
            // Crear la ventana principal usando la fábrica específica
            Stage mainStage = mainFactory.createMainWindow(correctUser);

            // Cerrar ventana actual y mostrar la nueva
            Stage currentStage = (Stage) usernameTextField.getScene().getWindow();
            currentStage.close();
            mainStage.show();
        }else{
            messageLabel.setText("Usuario incorrecto");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
