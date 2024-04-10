/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import config.Koneksi;
import dao.DetailPakaianDao;
import dao.MasterJenisPakaianDao;
import dao.PakaianDao;
import dao.UkuranDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DetailPakaian;
import service.DetailService;

/**
 *
 * @author user_
 */
public class DetailServiceImpl implements DetailService{

    private Koneksi koneksi;
    private Connection connection;

    private DetailPakaianDao detailPakaianDao;
    private UkuranDao ukuranDao;
    private PakaianDao pakaianDao;
    private MasterJenisPakaianDao masterPakaianDao;

    public DetailServiceImpl() {

        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();

            ukuranDao = new UkuranDao();
            ukuranDao.setConnection(connection);

            masterPakaianDao = new MasterJenisPakaianDao();
            masterPakaianDao.setConnection(connection);

            pakaianDao = new PakaianDao();
            pakaianDao.setConnection(connection, masterPakaianDao);


            detailPakaianDao = new DetailPakaianDao();
            detailPakaianDao.setConnection(connection, pakaianDao, ukuranDao);

        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<DetailPakaian> getAllDetailPakaian(){
        try {
            return detailPakaianDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<DetailPakaian> getDetailPakaianByKode(String dp){
        try {
            return detailPakaianDao.getById(dp);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DetailPakaian getDetailByKodeAndByUkuran(String kode, String ukuran){
        try {
            return detailPakaianDao.getByKodeAndUkuran(kode, ukuran);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DetailPakaian simpanDetailPakaian(DetailPakaian detailPakaian){
        try {
            return detailPakaianDao.simpan(detailPakaian);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DetailPakaian ubahDetailPakaian(DetailPakaian detailPakaian){
        try {
            return detailPakaianDao.ubah(detailPakaian);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public DetailPakaian hapusDetailPakaian(DetailPakaian detailPakaian){
        try {
            return detailPakaianDao.hapus(detailPakaian);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
