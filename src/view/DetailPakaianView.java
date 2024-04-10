/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DetailPakaianController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import main.App;
import model.Ukuran;
import model.DetailPakaian;

/**
 *
 * @author anzt0
 */
public class DetailPakaianView extends javax.swing.JInternalFrame {

    private Ukuran ukuran;
    private DetailPakaian detailPakaian;
    private List<DetailPakaian> listDetailPakaian;
    private DetailPakaianController detailPakaianController;
    
    /**
     * Creates new form ProdukView
     */
    public DetailPakaianView() {
        initComponents();
        detailPakaian = new DetailPakaian();
        ukuran = new Ukuran();
        detailPakaianController = new DetailPakaianController(this);
        detailPakaianController.loadSatuan();
        detailPakaianController.enableForm(false);
        initListener();
        refreshTable();
        
    }

    public DetailPakaian getDetailPakaian() {
        return detailPakaian;
    }

    public void setDetailPakaian(DetailPakaian detailPakaian) {
        this.detailPakaian = detailPakaian;
    }

    public List<DetailPakaian> getListDetailPakaian() {
        return listDetailPakaian;
    }

    public void setListDetailPakaian(List<DetailPakaian> listDetailPakaian) {
        this.listDetailPakaian = listDetailPakaian;
    }

    public DetailPakaianController getDetailPakaianController() {
        return detailPakaianController;
    }

    public void setDetailPakaianController(DetailPakaianController detailPakaianController) {
        this.detailPakaianController = detailPakaianController;
    }

    public JComboBox<String> getComboUkuran() {
        return comboUkuran;
    }

    public void setComboUkuran(JComboBox<String> comboUkuran) {
        this.comboUkuran = comboUkuran;
    }

    public JButton getTombolCari() {
        return tombolCari;
    }

    public void setTombolCari(JButton tombolCari) {
        this.tombolCari = tombolCari;
    }

    public JButton getjButton1() {
        return tombolCari;
    }

    public void setjButton1(JButton jButton1) {
        this.tombolCari = jButton1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
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

    public JTable getTabelProduk() {
        return tabelProduk;
    }

    public void setTabelProduk(JTable tabelProduk) {
        this.tabelProduk = tabelProduk;
    }

    public JTextField getTextJual() {
        return textJual;
    }

    public void setTextJual(JTextField textJual) {
        this.textJual = textJual;
    }

    public JTextField getTextNama() {
        return textNama;
    }

    public void setTextNama(JTextField textNama) {
        this.textNama = textNama;
    }

    public JTextField getTextStok() {
        return textStok;
    }

    public void setTextStok(JTextField textStok) {
        this.textStok = textStok;
    }

    public JTextField getTextWarna() {
        return textWarna;
    }

    public void setTextWarna(JTextField textWarna) {
        this.textWarna = textWarna;
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

    private void refreshTable(){
        listDetailPakaian = App.detailService.getAllDetailPakaian();
        tabelProduk.setModel(new ProdukTableModel(listDetailPakaian));
    }

    private void initListener(){
        tabelProduk.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            detailPakaianController.loadData(detailPakaian, listDetailPakaian);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        comboUkuran = new javax.swing.JComboBox<>();
        textJual = new javax.swing.JTextField();
        textStok = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textWarna = new javax.swing.JTextField();
        tombolCari = new javax.swing.JButton();
        tombolBaru = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelProduk = new javax.swing.JTable();

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

        jLabel2.setText("Nama");

        jLabel4.setText("Warna");

        jLabel5.setText("Harga Jual");

        jLabel6.setText("Stok");

        textJual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textJual.setText("0");

        textStok.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textStok.setText("0");

        jLabel7.setText("Ukuran");

        textWarna.setText("\n\n");

        tombolCari.setText("Cari");
        tombolCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textWarna, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tombolCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textStok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(textJual, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(comboUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolCari))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textWarna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tabelProduk.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelProduk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tombolBaru)
                        .addGap(69, 69, 69)
                        .addComponent(tombolSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolHapus))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
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
                    .addComponent(tombolUbah)
                    .addComponent(tombolHapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        App.menuView.detailPakaianView = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void tombolBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBaruActionPerformed
        detailPakaianController.clearForm();
        detailPakaianController.enableForm(true);
        textNama.requestFocusInWindow();
    }//GEN-LAST:event_tombolBaruActionPerformed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        ukuran = App.masterService.getUkuran(comboUkuran.getSelectedItem().toString());
        detailPakaian.setKodePakaian(App.masterService.getPakaianById(textNama.getText()));
        detailPakaian.setWarnaPakaian(textWarna.getText());
        detailPakaian.setUkuranPakaian(ukuran);
        detailPakaian.setHargaPakaian(Integer.parseInt(textJual.getText()));
        detailPakaian.setStokPakaian(Integer.parseInt(textStok.getText()));
        
        App.detailService.simpanDetailPakaian(detailPakaian);
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        ukuran = App.masterService.getUkuran(comboUkuran.getSelectedItem().toString());
        detailPakaian.setKodePakaian(App.masterService.getPakaianById(textNama.getText()));
        detailPakaian.setWarnaPakaian(textWarna.getText());
        detailPakaian.setUkuranPakaian(ukuran);
        detailPakaian.setHargaPakaian(Integer.parseInt(textJual.getText()));
        detailPakaian.setStokPakaian(Integer.parseInt(textStok.getText()));
        
        App.detailService.ubahDetailPakaian(detailPakaian);
        JOptionPane.showMessageDialog(this, "Pakaian berhasil diubah !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        if (detailPakaianController.validasiInput()) {
            ukuran = App.masterService.getUkuran(comboUkuran.getSelectedItem().toString());
            detailPakaian.setKodePakaian(App.masterService.getPakaianById(textNama.getText()));
            detailPakaian.setWarnaPakaian(textWarna.getText());
            detailPakaian.setUkuranPakaian(ukuran);
            detailPakaian.setHargaPakaian(Integer.parseInt(textJual.getText()));
            detailPakaian.setStokPakaian(Integer.parseInt(textStok.getText()));
            int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menghapus data ini?", "Konfirmasi", JOptionPane.WARNING_MESSAGE);
            if(konfirmasi==0){
                App.detailService.hapusDetailPakaian(detailPakaian);
                JOptionPane.showMessageDialog(this, "Pakaian berhasil dihapus !", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                refreshTable();
            }
            
        }        
        refreshTable();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCariActionPerformed
        detailPakaianController.cariProduk(textNama.getText());
    }//GEN-LAST:event_tombolCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboUkuran;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelProduk;
    private javax.swing.JTextField textJual;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textStok;
    private javax.swing.JTextField textWarna;
    private javax.swing.JButton tombolBaru;
    private javax.swing.JButton tombolCari;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
    
    public class ProdukTableModel extends AbstractTableModel{

        private List<DetailPakaian> listProduk = new ArrayList<>();
        private final String HEADER[] = {"Kode Pakaian", "Nama Pakaian", "Warna", "Ukuran", "Harga", "Stok"};

        public ProdukTableModel(List<DetailPakaian> listProduk) {
            this.listProduk = listProduk;
        }
        
        @Override
        public int getRowCount() {
            return listProduk.size();
        }

        @Override
        public int getColumnCount() {
            return HEADER.length;
        }

        @Override
        public String getColumnName(int i) {
            return HEADER[i];
        }

        @Override
        public Object getValueAt(int i, int i1) {
            DetailPakaian p = listProduk.get(i);
            switch(i1){
                case 0:
                    return p.getKodePakaian().getKodePakaian();
                case 1:
                    return p.getKodePakaian().getNamaPakaian();
                case 2:
                    return p.getWarnaPakaian();
                case 3:
                    return p.getUkuranPakaian().getUkuran();
                case 4:
                    return p.getHargaPakaian();
                case 5:
                    return p.getStokPakaian();
                default:
                    return null;
            }
        }
        
    }
}
