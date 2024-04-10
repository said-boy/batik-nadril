/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ukuran;

/**
 *
 * @author user_
 */
public class UkuranDao {
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    
    private final String queryInsert = "INSERT INTO Ukuran (ukuran) VALUES (?)";
    private final String queryDelete = "DELETE FROM Ukuran WHERE ukuran=?";
    private final String querySelectAll = "SELECT * FROM Ukuran";
    private final String querySelectById = "SELECT * from Ukuran WHERE ukuran=?";
    private final String querySelectAllName = "SELECT ukuran from ukuran";
    private final String querySelectByName = "SELECT * from Ukuran WHERE nama_pelanggan=?";

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;

        simpanStatement = connection.prepareStatement(queryInsert);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getAllNameStatement = connection.prepareStatement(querySelectAllName);
        getByNameStatement = connection.prepareStatement(querySelectByName);
    }

    public Ukuran simpan(Ukuran p) throws SQLException {
        simpanStatement.setString(1, p.getUkuran());
        simpanStatement.executeUpdate();
        return p;
    }

    public Ukuran hapus(Ukuran p) throws SQLException {
        hapusStatement.setString(1, p.getUkuran());
        hapusStatement.executeUpdate();
        return p;
    }

    public Object[] getAllName() throws SQLException{
        Object[] name = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<>();
        ResultSet rs = getAllNameStatement.executeQuery();
        while(rs.next()){
            newObj.add(rs.getString("ukuran"));
        }
        return newObj.toArray();
    }

    public List<Ukuran> getAll() throws SQLException{
        ArrayList<Ukuran> newObj = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();
        while(rs.next()){
            Ukuran ukuran = new Ukuran();
            ukuran.setUkuran(rs.getString("ukuran"));
            newObj.add(ukuran);
        }
        return newObj;
    }

    public Ukuran getById(String id) throws SQLException {
        Ukuran s = new Ukuran();
        
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            s.setUkuran(rs.getString("ukuran"));
        }

        return s;
    }
    

}
