/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import javafx.stage.Stage;
import model.User;

/**
 *
 * @author kevin
 */
public abstract class FactoryProducer {
    
    public abstract Stage createLoginWindow();
    public abstract Stage createMainWindow(User user);
}
