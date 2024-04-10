/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Admin;
import model.MasterJenisPakaian;
import model.Pakaian;
import model.Pelanggan;
import model.Ukuran;

/**
 *
 * @author user_
 */
public interface MasterService {
    Admin loginAdmin(Admin admin);
    Admin getAdminByKode(String kode);

    Pelanggan simpanPelanggan(Pelanggan p);
    Pelanggan ubahPelanggan(Pelanggan p);
    Pelanggan hapusPelanggan(Pelanggan p);
    List<Pelanggan> getAllPelanggan();
    Pelanggan getPelangganByName(String name);
    List<Pelanggan> findPelangganByName(String name);

    MasterJenisPakaian simpanMasterJenisPakaian(MasterJenisPakaian masterJenisPakaian);
    MasterJenisPakaian ubahMasterJenisPakaian(MasterJenisPakaian masterJenisPakaian);
    MasterJenisPakaian hapusMasterJenisPakaian(MasterJenisPakaian masterJenisPakaian);
    List<MasterJenisPakaian> getAllMasterJenisPakaian();
    Object[] getAllNameMasterJenisPakaian();
    MasterJenisPakaian getByNameMasterJenisPakaian(String name);

    Ukuran simpanUkuran(Ukuran ukuran);
    Ukuran hapusUkuran(Ukuran ukuran);
    Object[] getAllUkuran();
    List<Ukuran> getUkuran();
    Ukuran getUkuran(String ukuran);

    Pakaian simpanPakaian(Pakaian pakaian);
    Pakaian ubahPakaian(Pakaian pakaian);
    Pakaian hapusPakaian(Pakaian pakaian);
    List<Pakaian> getAllPakaian();
    Pakaian getPakaianById(String id);
    List<Pakaian> findPakaianByName(String name);


//    Kebaya simpanKebaya(Kebaya k);
//    Kebaya ubahKebaya(Kebaya k);
//    Kebaya hapusKebaya(Kebaya k);
//    List<Kebaya> getAllKebaya();
//    List<Kebaya> findKebayaByName(String nama);
//
//    Kemeja simpanKemeja(Kemeja k);
//    Kemeja ubahKemeja(Kemeja k);
//    Kemeja hapusKemeja(Kemeja k);
//    List<Kemeja> getAllKemeja();
}
