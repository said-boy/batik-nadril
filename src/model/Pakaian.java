/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user_
 */
public class Pakaian {
    
    private String kodePakaian, namaPakaian;
    private MasterJenisPakaian idJenis;

    public String getKodePakaian() {
        return kodePakaian;
    }

    public void setKodePakaian(String kodePakaian) {
        this.kodePakaian = kodePakaian;
    }

    public String getNamaPakaian() {
        return namaPakaian;
    }

    public void setNamaPakaian(String namaPakaian) {
        this.namaPakaian = namaPakaian;
    }

    public MasterJenisPakaian getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(MasterJenisPakaian idJenis) {
        this.idJenis = idJenis;
    }



}
