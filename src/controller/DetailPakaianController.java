/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import main.App;
import view.DetailPakaianView;
import model.DetailPakaian;
import model.Pakaian;
import view.CariDialogView;
import view.PakaianView;

/**
 *
 * @author user_
 */
public class DetailPakaianController {
    private DetailPakaianView detailPakaianView;
    private List<Pakaian> listProduk;
    
    public DetailPakaianController(DetailPakaianView detaildetailPakaianView) {
        this.detailPakaianView = detaildetailPakaianView;
    }
    
    public void clearForm(){
        detailPakaianView.getTextNama().setText(null);
        detailPakaianView.getTextWarna().setText(null);
        detailPakaianView.getTextJual().setText(null);
        detailPakaianView.getTextStok().setText(null);
        detailPakaianView.getTabelProduk().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        detailPakaianView.getTextNama().setEnabled(kondisi);
        detailPakaianView.getTextWarna().setEnabled(kondisi);
        detailPakaianView.getComboUkuran().setEnabled(kondisi);
        detailPakaianView.getTextJual().setEnabled(kondisi);
        detailPakaianView.getTextStok().setEnabled(kondisi);
        detailPakaianView.getTombolSimpan().setEnabled(kondisi);
        detailPakaianView.getTombolCari().setEnabled(kondisi);
        detailPakaianView.getTombolUbah().setEnabled(!kondisi);
        detailPakaianView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(detailPakaianView.getTextNama().getText().equals("")){
            JOptionPane.showMessageDialog(detailPakaianView, "Baju harus di isi !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }

    public void loadSatuan(){
        ComboBoxModel cbm = new DefaultComboBoxModel(App.masterService.getAllUkuran());
        detailPakaianView.getComboUkuran().setModel(cbm);
    }
    
    public void loadData(DetailPakaian pakaian, List<DetailPakaian> list){
        if(detailPakaianView.getTabelProduk().getSelectedRow() >= 0){
            int row = detailPakaianView.getTabelProduk().getSelectedRow();
            pakaian = list.get(row);
            detailPakaianView.getTextNama().setText(pakaian.getKodePakaian().getKodePakaian());
            detailPakaianView.getTextWarna().setText(pakaian.getWarnaPakaian());
            detailPakaianView.getComboUkuran().setSelectedItem(pakaian.getUkuranPakaian().getUkuran());
            detailPakaianView.getTextJual().setText(String.valueOf(pakaian.getHargaPakaian()));
            detailPakaianView.getTextStok().setText(String.valueOf(pakaian.getStokPakaian()));
            enableForm(false);
            detailPakaianView.getTextWarna().setEnabled(true);
            detailPakaianView.getTextJual().setEnabled(true);
            detailPakaianView.getTextStok().setEnabled(true);
        }else{
            
        }
    }

    public void cariProduk(String nama){
        CariDialogView cariDialog = new CariDialogView(App.menuView, true);
        listProduk = App.masterService.findPakaianByName(nama);
        PakaianView pv = new PakaianView();
        PakaianView.PakaianTableModel produkTabelModel = pv.new PakaianTableModel(listProduk);
        cariDialog.getTabelCari().setModel(produkTabelModel);
        
        PakaianController pc = new PakaianController(pv);
        cariDialog.getTabelCari().getSelectionModel().addListSelectionListener((lse) -> {
            if(cariDialog.getTabelCari().getSelectedRow()>=0){
                int row = cariDialog.getTabelCari().getSelectedRow();
                Pakaian pakaian = listProduk.get(row);
                detailPakaianView.getTextNama().setText(pakaian.getKodePakaian());
            }
        });
        cariDialog.setVisible(true);
    }

}
