/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.DetailPakaian;

/**
 *
 * @author user_
 */
public interface DetailService {
    
    DetailPakaian simpanDetailPakaian(DetailPakaian detailpakaian);
    DetailPakaian ubahDetailPakaian(DetailPakaian detailpakaian);
    DetailPakaian hapusDetailPakaian(DetailPakaian detailpakaian);
    List<DetailPakaian> getAllDetailPakaian();
    List<DetailPakaian> getDetailPakaianByKode(String detailpakaian);

    DetailPakaian getDetailByKodeAndByUkuran(String kode, String ukuran);

}
