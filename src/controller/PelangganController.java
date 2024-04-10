/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import main.App;
import model.Pelanggan;
import view.CariDialogView;
import view.PelangganView;
import view.PenjualanView;

/**
 *
 * @author user_
 */
public class PelangganController {

    private final PelangganView pelangganView;
    private PenjualanView penjualanView;
    private List<Pelanggan> listPelanggan;

    public PelangganController(PelangganView pelangganView) {
        this.pelangganView = pelangganView;
    }
    
    public void clearForm(){
        pelangganView.getTextId().setText(null);
        pelangganView.getTextNama().setText(null);
        pelangganView.getTextAlamat().setText(null);
        pelangganView.getTextTelepon().setText(null);
        pelangganView.getTabelPelanggan().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        pelangganView.getTextId().setEnabled(kondisi);
        pelangganView.getTextNama().setEnabled(kondisi);
        pelangganView.getTextAlamat().setEnabled(kondisi);
        pelangganView.getTextTelepon().setEnabled(kondisi);
        pelangganView.getTombolSimpan().setEnabled(kondisi);
        pelangganView.getTombolUbah().setEnabled(!kondisi);
        pelangganView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(pelangganView.getTextId().getText().equals("")){
            JOptionPane.showMessageDialog(pelangganView, "ID harus di isi !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }

    public void loadData(Pelanggan pelanggan, List<Pelanggan> list){
        if(pelangganView.getTabelPelanggan().getSelectedRow() >= 0){
            int row = pelangganView.getTabelPelanggan().getSelectedRow();
            pelanggan = list.get(row);
            pelangganView.getTextId().setText(pelanggan.getKodePelanggan());
            pelangganView.getTextNama().setText(pelanggan.getNamaPelanggan());
            pelangganView.getTextAlamat().setText(pelanggan.getAlamatPelanggan());
            pelangganView.getTextTelepon().setText(pelanggan.getNomor_pelanggan());
            enableForm(false);
            pelangganView.getTextNama().setEnabled(true);
            pelangganView.getTextAlamat().setEnabled(true);
            pelangganView.getTextTelepon().setEnabled(true);
        }else{
            
        }
    }

    public void cariProduk(String nama){
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
                penjualanView.getTextPelanggan().setText(pelanggan.getNamaPelanggan());
            }
        });
        cariDialog.setVisible(true);
    }

}
