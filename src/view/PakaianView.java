/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PakaianController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import main.App;
import model.MasterJenisPakaian;
import model.Pakaian;

/**
 *
 * @author anzt0
 */
public class PakaianView extends javax.swing.JInternalFrame {

    private final Pakaian Pakaian;
    private List<Pakaian> listPakaian;
    private final PakaianController PakaianController;

    /**
     * Creates new form PakaianView
     */
    public PakaianView() {
        initComponents();
        Pakaian = new Pakaian();
        PakaianController = new PakaianController(this);
        PakaianController.loadSatuan();
        PakaianController.enableForm(false);
        refreshTable();
        initListener();
    }

    public JComboBox<String> getComboJenisPakaian() {
        return comboJenisPakaian;
    }

    public void setComboJenisPakaian(JComboBox<String> comboJenisPakaian) {
        this.comboJenisPakaian = comboJenisPakaian;
    }

    public JTable getTabelPakaian() {
        return tabelPakaian;
    }

    public void setTabelPakaian(JTable tabelPakaian) {
        this.tabelPakaian = tabelPakaian;
    }

    public JTable getTabelJenis() {
        return tabelPakaian;
    }

    public void setTabelJenis(JTable tabelJenis) {
        this.tabelPakaian = tabelJenis;
    }

    public JTextField getTextId() {
        return textId;
    }

    public void setTextId(JTextField textId) {
        this.textId = textId;
    }

    public JTextField getTextNama() {
        return textNama;
    }

    public void setTextNama(JTextField textNama) {
        this.textNama = textNama;
    }

    public JButton getTombolBaru() {
        return tombolBaru;
    }

    public void setTombolBaru(JButton tombolBaru) {
        this.tombolBaru = tombolBaru;
    }

    public JButton getTombolHapus() {
        return tombolHapus;
    }

    public void setTombolHapus(JButton tombolHapus) {
        this.tombolHapus = tombolHapus;
    }

    public JButton getTombolSimpan() {
        return tombolSimpan;
    }

    public void setTombolSimpan(JButton tombolSimpan) {
        this.tombolSimpan = tombolSimpan;
    }

    public JButton getTombolUbah() {
        return tombolUbah;
    }

    public void setTombolUbah(JButton tombolUbah) {
        this.tombolUbah = tombolUbah;
    }
    
    private void refreshTable() {
        listPakaian = App.masterService.getAllPakaian(); // memanggil interface
        // memasukkan nilai list ke inner class
        tabelPakaian.setModel(new PakaianTableModel(listPakaian)); 
    }
    
    private void initListener(){ // memindahkan nilai di tabel ke form
        tabelPakaian.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            PakaianController.loadData(Pakaian, listPakaian);
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        textNama = new javax.swing.JTextField();
        comboJenisPakaian = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tombolBaru = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPakaian = new javax.swing.JTable();

        setClosable(true);
        setTitle("Form Input Pakaian");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("ID Pakaian");

        jLabel2.setText("Nama Pakaian");

        jLabel3.setText("Jenis Pakaian");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboJenisPakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboJenisPakaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tombolBaru.setText("Baru");
        tombolBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBaruActionPerformed(evt);
            }
        });

        tombolSimpan.setText("Simpan");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tabelPakaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelPakaian);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tombolBaru)
                                .addGap(56, 56, 56)
                                .addComponent(tombolSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tombolUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tombolHapus))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolBaru)
                    .addComponent(tombolSimpan)
                    .addComponent(tombolHapus)
                    .addComponent(tombolUbah))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        App.menuView.pakaianView = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        if (PakaianController.validasiInput()) {
            Pakaian.setKodePakaian(textId.getText());
            Pakaian.setNamaPakaian(textNama.getText());
            Pakaian.setIdJenis(App.masterService.getByNameMasterJenisPakaian(comboJenisPakaian.getSelectedItem().toString()));

            App.masterService.simpanPakaian(Pakaian);
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBaruActionPerformed
        // TODO add your handling code here:
        PakaianController.clearForm();
        PakaianController.enableForm(true);
        textId.requestFocusInWindow();
    }//GEN-LAST:event_tombolBaruActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        if (PakaianController.validasiInput()) {
            Pakaian.setKodePakaian(textId.getText());
            int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menghapus data ini?", "Konfirmasi", JOptionPane.WARNING_MESSAGE);
            if(konfirmasi==0){
                App.masterService.hapusPakaian(Pakaian);
                JOptionPane.showMessageDialog(this, "Jenis Pakaian berhasil dihapus !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            }
            
        }
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        if (PakaianController.validasiInput()) {
            Pakaian.setKodePakaian(textId.getText());
            Pakaian.setNamaPakaian(textNama.getText());
            Pakaian.setIdJenis(App.masterService.getByNameMasterJenisPakaian(comboJenisPakaian.getSelectedItem().toString()));

            App.masterService.ubahPakaian(Pakaian);
            JOptionPane.showMessageDialog(this, "Jenis Pakaian berhasil diubah !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }//GEN-LAST:event_tombolUbahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboJenisPakaian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPakaian;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNama;
    private javax.swing.JButton tombolBaru;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
    
    // inner class
    public class PakaianTableModel extends AbstractTableModel {

        private List<Pakaian> listPakaian = new ArrayList<>();

        private final String HEADER[] = {"ID Pakaian", "Nama Pakaian", "Jenis Pakaian"};

        public PakaianTableModel(List<Pakaian> listPakaian) {
            this.listPakaian = listPakaian;
        }

        @Override
        public int getRowCount() { // jumlah baris
            return listPakaian.size();
        }

        @Override
        public int getColumnCount() { // jumlah kolom
            return HEADER.length;
        }

        @Override
        public String getColumnName(int i) { // nama kolom
            return HEADER[i];
        }

        @Override
        public Object getValueAt(int i, int i1) { // mengisi data
            Pakaian s = listPakaian.get(i); // baris
            switch (i1) { // kolom
                case 0:
                    return s.getKodePakaian();
                case 1:
                    return s.getNamaPakaian();
                case 2:
                    return s.getIdJenis().getJenis_pakaian();
                default:
                    return null;
            }
        }
    }
}
