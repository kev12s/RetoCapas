/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

/**
 *
 * @author kevin
 */
public class FactoryProducer {
    
    public enum FactoryType {
        LOGIN, MAIN // Tipos de fábricas disponibles
    }
    
    public static IWindowFactory getFactory(FactoryType type) {
        switch (type) {
            case LOGIN:
                return new LoginWindowFactory();
            case MAIN:
                return new MainWindowFactory();
            default:
                throw new IllegalArgumentException("Factory type not supported: " + type);
        }
    }
}
