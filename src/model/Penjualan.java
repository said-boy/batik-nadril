/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author user_
 */
public class Penjualan {

    private String kodeTransaksi;
    private Pelanggan kodePelanggan;
    private String tanggal;
    private Admin kodeAdmin;

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public Pelanggan getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(Pelanggan kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Admin getKodeAdmin() {
        return kodeAdmin;
    }

    public void setKodeAdmin(Admin kodeAdmin) {
        this.kodeAdmin = kodeAdmin;
    }


}
