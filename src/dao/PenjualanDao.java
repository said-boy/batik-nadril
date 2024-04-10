/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Penjualan;

/**
 *
 * @author user_
 */
public class PenjualanDao {
    private Connection connection;
    private PelangganDao pelangganDao;
    private AdminDao adminDao;

    private PreparedStatement simpanStatement, getPenjualanByKodeStatement, getLastStatement;
    
    private final String queryInsert = "INSERT INTO penjualan (kode_transaksi, tanggal, kode_pelanggan, kode_admin) VALUES (?,?,?,?)";
    private final String queryGetPenjualanByKode = "SELECT * FROM penjualan WHERE kode_transaksi = ?";
    private final String queryGetLast = "SELECT * FROM penjualan ORDER BY kode_transaksi DESC LIMIT 1";
    
    public void setConnection(Connection connection, PelangganDao pelangganDao, AdminDao adminDao) throws SQLException{
        this.connection = connection;
        this.pelangganDao = pelangganDao;
        this.adminDao = adminDao;

        simpanStatement = connection.prepareStatement(queryInsert);
        getPenjualanByKodeStatement = connection.prepareStatement(queryGetPenjualanByKode);
        getLastStatement = connection.prepareStatement(queryGetLast);
    }
    
    public Penjualan simpan(Penjualan p) throws SQLException{
        simpanStatement.setString(1, p.getKodeTransaksi());
        simpanStatement.setString(2, p.getTanggal());
        simpanStatement.setString(3, p.getKodePelanggan().getKodePelanggan());
        simpanStatement.setString(4, p.getKodeAdmin().getId_admin());
        simpanStatement.executeUpdate();
        return p;
    }

    public Penjualan getByKode(String p) throws SQLException{    
        Penjualan s = new Penjualan();
        getPenjualanByKodeStatement.setString(1, p);
        ResultSet rs = getPenjualanByKodeStatement.executeQuery();
        if (rs.next()) {
            s.setKodeTransaksi(rs.getString("kode_transaksi"));
            s.setTanggal(rs.getString("tanggal"));
            s.setKodePelanggan(pelangganDao.getById(rs.getString("kode_pelanggan")));
            s.setKodeAdmin(adminDao.getByKode(rs.getString("kode_admin")));
        }
        return s;
    }
    
    public Penjualan getLast() throws SQLException{    
        Penjualan s = new Penjualan();
        ResultSet rs = getLastStatement.executeQuery();
        if (rs.next()) {
            s.setKodeTransaksi(rs.getString("kode_transaksi"));
            s.setTanggal(rs.getString("tanggal"));
            s.setKodePelanggan(pelangganDao.getById(rs.getString("kode_pelanggan")));
            s.setKodeAdmin(adminDao.getByKode(rs.getString("kode_admin")));
        }
        return s;
    }
}
