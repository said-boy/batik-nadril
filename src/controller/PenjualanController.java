/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import config.Koneksi;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.App;
import view.PenjualanView;
import model.Pakaian;
import model.Pelanggan;
import model.DetailPakaian;
import model.DetailPenjualan;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import view.CariDialogView;
import view.DetailPakaianView;
import view.PakaianView;
import view.PelangganView;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author user_
 */
public class PenjualanController {

    private final PenjualanView penjualanView;
    private PelangganView pelangganView;
    private List<DetailPakaian> listProduk;
    private List<Pelanggan> listPelanggan;
    private DetailPenjualan produk;
    private DetailPakaian detailPakaian;

    public PenjualanController(PenjualanView penjualanView) {
        this.penjualanView = penjualanView;
    }
    
    public void cariProduk(String nama){
        CariDialogView cariDialog = new CariDialogView(App.menuView, true);
        listProduk = App.detailService.getDetailPakaianByKode(nama);
        DetailPakaianView pv = new DetailPakaianView();
        DetailPakaianView.ProdukTableModel produkTabelModel = pv.new ProdukTableModel(listProduk);
        cariDialog.getTabelCari().setModel(produkTabelModel);
        
        DetailPakaianController pc = new DetailPakaianController(pv);
        cariDialog.getTabelCari().getSelectionModel().addListSelectionListener((lse) -> {
            if(cariDialog.getTabelCari().getSelectedRow()>=0){
                int row = cariDialog.getTabelCari().getSelectedRow();
                DetailPakaian pakaian = listProduk.get(row);
                penjualanView.getTextNamaProduk().setText(pakaian.getKodePakaian().getKodePakaian());
                penjualanView.getTextNamaPakaian().setText(pakaian.getKodePakaian().getNamaPakaian());
                penjualanView.getTextJenis().setText(pakaian.getKodePakaian().getIdJenis().getJenis_pakaian());
                penjualanView.getTextUkuran().setText(pakaian.getUkuranPakaian().getUkuran());
                penjualanView.getTextwarnaPakaian().setText(pakaian.getWarnaPakaian());
                penjualanView.getTextHarga().setText(String.valueOf(pakaian.getHargaPakaian()));
            }
        });
        cariDialog.setVisible(true);
    }

    public void cariPelanggan(String nama){
        CariDialogView cariDialog = new CariDialogView(App.menuView, true);
        listPelanggan = App.masterService.findPelangganByName(nama);
        PelangganView pv = new PelangganView();
        PelangganView.PelangganTableModel produkTabelModel = pv.new PelangganTableModel(listPelanggan);
        cariDialog.getTabelCari().setModel(produkTabelModel);
        
        PelangganController pc = new PelangganController(pv);
        cariDialog.getTabelCari().getSelectionModel().addListSelectionListener((lse) -> {
            if(cariDialog.getTabelCari().getSelectedRow()>=0){
                int row = cariDialog.getTabelCari().getSelectedRow();
                Pelanggan pelanggan = listPelanggan.get(row);
                penjualanView.getTextPelanggan().setText(pelanggan.getKodePelanggan());
            }
        });
        cariDialog.setVisible(true);
    }
    
    public boolean cekProduk(List<DetailPenjualan> listDetail, String kode, String ukuran){
        boolean kondisi = false;
        for (DetailPenjualan detailPenjualan : listDetail) {
            if(detailPenjualan.getKodePakaian().getKodePakaian().equals(kode) 
                    && detailPenjualan.getUkuran().equals(ukuran)
                    && detailPenjualan.getUkuran() != null){
                kondisi = true;
                JOptionPane.showMessageDialog(penjualanView, "Produk sudah dimasukkan!");
                break;
            }
        }
        return kondisi;
    }
    
    public void tambahProduk(List<DetailPenjualan> listDetail){
//        produk = new DetailPenjualan();
        if(cekProduk(listDetail, penjualanView.getTextNamaProduk().getText(), penjualanView.getTextUkuran().getText())){
            clearProduk();
        }else{
            DetailPenjualan detail = new DetailPenjualan();
            DetailPakaian detailPakaian = new DetailPakaian();
            detail.setKodePenjualan(App.transaksiService.getPenjualanByKode(penjualanView.getTextIdPenjualan().getText()));
            detail.setKodePakaian(App.masterService.getPakaianById(penjualanView.getTextNamaProduk().getText()));
            detail.setQty(Integer.parseInt(penjualanView.getTextJumlahBeli().getText()));
            detail.setUkuran(penjualanView.getTextUkuran().getText());
            detailPakaian.setHargaPakaian(Integer.parseInt(penjualanView.getTextHarga().getText()));
            detail.setSubTotal(Integer.parseInt(penjualanView.getTextHarga().getText()) * Integer.parseInt(penjualanView.getTextJumlahBeli().getText()));
            
            listDetail.add(detail);
            refreshTotal(listDetail);
            clearProduk();
        }
    }
    
    private void refreshTotal(List<DetailPenjualan> listDetail) {
        if (listDetail != null && !listDetail.isEmpty()) {
            Double total = 0.0;
            for (DetailPenjualan od : listDetail) {
            DetailPakaian sub = App.detailService.getDetailByKodeAndByUkuran(od.getKodePakaian().getKodePakaian(), od.getUkuran());
                total = total + od.getQty()*sub.getHargaPakaian();
            }
            penjualanView.getTextTotal().setText(total.toString());
        }else{
	    penjualanView.getTextTotal().setText("0");
	}
    }
    
    public void deleteItem(List<DetailPenjualan> listDetail){
        if (penjualanView.getTabelPenjualan().getSelectedRow() >= 0) {
            int row = penjualanView.getTabelPenjualan().getSelectedRow();
            listDetail.remove(row);
	    refreshTotal(listDetail);
            penjualanView.getTabelPenjualan().getSelectionModel().clearSelection();
        } 
    }
    
    public void clearProduk(){
        penjualanView.getTextNamaProduk().setText(null);
        penjualanView.getTextNamaPakaian().setText(null);
        penjualanView.getTextJenis().setText(null);
        penjualanView.getTextUkuran().setText(null);
        penjualanView.getTextHarga().setText(null);
        penjualanView.getTextwarnaPakaian().setText(null);
        penjualanView.getTextJumlahBeli().setText(null);
        penjualanView.getTabelPenjualan().clearSelection();
    }
    
    public void clearForm(){
        clearProduk();
        penjualanView.getTextPelanggan().setText(null);
        penjualanView.getTextIdPenjualan().setText(null);
        penjualanView.getTanggalTransaksi().setDate(null);
        penjualanView.getTextTotal().setText("0");
    }
    
    public void cetakNota() throws IOException{
        try {
            Koneksi koneksi = new Koneksi();
            HashMap param = new HashMap();
            String rootPath = new File(".").getCanonicalPath();
            String path = "src/laporan/nota.jasper";
            JasperPrint jp = JasperFillManager.fillReport(rootPath+"/"+path, param, koneksi.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Integer counter = 0;
    public void generateKodeTransaksi() {
        if (App.transaksiService.getLastPenjualan().getKodeTransaksi() == null){
            String transactionCode = String.format("PNJ-%04d", ++counter);
            penjualanView.getTextIdPenjualan().setText(transactionCode);
            penjualanView.getTextIdPenjualan().setEditable(false);
        }else{
            Integer last = Integer.valueOf(App.transaksiService.getLastPenjualan().getKodeTransaksi().substring(4));
            String transactionCode = String.format("PNJ-%04d", ++last);
            penjualanView.getTextIdPenjualan().setText(transactionCode);
            penjualanView.getTextIdPenjualan().setEditable(false);
        }
    }
    
    public Boolean validasiInput(){
        if(penjualanView.getTanggalTransaksi().getDate() == null){
            JOptionPane.showMessageDialog(penjualanView, "Sepertinya anda lupa memasukkan Tanggal");
            return false;
        }else if("".equals(penjualanView.getTextPelanggan().getText())){
            JOptionPane.showMessageDialog(penjualanView, "Sepertinya anda lupa memasukkan Data Pelanggan");
            return false;
        }else if("".equals(penjualanView.getTextNamaProduk().getText())){
            JOptionPane.showMessageDialog(penjualanView, "Sepertinya anda lupa memasukkan Data Pakaian");
            return false;
        }else if("".equals(penjualanView.getTextJumlahBeli().getText())){
            JOptionPane.showMessageDialog(penjualanView, "Sepertinya anda lupa memasukkan Jumlah Beli");
            return false;
        }
        return true;
    }
    
}
