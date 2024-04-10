/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import config.Koneksi;
import dao.AdminDao;
import dao.MasterJenisPakaianDao;
import dao.PakaianDao;
import dao.PelangganDao;
import dao.UkuranDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import service.MasterService;

/**
 *
 * @author deirn
 */
public class MasterServiceImpl implements MasterService {

    private AdminDao adminDao;
    private PelangganDao pelangganDao;
    private MasterJenisPakaianDao masterJenisPakaianDao;
    private UkuranDao ukuranDao;
    private PakaianDao pakaianDao;

    private Koneksi koneksi;
    private Connection connection;

    public MasterServiceImpl() {
        try {
            koneksi = new Koneksi();
            connection = koneksi.getConnection();

            adminDao = new AdminDao();
            adminDao.setConnection(connection);

            pelangganDao = new PelangganDao();
            pelangganDao.setConnection(connection);

            masterJenisPakaianDao = new MasterJenisPakaianDao();
            masterJenisPakaianDao.setConnection(connection);
            
            ukuranDao = new UkuranDao();
            ukuranDao.setConnection(connection);

            pakaianDao = new PakaianDao();
            pakaianDao.setConnection(connection, masterJenisPakaianDao);

        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Admin loginAdmin(Admin admin){
        try {
            return adminDao.login(admin);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Admin getAdminByKode(String kode){
        try {
            return adminDao.getByKode(kode);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Pelanggan simpanPelanggan(Pelanggan p) {
        try {
            connection.setAutoCommit(false);
            pelangganDao.simpan(p);
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

        return p;
    }

    @Override
    public Pelanggan ubahPelanggan(Pelanggan p) {
        try {
            connection.setAutoCommit(false);
            pelangganDao.ubah(p);
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

        return p;
    }

    @Override
    public Pelanggan hapusPelanggan(Pelanggan p) {
        try {
            connection.setAutoCommit(false);
            pelangganDao.hapus(p);
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
        return p;
    }

    @Override
    public List<Pelanggan> getAllPelanggan(){
        try {
            return pelangganDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Pelanggan getPelangganByName(String name){
        try {
            return pelangganDao.getByName(name);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Pelanggan> findPelangganByName(String name){
        try {
            return pelangganDao.getLikeByName(name);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MasterJenisPakaian simpanMasterJenisPakaian(MasterJenisPakaian masterJenisPakaian) {
        try {
            connection.setAutoCommit(false);
            masterJenisPakaianDao.simpan(masterJenisPakaian);
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
        return masterJenisPakaian;
    }

    @Override
    public MasterJenisPakaian ubahMasterJenisPakaian(MasterJenisPakaian masterJenisPakaian) {
        try {
            connection.setAutoCommit(false);
            masterJenisPakaianDao.ubah(masterJenisPakaian);
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

        return masterJenisPakaian;
    }

    @Override
    public MasterJenisPakaian hapusMasterJenisPakaian(MasterJenisPakaian masterJenisPakaian) {
        try {
            connection.setAutoCommit(false);
            masterJenisPakaianDao.hapus(masterJenisPakaian);
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

        return masterJenisPakaian;
    }

    @Override
    public List<MasterJenisPakaian> getAllMasterJenisPakaian(){
        try {
            return masterJenisPakaianDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object[] getAllNameMasterJenisPakaian(){
        try {
            return masterJenisPakaianDao.getAllName();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MasterJenisPakaian getByNameMasterJenisPakaian(String name){
        try {
            return masterJenisPakaianDao.getByName(name);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Ukuran simpanUkuran(Ukuran ukuran) {
        try {
            connection.setAutoCommit(false);
            ukuranDao.simpan(ukuran);
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
        return ukuran;
    }

    @Override
    public Ukuran hapusUkuran(Ukuran ukuran) {
        try {
            connection.setAutoCommit(false);
            ukuranDao.hapus(ukuran);
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

        return ukuran;
    }

    @Override
    public Object[] getAllUkuran(){
        try {
            return ukuranDao.getAllName();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Ukuran> getUkuran(){
        try {
            return ukuranDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Ukuran getUkuran(String ukuran){
        try {
            return ukuranDao.getById(ukuran);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Pakaian simpanPakaian(Pakaian pakaian){
        try {
            connection.setAutoCommit(false);
            pakaianDao.simpan(pakaian);
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
        return pakaian;
    }

    public Pakaian ubahPakaian(Pakaian pakaian){
        try {
            connection.setAutoCommit(false);
            pakaianDao.ubah(pakaian);
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
        return pakaian;
    }

    public Pakaian hapusPakaian(Pakaian pakaian){
        try {
            connection.setAutoCommit(false);
            pakaianDao.hapus(pakaian);
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
        return pakaian;
    }

    @Override
    public List<Pakaian> getAllPakaian(){   
        try{
            return pakaianDao.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Pakaian getPakaianById(String id){   
        try{
            return pakaianDao.getById(id);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Pakaian> findPakaianByName(String name){   
        try{
            return pakaianDao.getByName(name);
        } catch (SQLException ex) {
            Logger.getLogger(MasterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
