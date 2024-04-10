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
import view.PakaianView;
import model.Pakaian;

/**
 *
 * @author user_
 */
public class PakaianController {
    private PakaianView pakaianView;
    
    public PakaianController(PakaianView pakaianView) {
        this.pakaianView = pakaianView;
    }
    
    public void clearForm(){
        pakaianView.getTextId().setText(null);
        pakaianView.getTextNama().setText(null);
        pakaianView.getTabelJenis().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        pakaianView.getTextId().setEnabled(kondisi);
        pakaianView.getTextNama().setEnabled(kondisi);
        pakaianView.getTombolSimpan().setEnabled(kondisi);
        pakaianView.getTombolUbah().setEnabled(!kondisi);
        pakaianView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(pakaianView.getTextId().getText().equals("")){
            JOptionPane.showMessageDialog(pakaianView, "ID harus di isi !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }

    public void loadSatuan(){
        ComboBoxModel cbm = new DefaultComboBoxModel(App.masterService.getAllNameMasterJenisPakaian());
        pakaianView.getComboJenisPakaian().setModel(cbm);
    }
    
    public void loadData(Pakaian pakaian, List<Pakaian> list){
        if(pakaianView.getTabelPakaian().getSelectedRow() >= 0){
            int row = pakaianView.getTabelPakaian().getSelectedRow();
            pakaian = list.get(row);
            pakaianView.getTextId().setText(pakaian.getKodePakaian());
            pakaianView.getTextNama().setText(pakaian.getNamaPakaian());
            pakaianView.getComboJenisPakaian().setSelectedItem(pakaian.getIdJenis().getJenis_pakaian());
            enableForm(false);
            pakaianView.getTextNama().setEnabled(true);
        }else{
            
        }
    }
}
