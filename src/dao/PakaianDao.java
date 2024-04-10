/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pakaian;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user_
 */
public class PakaianDao {
    private Connection connection;
    private MasterJenisPakaianDao masterJenisPakaianDao;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    
    private final String queryInsert = "INSERT INTO Pakaian (kode_pakaian, nama_pakaian, id_jenis) VALUES (?,?,?)";
    private final String queryUpdate = "UPDATE Pakaian SET nama_pakaian=?, id_jenis=? WHERE kode_pakaian=?";
    private final String queryDelete = "DELETE FROM Pakaian WHERE kode_pakaian=?";
    private final String querySelectAll = "SELECT * FROM Pakaian";
    private final String querySelectById = "SELECT * from Pakaian WHERE kode_pakaian=?";
    private final String querySelectAllName = "SELECT nama_pakaian from Pakaian";
    private final String querySelectByName = "SELECT * from Pakaian WHERE kode_pakaian LIKE ? or nama_pakaian LIKE ?";

    public void setConnection(Connection connection, MasterJenisPakaianDao masterJenisPakaianDao) throws SQLException {
        this.connection = connection;
        this.masterJenisPakaianDao = masterJenisPakaianDao;

        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getAllNameStatement = connection.prepareStatement(querySelectAllName);
        getByNameStatement = connection.prepareStatement(querySelectByName);
    }

    public Pakaian simpan(Pakaian p) throws SQLException {
        simpanStatement.setString(1, p.getKodePakaian());
        simpanStatement.setString(2, p.getNamaPakaian());
        simpanStatement.setObject(3, p.getIdJenis().getIdJenis());
        simpanStatement.executeUpdate();
        return p;
    }

    public Pakaian ubah(Pakaian p) throws SQLException {
        ubahStatement.setString(1, p.getNamaPakaian());
        ubahStatement.setObject(2, p.getIdJenis().getIdJenis());
        ubahStatement.setString(3, p.getKodePakaian());
        ubahStatement.executeUpdate();
        return p;
    }

    public Pakaian hapus(Pakaian p) throws SQLException {
        hapusStatement.setString(1, p.getKodePakaian());
        hapusStatement.executeUpdate();
        return p;
    }

    public List<Pakaian> getAll() throws SQLException {
        List<Pakaian> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            Pakaian s = new Pakaian();
            s.setKodePakaian(rs.getString("kode_pakaian"));
            s.setNamaPakaian(rs.getString("nama_pakaian"));
            s.setIdJenis(masterJenisPakaianDao.getById(rs.getString("id_jenis")));
            list.add(s);
        }

        return list;
    }

    public Pakaian getById(String id) throws SQLException {
        Pakaian s = new Pakaian();
        
        getByIdStatement.setString(1, id);
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            s.setKodePakaian(rs.getString("kode_pakaian"));
            s.setNamaPakaian(rs.getString("nama_pakaian"));
            s.setIdJenis(masterJenisPakaianDao.getById(rs.getString("id_jenis")));
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
    
    public List<Pakaian> getByName(String name) throws SQLException {
        List<Pakaian> list = new ArrayList<>();
        getByNameStatement.setString(1, '%'+name+'%');
        getByNameStatement.setString(2, '%'+name+'%');
        ResultSet rs = getByNameStatement.executeQuery();

        while (rs.next()) {
            Pakaian s = new Pakaian();
            s.setKodePakaian(rs.getString("kode_pakaian"));
            s.setNamaPakaian(rs.getString("nama_pakaian"));
            s.setIdJenis(masterJenisPakaianDao.getById(rs.getString("id_jenis")));
            list.add(s);
        }

        return list;
    }
}
