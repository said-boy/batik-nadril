/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import service.DetailService;
import service.MasterService;
import service.TransaksiService;
import service.impl.DetailServiceImpl;
import service.impl.MasterServiceImpl;
import service.impl.TransaksiServiceImpl;
import view.LoginView;
import view.MenuView;

/**
 *
 * @author user_
 */
public class App {

    private static LoginView loginView;
    public static MasterService masterService;
    public static DetailService detailService;
    public static TransaksiService transaksiService;
    public static MenuView menuView;


    public static void main(String[] args) {
        // TODO code application logic here
        masterService = new MasterServiceImpl();
        detailService = new DetailServiceImpl();
        transaksiService = new TransaksiServiceImpl();

        menuView = new MenuView();

        loginView = new LoginView();
        loginView.setVisible(true);

    }
    
}
