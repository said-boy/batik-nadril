/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Ukuran;
import view.UkuranView;

/**
 *
 * @author anzt0
 */
public class UkuranController {
    
    private final UkuranView ukuranView;
    
    public UkuranController(UkuranView ukuranView) {
        this.ukuranView = ukuranView;
    }
    
    public void clearForm(){
        ukuranView.getTextUkuran().setText(null);
        ukuranView.getTabelJenis().clearSelection();
    }
    
    public void enableForm(boolean kondisi){
        ukuranView.getTextUkuran().setEnabled(kondisi);
        ukuranView.getTombolSimpan().setEnabled(kondisi);
        ukuranView.getTombolHapus().setEnabled(!kondisi);
    }
    
    public boolean validasiInput(){
        if(ukuranView.getTextUkuran().getText().equals("")){
            JOptionPane.showMessageDialog(ukuranView, "Ukuran harus di isi !", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
    
    public void loadData(Ukuran ukuran, List<Ukuran> list){
        if(ukuranView.getTabelJenis().getSelectedRow() >= 0){
            int row = ukuranView.getTabelJenis().getSelectedRow();
            ukuran = list.get(row);
            ukuranView.getTextUkuran().setText(ukuran.getUkuran());
            enableForm(false);
            ukuranView.getTextNama().setEnabled(true);
        }else{
            
        }
    }
} 
