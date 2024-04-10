/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user_
 */
public class DetailPenjualan {

    private Penjualan kodePenjualan;
    private Pakaian kodePakaian;
    private String ukuran;
    private Integer qty;
    private Integer subTotal;

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public Penjualan getKodePenjualan() {
        return kodePenjualan;
    }

    public void setKodePenjualan(Penjualan kodePenjualan) {
        this.kodePenjualan = kodePenjualan;
    }

    public Pakaian getKodePakaian() {
        return kodePakaian;
    }

    public void setKodePakaian(Pakaian kodePakaian) {
        this.kodePakaian = kodePakaian;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

}
