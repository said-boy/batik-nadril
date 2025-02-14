/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import controller.PelangganController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import main.App;
import model.Pelanggan;

/**
 *
 * @author anzt0
 */
public class PelangganView extends javax.swing.JInternalFrame {

    private final Pelanggan pelanggan;
    private List<Pelanggan> listPelanggan;
    private final PelangganController pelangganController;

    public PelangganView() {
        initComponents();
        pelanggan = new Pelanggan();
        pelangganController = new PelangganController(this);
        pelangganController.enableForm(false);
        refreshTable();
        initListener();
    }

    public List<Pelanggan> getListPelanggan() {
        return listPelanggan;
    }

    public void setListPelanggan(List<Pelanggan> listPelanggan) {
        this.listPelanggan = listPelanggan;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getTabelPelanggan() {
        return tabelPelanggan;
    }

    public void setTabelPelanggan(JTable tabelPelanggan) {
        this.tabelPelanggan = tabelPelanggan;
    }

    public JTextArea getTextAlamat() {
        return textAlamat;
    }

    public void setTextAlamat(JTextArea textAlamat) {
        this.textAlamat = textAlamat;
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

    public JTextField getTextTelepon() {
        return textTelepon;
    }

    public void setTextTelepon(JTextField textTelepon) {
        this.textTelepon = textTelepon;
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
        listPelanggan = App.masterService.getAllPelanggan(); // memanggil interface
        // memasukkan nilai list ke inner class
        tabelPelanggan.setModel(new PelangganTableModel(listPelanggan)); 
    }
    
    private void initListener(){ // memindahkan nilai di tabel ke form
        tabelPelanggan.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            pelangganController.loadData(pelanggan, listPelanggan);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textTelepon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JTextArea();
        tombolBaru = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPelanggan = new javax.swing.JTable();

        setClosable(true);
        setTitle("Form Input Pelanggan");
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

        jLabel1.setText("ID Pelanggan");

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        jLabel4.setText("Telepon");

        textAlamat.setColumns(20);
        textAlamat.setRows(5);
        jScrollPane2.setViewportView(textAlamat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelPelanggan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tombolBaru)
                                .addGap(56, 56, 56)
                                .addComponent(tombolSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tombolUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tombolHapus))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolBaru)
                    .addComponent(tombolSimpan)
                    .addComponent(tombolHapus)
                    .addComponent(tombolUbah))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        App.menuView.pelangganView = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        if (pelangganController.validasiInput()) {
            pelanggan.setKodePelanggan(textId.getText());
            pelanggan.setNamaPelanggan(textNama.getText());
            pelanggan.setAlamatPelanggan(textAlamat.getText());
            pelanggan.setNomor_pelanggan(textTelepon.getText());

            App.masterService.simpanPelanggan(pelanggan);
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBaruActionPerformed
        // TODO add your handling code here:
        pelangganController.clearForm();
        pelangganController.enableForm(true);
        textId.requestFocusInWindow();
    }//GEN-LAST:event_tombolBaruActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        if (pelangganController.validasiInput()) {
            pelanggan.setKodePelanggan(textId.getText());
            int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menghapus data ini?", "Konfirmasi", JOptionPane.WARNING_MESSAGE);
            if(konfirmasi==0){
                App.masterService.hapusPelanggan(pelanggan);
                JOptionPane.showMessageDialog(this, "Pelanggan berhasil dihapus !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            }
            
        }
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        if (pelangganController.validasiInput()) {
            pelanggan.setKodePelanggan(textId.getText());
            pelanggan.setNamaPelanggan(textNama.getText());
            pelanggan.setAlamatPelanggan(textAlamat.getText());
            pelanggan.setNomor_pelanggan(textTelepon.getText());

            App.masterService.ubahPelanggan(pelanggan);
            JOptionPane.showMessageDialog(this, "Pelanggan berhasil diubah !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }//GEN-LAST:event_tombolUbahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelPelanggan;
    private javax.swing.JTextArea textAlamat;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textTelepon;
    private javax.swing.JButton tombolBaru;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
    
    // inner class
    public class PelangganTableModel extends AbstractTableModel {

        private List<Pelanggan> listPelanggan = new ArrayList<>();

        private final String HEADER[] = {"ID Pelanggan", "Nama Pelanggan", "Alamat Pelanggan", "Telepon Pelanggan"};

        public PelangganTableModel(List<Pelanggan> listPelanggan) {
            this.listPelanggan = listPelanggan;
        }

        @Override
        public int getRowCount() { // jumlah baris
            return listPelanggan.size();
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
            Pelanggan s = listPelanggan.get(i); // baris
            switch (i1) { // kolom
                case 0:
                    return s.getKodePelanggan();
                case 1:
                    return s.getNamaPelanggan();
                case 2:
                    return s.getAlamatPelanggan();
                case 3:
                    return s.getNomor_pelanggan();
                default:
                    return null;
            }
        }
    }
}
