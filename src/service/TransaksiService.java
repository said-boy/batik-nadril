/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.DetailPenjualan;
import model.Penjualan;

/**
 *
 * @author user_
 */
public interface TransaksiService {
    
    Penjualan getPenjualanByKode(String penjualan);
    Penjualan getLastPenjualan();
    Penjualan simpanPenjualan(Penjualan penjualan);

    DetailPenjualan simpanDetailPenjualan(DetailPenjualan detailPenjualan);

}
