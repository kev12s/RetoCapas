/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.FactoryModelBD;
import model.FactoryModelFile;
import model.User;
import model.UserDAO;

/**
 *
 * @author 2dami
 */
public class LoginController {
    //abrir la implementacion con factoria de BD
    FactoryModelBD factoryModel = new FactoryModelBD();
    UserDAO dao = factoryModel.abrirImplementacion();
    
    //abrir la implementacion con factoria de File
    FactoryModelFile factoryModelFile = new FactoryModelFile();
    UserDAO daoFile = factoryModelFile.abrirImplementacion();
    
    public User checkUser(User user){
        return dao.checkUser(user);
    }
    
    public User checkUserFile(User user){
        return daoFile.checkUser(user);
    }
}
