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
import model.Pelanggan;

/**
 *
 * @author user_
 */
public class PelangganDao {
    private Connection connection;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    private PreparedStatement getSelectLikeByName;
    
    private final String queryInsert = "INSERT INTO pelanggan (kode_pelanggan, nama_pelanggan, alamat_pelanggan, nomor_pelanggan) VALUES (?,?,?,?)";
    private final String queryUpdate = "UPDATE pelanggan SET nama_pelanggan=?, alamat_pelanggan=?, nomor_pelanggan=? WHERE kode_pelanggan=?";
    private final String queryDelete = "DELETE FROM pelanggan WHERE kode_pelanggan=?";
    private final String querySelectAll = "SELECT * FROM pelanggan";
    private final String querySelectById = "SELECT * from pelanggan WHERE kode_pelanggan=?";
    private final String querySelectAllName = "SELECT nama from pelanggan";
    private final String querySelectByName = "SELECT * from pelanggan WHERE kode_pelanggan=?";
    private final String querySelectLikeByName = "SELECT * from pelanggan WHERE kode_pelanggan LIKE ? or nama_pelanggan LIKE ?";


    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;

        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getAllNameStatement = connection.prepareStatement(querySelectAllName);
        getByNameStatement = connection.prepareStatement(querySelectByName);
        getSelectLikeByName = connection.prepareStatement(querySelectLikeByName);
    }

    public Pelanggan simpan(Pelanggan p) throws SQLException {
        simpanStatement.setString(1, p.getKodePelanggan());
        simpanStatement.setString(2, p.getNamaPelanggan());
        simpanStatement.setString(3, p.getAlamatPelanggan());
        simpanStatement.setString(4, p.getNomor_pelanggan());
        simpanStatement.executeUpdate();
        return p;
    }

    public Pelanggan ubah(Pelanggan p) throws SQLException {
        ubahStatement.setString(1, p.getNamaPelanggan());
        ubahStatement.setString(2, p.getAlamatPelanggan());
        ubahStatement.setString(3, p.getNomor_pelanggan());
        ubahStatement.setString(4, p.getKodePelanggan());
        ubahStatement.executeUpdate();
        return p;
    }

    public Pelanggan hapus(Pelanggan p) throws SQLException {
        hapusStatement.setString(1, p.getKodePelanggan());
        hapusStatement.executeUpdate();
        return p;
    }

    public List<Pelanggan> getAll() throws SQLException {
        List<Pelanggan> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Pelanggan s = new Pelanggan();
            s.setKodePelanggan(rs.getString("kode_pelanggan"));
            s.setNamaPelanggan(rs.getString("nama_pelanggan"));
            s.setAlamatPelanggan(rs.getString("alamat_pelanggan"));
            s.setNomor_pelanggan(rs.getString("nomor_pelanggan"));
            list.add(s);
        }

        return list;
    }

    public Pelanggan getById(String id) throws SQLException {
        Pelanggan s = new Pelanggan();
        
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            s.setKodePelanggan(rs.getString("kode_Pelanggan"));
            s.setNamaPelanggan(rs.getString("nama_pelanggan"));
        }

        return s;
    }
    
    public Object[] getAllName() throws SQLException{
        Object[] name = new Object[] {};
        ArrayList<Object> newObj = new ArrayList<>();
        ResultSet rs = getAllNameStatement.executeQuery();
        while(rs.next()){
            newObj.add(rs.getString("nama"));
        }
        return newObj.toArray();
    }
    
    public Pelanggan getByName(String name) throws SQLException {
        Pelanggan s = new Pelanggan();
        getByNameStatement.setString(1, name);
        ResultSet rs = getByNameStatement.executeQuery();
        if (rs.next()) {
            s.setKodePelanggan(rs.getString("kode_Pelanggan"));
            s.setNamaPelanggan(rs.getString("nama_pelanggan"));
            s.setAlamatPelanggan(rs.getString("alamat_pelanggan"));
            s.setNomor_pelanggan(rs.getString("nomor_pelanggan"));
        }
        return s;
    }

    public List<Pelanggan> getLikeByName(String name) throws SQLException {
        List<Pelanggan> list = new ArrayList<>();
        getSelectLikeByName.setString(1, '%'+name+'%');
        getSelectLikeByName.setString(2, '%'+name+'%');
        ResultSet rs = getSelectLikeByName.executeQuery();

        while (rs.next()) {
            Pelanggan s = new Pelanggan();
            s.setKodePelanggan(rs.getString("kode_pelanggan"));
            s.setNamaPelanggan(rs.getString("nama_pelanggan"));
            s.setAlamatPelanggan(rs.getString("alamat_pelanggan"));
            s.setNomor_pelanggan(rs.getString("nomor_pelanggan"));
            list.add(s);
        }

        return list;
    }

}
