/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import view.LoginView;
import main.App;
import model.Admin;
import view.MenuView;

/**
 *
 * @author user_
 */
public class LoginController {
    
    private final LoginView loginView;
    public static MenuView menuView;

    public static String id_admin = null;
    

    public LoginController(LoginView loginView){
        this.loginView = loginView;
    }

    public void login(){
        Admin admin = new Admin();
        admin.setUsername(loginView.getTextUsername().getText());
        admin.setPassword(loginView.getTextPassword().getText());

        Admin hasil = App.masterService.loginAdmin(admin);
        if (hasil != null){
            loginView.setVisible(false);
            id_admin = hasil.getId_admin();
            menuView = new MenuView();
            App.menuView = menuView;
            menuView.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(loginView, "Username salah!");
        }
    }

}
