/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.FactoryModel;
import model.User;
import model.UserDAO;

/**
 *
 * @author 2dami
 */
public class LoginController {
    FactoryModel factoryModel = new FactoryModel();
    UserDAO dao = factoryModel.abrirImplementacion();
    
    public User checkUser(User user){
        return dao.checkUser(user);
    }
}
