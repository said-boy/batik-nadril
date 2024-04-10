/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user_
 */
public class DetailPakaian {

    private Pakaian kodePakaian;
    private String warnaPakaian;
    private Ukuran ukuranPakaian;
    private Integer hargaPakaian;
    private Integer stokPakaian;

    public Pakaian getKodePakaian() {
        return kodePakaian;
    }

    public void setKodePakaian(Pakaian kodePakaian) {
        this.kodePakaian = kodePakaian;
    }

    public String getWarnaPakaian() {
        return warnaPakaian;
    }

    public void setWarnaPakaian(String warnaPakaian) {
        this.warnaPakaian = warnaPakaian;
    }

    public Ukuran getUkuranPakaian() {
        return ukuranPakaian;
    }

    public void setUkuranPakaian(Ukuran ukuranPakaian) {
        this.ukuranPakaian = ukuranPakaian;
    }

    public Integer getHargaPakaian() {
        return hargaPakaian;
    }

    public void setHargaPakaian(Integer hargaPakaian) {
        this.hargaPakaian = hargaPakaian;
    }

    public Integer getStokPakaian() {
        return stokPakaian;
    }

    public void setStokPakaian(Integer stokPakaian) {
        this.stokPakaian = stokPakaian;
    }

}
