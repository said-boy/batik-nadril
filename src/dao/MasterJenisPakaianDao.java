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
import model.MasterJenisPakaian;

/**
 *
 * @author user_
 */
public class MasterJenisPakaianDao {
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    
    private final String queryInsert = "INSERT INTO master_jenis_pakaian (id_jenis, jenis_pakaian) VALUES (?,?)";
    private final String queryUpdate = "UPDATE master_jenis_pakaian SET jenis_pakaian=? WHERE id_jenis=?";
    private final String queryDelete = "DELETE FROM master_jenis_pakaian WHERE id_jenis=?";
    private final String querySelectAll = "SELECT * FROM master_jenis_pakaian";
    private final String querySelectById = "SELECT * from master_jenis_pakaian WHERE id_jenis=?";
    private final String querySelectAllName = "SELECT jenis_pakaian from master_jenis_pakaian";
    private final String querySelectByName = "SELECT * from master_jenis_pakaian WHERE jenis_pakaian=?";

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;

        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getAllNameStatement = connection.prepareStatement(querySelectAllName);
        getByNameStatement = connection.prepareStatement(querySelectByName);
    }

    public MasterJenisPakaian simpan(MasterJenisPakaian p) throws SQLException {
        simpanStatement.setString(1, p.getIdJenis());
        simpanStatement.setString(2, p.getJenis_pakaian());
        simpanStatement.executeUpdate();
        return p;
    }

    public MasterJenisPakaian ubah(MasterJenisPakaian p) throws SQLException {
        ubahStatement.setString(1, p.getJenis_pakaian());
        ubahStatement.setString(2, p.getIdJenis());
        ubahStatement.executeUpdate();
        return p;
    }

    public MasterJenisPakaian hapus(MasterJenisPakaian p) throws SQLException {
        hapusStatement.setString(1, p.getIdJenis());
        hapusStatement.executeUpdate();
        return p;
    }

    public List<MasterJenisPakaian> getAll() throws SQLException {
        List<MasterJenisPakaian> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            MasterJenisPakaian s = new MasterJenisPakaian();
            s.setIdJenis(rs.getString("id_jenis"));
            s.setJenis_pakaian(rs.getString("jenis_pakaian"));
            list.add(s);
        }

        return list;
    }

    public MasterJenisPakaian getById(String id) throws SQLException {
        MasterJenisPakaian s = new MasterJenisPakaian();
        
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            s.setIdJenis(rs.getString("id_jenis"));
            s.setJenis_pakaian(rs.getString("jenis_pakaian"));
        }

        return s;
    }
    
    public Object[] getAllName() throws SQLException{
        Object[] name = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<>();
        ResultSet rs = getAllNameStatement.executeQuery();
        while(rs.next()){
            newObj.add(rs.getString("jenis_pakaian"));
        }
        return newObj.toArray();
    }
    
    public MasterJenisPakaian getByName(String name) throws SQLException {
        MasterJenisPakaian s = new MasterJenisPakaian();
        getByNameStatement.setString(1, name);
        ResultSet rs = getByNameStatement.executeQuery();
        while (rs.next()) {
            s.setIdJenis(rs.getString("id_jenis"));
            s.setJenis_pakaian(rs.getString("jenis_pakaian"));
        }
        return s;
    }

}
