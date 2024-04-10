/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

/**
 *
 * @author user_
 */
public class AdminDao {

    private Connection connection;
    private PreparedStatement loginStatement, getByKodeStatement;
    
    private final String queryLogin = "SELECT * FROM admin WHERE username=? AND password=?";
    private final String getByKodeQuery = "SELECT * FROM admin WHERE kode_user=?";
    
    public void setConnection(Connection connection) throws SQLException{
        this.connection = connection;
        loginStatement = connection.prepareStatement(queryLogin);
        getByKodeStatement = connection.prepareStatement(getByKodeQuery);
    }

    public Admin login(Admin admin) throws SQLException{
        loginStatement.setString(1, admin.getUsername());
        loginStatement.setString(2, admin.getPassword());
        ResultSet result = loginStatement.executeQuery();
        if(result.next()){
            Admin login = new Admin();
            login.setId_admin(result.getString("kode_user"));
            login.setUsername(result.getString("username"));
            login.setPassword(result.getString("password"));
            return login;
        }
        return null;
    }

    public Admin getByKode(String kode) throws SQLException{
        getByKodeStatement.setString(1, kode);
        ResultSet result = getByKodeStatement.executeQuery();
        if(result.next()){
            Admin login = new Admin();
            login.setId_admin(result.getString("kode_user"));
            login.setUsername(result.getString("username"));
            login.setPassword(result.getString("password"));
            return login;
        }
        return null;
    }



}
