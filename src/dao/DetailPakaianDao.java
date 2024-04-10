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
import model.DetailPakaian;
import dao.UkuranDao;
import dao.PakaianDao;

/**
 *
 * @author user_
 */
public class DetailPakaianDao {
    
    private Connection connection;
    private UkuranDao ukuranDao;
    private PakaianDao pakaianDao;
    private MasterJenisPakaianDao masterJenisPakaianDao;
    private PreparedStatement simpanStatement;
    private PreparedStatement ubahStatement;
    private PreparedStatement hapusStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement getAllNameStatement;
    private PreparedStatement getByNameStatement;
    private PreparedStatement getByKodeAndUkuranStatement;
    
    private final String queryInsert = "INSERT INTO detail_pakaian (kode_pakaian, warna_pakaian, ukuran_pakaian, harga_pakaian, stok_pakaian) VALUES (?,?,?,?,?)";
    private final String queryUpdate = "UPDATE detail_pakaian SET warna_pakaian=?, harga_pakaian=?, stok_pakaian=? WHERE kode_pakaian=? AND ukuran_pakaian=?";
    private final String queryDelete = "DELETE FROM detail_pakaian WHERE kode_pakaian=?";
    private final String querySelectAll = "SELECT * FROM detail_pakaian";
    private final String querySelectById = "SELECT detail_pakaian.*, pakaian.* from detail_Pakaian JOIN pakaian ON detail_pakaian.kode_pakaian = pakaian.kode_pakaian WHERE detail_pakaian.kode_pakaian LIKE ? OR pakaian.nama_pakaian LIKE ?";
    private final String querySelectAllName = "SELECT nama_pakaian from Pakaian";
    private final String querySelectByName = "SELECT * from Pakaian WHERE nama_pakaian=?";
    private final String queryGetByKodeAndUkuran = "SELECT * from detail_Pakaian WHERE kode_pakaian = ? AND ukuran_pakaian=?";


    public void setConnection(Connection connection, PakaianDao pakaianDao, UkuranDao ukuranDao) throws SQLException {
        this.connection = connection;
        this.ukuranDao = ukuranDao;
        this.pakaianDao = pakaianDao;

        simpanStatement = connection.prepareStatement(queryInsert);
        ubahStatement = connection.prepareStatement(queryUpdate);
        hapusStatement = connection.prepareStatement(queryDelete);
        getAllStatement = connection.prepareStatement(querySelectAll);
        getByIdStatement = connection.prepareStatement(querySelectById);
        getAllNameStatement = connection.prepareStatement(querySelectAllName);
        getByNameStatement = connection.prepareStatement(querySelectByName);
        getByKodeAndUkuranStatement = connection.prepareStatement(queryGetByKodeAndUkuran);
    }

    public DetailPakaian simpan(DetailPakaian p) throws SQLException {
        simpanStatement.setObject(1, p.getKodePakaian().getKodePakaian());
        simpanStatement.setString(2, p.getWarnaPakaian());
        simpanStatement.setObject(3, p.getUkuranPakaian().getUkuran());
        simpanStatement.setInt(4, p.getHargaPakaian());
        simpanStatement.setInt(5, p.getStokPakaian());
        simpanStatement.executeUpdate();
        return p;
    }

    public DetailPakaian ubah(DetailPakaian p) throws SQLException {
        ubahStatement.setString(1, p.getWarnaPakaian());
        ubahStatement.setInt(2, p.getHargaPakaian());
        ubahStatement.setInt(3, p.getStokPakaian());
        ubahStatement.setObject(4, p.getKodePakaian().getKodePakaian());
        ubahStatement.setObject(5, p.getUkuranPakaian().getUkuran());
        ubahStatement.executeUpdate();
        return p;
    }

    public DetailPakaian hapus(DetailPakaian p) throws SQLException {
        hapusStatement.setString(1, p.getKodePakaian().getKodePakaian());
        hapusStatement.setString(2, p.getUkuranPakaian().getUkuran());
        hapusStatement.executeUpdate();
        return p;
    }

    public List<DetailPakaian> getAll() throws SQLException {
        List<DetailPakaian> list = new ArrayList<>();
        ResultSet rs = getAllStatement.executeQuery();

        while (rs.next()) {
            DetailPakaian s = new DetailPakaian();
            s.setKodePakaian(pakaianDao.getById(rs.getString("kode_pakaian")));
            s.setWarnaPakaian(rs.getString("warna_pakaian"));
            s.setUkuranPakaian(ukuranDao.getById(rs.getString("ukuran_pakaian")));
            s.setHargaPakaian(rs.getInt("harga_pakaian"));
            s.setStokPakaian(rs.getInt("stok_pakaian"));
            list.add(s);
        }

        return list;
    }

    public List<DetailPakaian> getById(String kode) throws SQLException {
        List<DetailPakaian> list = new ArrayList<>();
        
        getByIdStatement.setString(1, '%'+kode+'%');
        getByIdStatement.setString(2, '%'+kode+'%');
        ResultSet rs = getByIdStatement.executeQuery();

        while (rs.next()) {
            DetailPakaian s = new DetailPakaian();
            s.setKodePakaian(pakaianDao.getById(rs.getString("kode_pakaian")));
            s.setWarnaPakaian(rs.getString("warna_pakaian"));
            s.setUkuranPakaian(ukuranDao.getById(rs.getString("ukuran_pakaian")));
            s.setHargaPakaian(rs.getInt("harga_pakaian"));
            s.setStokPakaian(rs.getInt("stok_pakaian"));
            list.add(s);
        }

        return list;
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
    
    public DetailPakaian getByKodeAndUkuran(String kode, String ukuran) throws SQLException {
        DetailPakaian s = new DetailPakaian();
        getByKodeAndUkuranStatement.setString(1, kode);
        getByKodeAndUkuranStatement.setString(2, ukuran);
        ResultSet rs = getByKodeAndUkuranStatement.executeQuery();
        while (rs.next()) {
            s.setKodePakaian(pakaianDao.getById(rs.getString("kode_pakaian")));
            s.setWarnaPakaian(rs.getString("warna_pakaian"));
            s.setUkuranPakaian(ukuranDao.getById(rs.getString("ukuran_pakaian")));
            s.setHargaPakaian(rs.getInt("harga_pakaian"));
            s.setStokPakaian(rs.getInt("stok_pakaian"));
        }
        return s;
    }



}
