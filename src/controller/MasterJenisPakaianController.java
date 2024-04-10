/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.MasterJenisPakaian;
import view.JenisView;

/**
 *
 * @author anzt0
 */
public class MasterJenisPakaianController {
    
    private final JenisView jenisView;
    
    public MasterJenisPakaianController(JenisView jenisView) {
        this.jenisView = jenisView;
    }
    
    public void clearForm(){
        jenisView.getTextId().setText(null);
        jenisView.getTextNama().setText(null);
        jenisView.getTabelJenis().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        jenisView.getTextId().setEnabled(kondisi);
        jenisView.getTextNama().setEnabled(kondisi);
        jenisView.getTombolSimpan().setEnabled(kondisi);
        jenisView.getTombolUbah().setEnabled(!kondisi);
        jenisView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(jenisView.getTextId().getText().equals("")){
            JOptionPane.showMessageDialog(jenisView, "ID harus di isi !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
    
    public void loadData(MasterJenisPakaian masterJenisPakaian, List<MasterJenisPakaian> list){
        if(jenisView.getTabelJenis().getSelectedRow() >= 0){
            int row = jenisView.getTabelJenis().getSelectedRow();
            masterJenisPakaian = list.get(row);
            jenisView.getTextId().setText(masterJenisPakaian.getIdJenis());
            jenisView.getTextNama().setText(masterJenisPakaian.getJenis_pakaian());
            enableForm(false);
            jenisView.getTextNama().setEnabled(true);
        }else{
            
        }
    }
} 
