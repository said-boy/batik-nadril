/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import config.Koneksi;
import dao.AdminDao;
import dao.PelangganDao;
import dao.PenjualanDao;
import dao.DetailPenjualanDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DetailPenjualan;
import model.Penjualan;
import service.TransaksiService;

/**
 *
 * @author user_
 */
public class TransaksiServiceImpl implements TransaksiService{
    private AdminDao adminDao;
    private PelangganDao pelangganDao;
    private PenjualanDao penjualanDao;
    private DetailPenjualanDao detailPenjualanDao;

    private Koneksi koneksi;
    private Connection connection;

    public TransaksiServiceImpl() {
        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();

            adminDao = new AdminDao();
            adminDao.setConnection(connection);

            pelangganDao = new PelangganDao();
            pelangganDao.setConnection(connection);
           
            penjualanDao = new PenjualanDao();
            penjualanDao.setConnection(connection, pelangganDao, adminDao);

            detailPenjualanDao = new DetailPenjualanDao();
            detailPenjualanDao.setConnection(connection);

        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Penjualan getPenjualanByKode(String penjualan){
        try {
            return penjualanDao.getByKode(penjualan);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Penjualan simpanPenjualan(Penjualan penjualan){
        try {
            connection.setAutoCommit(false);
            penjualanDao.simpan(penjualan);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DetailPenjualan simpanDetailPenjualan(DetailPenjualan detailPenjualan){
        try {
            connection.setAutoCommit(false);
            detailPenjualanDao.simpan(detailPenjualan);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Penjualan getLastPenjualan() {
        try {
            return penjualanDao.getLast();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
