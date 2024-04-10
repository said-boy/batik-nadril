/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import config.Koneksi;
import controller.LoginController;
import controller.PelangganController;
import controller.PenjualanController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import main.App;
import model.Penjualan;
import model.DetailPenjualan;
import model.DetailPakaian;


/**
 *
 * @author anzt0
 */
public class PenjualanView extends javax.swing.JInternalFrame {

    private final Penjualan penjualan;
    private final PenjualanController penjualanController;
    private List<DetailPenjualan> listDetailPenjualan;
    private List<DetailPakaian> listDetailPakaian;
    /**
     * Creates new form PenjualanView
     */
    public PenjualanView() {
        initComponents();
        
        penjualan = new Penjualan();
        penjualanController = new PenjualanController(this);
        penjualanController.generateKodeTransaksi();
        listDetailPenjualan = new ArrayList<>();
        listDetailPakaian = new ArrayList<>();
        refreshTable();
    }

    public List<DetailPenjualan> getListDetailPenjualan() {
        return listDetailPenjualan;
    }

    public void setListDetailPenjualan(List<DetailPenjualan> listDetailPenjualan) {
        this.listDetailPenjualan = listDetailPenjualan;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
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

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTabelPenjualan() {
        return tabelPenjualan;
    }

    public void setTabelPenjualan(JTable tabelPenjualan) {
        this.tabelPenjualan = tabelPenjualan;
    }

    public JDateChooser getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(JDateChooser tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public JTextField getTextHarga() {
        return textHarga;
    }

    public void setTextHarga(JTextField textHarga) {
        this.textHarga = textHarga;
    }

    public JTextField getTextIdPenjualan() {
        return textIdPenjualan;
    }

    public void setTextIdPenjualan(JTextField textIdPenjualan) {
        this.textIdPenjualan = textIdPenjualan;
    }

    public JTextField getTextJumlahBeli() {
        return textJumlahBeli;
    }

    public void setTextJumlahBeli(JTextField textJumlahBeli) {
        this.textJumlahBeli = textJumlahBeli;
    }

    public JTextField getTextNamaPakaian() {
        return textNamaPakaian;
    }

    public void setTextNamaPakaian(JTextField textNamaPakaian) {
        this.textNamaPakaian = textNamaPakaian;
    }

    public JTextField getTextNamaProduk() {
        return textNamaProduk;
    }

    public void setTextNamaProduk(JTextField textNamaProduk) {
        this.textNamaProduk = textNamaProduk;
    }

    public JTextField getTextPelanggan() {
        return textPelanggan;
    }

    public void setTextPelanggan(JTextField textPelanggan) {
        this.textPelanggan = textPelanggan;
    }

    public JTextField getTextTotal() {
        return textTotal;
    }

    public void setTextTotal(JTextField textTotal) {
        this.textTotal = textTotal;
    }

    public JTextField getTextUkuran() {
        return textUkuran;
    }

    public void setTextUkuran(JTextField textUkuran) {
        this.textUkuran = textUkuran;
    }

    public JTextField getTextwarnaPakaian() {
        return textwarnaPakaian;
    }

    public void setTextwarnaPakaian(JTextField textwarnaPakaian) {
        this.textwarnaPakaian = textwarnaPakaian;
    }

    public JButton getTombolCari() {
        return tombolCari;
    }

    public void setTombolCari(JButton tombolCari) {
        this.tombolCari = tombolCari;
    }

    public JButton getTombolCariPelanggan() {
        return tombolCariPelanggan;
    }

    public void setTombolCariPelanggan(JButton tombolCariPelanggan) {
        this.tombolCariPelanggan = tombolCariPelanggan;
    }

    public JButton getTombolCetakNota() {
        return tombolCetakNota;
    }

    public void setTombolCetakNota(JButton tombolCetakNota) {
        this.tombolCetakNota = tombolCetakNota;
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

    public JButton getTombolTambah() {
        return tombolTambah;
    }

    public void setTombolTambah(JButton tombolTambah) {
        this.tombolTambah = tombolTambah;
    }

    public void refreshTable(){
        tabelPenjualan.setModel(new PenjualanTableModel(listDetailPenjualan, listDetailPakaian));
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
        textIdPenjualan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tanggalTransaksi = new com.toedter.calendar.JDateChooser();
        tombolSimpan = new javax.swing.JButton();
        textTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textNamaProduk = new javax.swing.JTextField();
        tombolCari = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textJumlahBeli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textPelanggan = new javax.swing.JTextField();
        tombolCariPelanggan = new javax.swing.JButton();
        textJenis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textNamaPakaian = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textHarga = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textwarnaPakaian = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textUkuran = new javax.swing.JTextField();
        tombolTambah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPenjualan = new javax.swing.JTable();
        tombolCetakNota = new javax.swing.JButton();

        setClosable(true);
        setTitle("Penjualan");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("ID Penjualan");

        textIdPenjualan.setFocusable(false);

        jLabel2.setText("Tanggal Transaksi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(textIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(tanggalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(textIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(tanggalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tombolSimpan.setText("Simpan Transaksi");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        textTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTotal.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total Transaksi");

        jLabel5.setText("Kode Pakaian");

        tombolCari.setText("Cari");
        tombolCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCariActionPerformed(evt);
            }
        });

        jLabel4.setText("Jumlah Beli");

        textJumlahBeli.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setText("Pelanggan");

        tombolCariPelanggan.setText("Cari");
        tombolCariPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCariPelangganActionPerformed(evt);
            }
        });

        textJenis.setEditable(false);

        jLabel7.setText("Ukuran");

        textNamaPakaian.setEditable(false);

        jLabel8.setText("Nama Pakaian");

        jLabel9.setText("Harga Jual");

        textHarga.setEditable(false);
        textHarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel10.setText("Warna");

        textwarnaPakaian.setEditable(false);

        jLabel11.setText("Jenis");

        textUkuran.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textPelanggan)
                                    .addComponent(textNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tombolCari)
                                    .addComponent(tombolCariPelanggan))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textJumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNamaPakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textwarnaPakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(404, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolCariPelanggan)
                    .addComponent(jLabel9)
                    .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolCari)
                    .addComponent(jLabel4)
                    .addComponent(textJumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNamaPakaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textwarnaPakaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(23, 23, 23))
        );

        tombolTambah.setText("Tambah Produk");
        tombolTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTambahActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus Produk");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tabelPenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelPenjualan);

        tombolCetakNota.setText("Cetak Nota");
        tombolCetakNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCetakNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tombolCetakNota, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                .addGap(62, 62, 62)
                                .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tombolTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolHapus)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolTambah)
                    .addComponent(tombolHapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tombolSimpan)
                    .addComponent(tombolCetakNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        App.menuView.penjualanView = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
            penjualan.setKodeTransaksi(textIdPenjualan.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
            String time = sdfTime.format(new Date());
            penjualan.setTanggal(sdf.format(tanggalTransaksi.getDate())+" "+time);
            penjualan.setKodePelanggan(App.masterService.getPelangganByName(textPelanggan.getText()));
            penjualan.setKodeAdmin(App.masterService.getAdminByKode(LoginController.id_admin));
            App.transaksiService.simpanPenjualan(penjualan);

            for (DetailPenjualan detailPenjualan : listDetailPenjualan) {
                DetailPenjualan dp = new DetailPenjualan();
                dp.setKodePenjualan(penjualan);
                dp.setKodePakaian(detailPenjualan.getKodePakaian());
                dp.setUkuran(detailPenjualan.getUkuran());
                dp.setQty(detailPenjualan.getQty());
                dp.setSubTotal(detailPenjualan.getSubTotal());
                App.transaksiService.simpanDetailPenjualan(dp);
            }
            penjualanController.clearForm();
            listDetailPenjualan = new ArrayList<>();
            refreshTable();
            JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!");
            penjualanController.generateKodeTransaksi();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolTambahActionPerformed
        // TODO add your handling code here:
        if(penjualanController.validasiInput()){
            penjualanController.tambahProduk(listDetailPenjualan);
            refreshTable();
        }        
    }//GEN-LAST:event_tombolTambahActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        penjualanController.deleteItem(listDetailPenjualan);
        refreshTable();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolCetakNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCetakNotaActionPerformed
        try{
            penjualanController.cetakNota();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tombolCetakNotaActionPerformed

    private void tombolCariPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCariPelangganActionPerformed
        penjualanController.cariPelanggan(textPelanggan.getText());
    }//GEN-LAST:event_tombolCariPelangganActionPerformed

    private void tombolCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCariActionPerformed
        // TODO add your handling code here:
        penjualanController.cariProduk(textNamaProduk.getText());
    }//GEN-LAST:event_tombolCariActionPerformed

    public JTextField getTextJenis() {
        return textJenis;
    }

    public void setTextJenis(JTextField textJenis) {
        this.textJenis = textJenis;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPenjualan;
    private com.toedter.calendar.JDateChooser tanggalTransaksi;
    private javax.swing.JTextField textHarga;
    private javax.swing.JTextField textIdPenjualan;
    private javax.swing.JTextField textJenis;
    private javax.swing.JTextField textJumlahBeli;
    private javax.swing.JTextField textNamaPakaian;
    private javax.swing.JTextField textNamaProduk;
    private javax.swing.JTextField textPelanggan;
    private javax.swing.JTextField textTotal;
    private javax.swing.JTextField textUkuran;
    private javax.swing.JTextField textwarnaPakaian;
    private javax.swing.JButton tombolCari;
    private javax.swing.JButton tombolCariPelanggan;
    private javax.swing.JButton tombolCetakNota;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolTambah;
    // End of variables declaration//GEN-END:variables
    
    public class PenjualanTableModel extends AbstractTableModel{

        private List<DetailPenjualan> listDetailPenjualan = new ArrayList<>();
        private List<DetailPakaian> listDetailPakaian = new ArrayList<>();

        private final String HEADER[] = {"NAMA", "JENIS", "UKURAN", "WARNA", "QTY", "HARGA", "JUMLAH"};

        public PenjualanTableModel(List<DetailPenjualan> listDetailPenjualan, List<DetailPakaian> listDetailPakaian) {
            this.listDetailPenjualan = listDetailPenjualan;
        }
        
        @Override
        public int getRowCount() {
            return listDetailPenjualan.size();
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
            DetailPenjualan detail = listDetailPenjualan.get(i);
            switch(i1){
                case 0:
                    return detail.getKodePakaian().getNamaPakaian();
                case 1:
                    return detail.getKodePakaian().getIdJenis().getJenis_pakaian();
                case 2:
                    return detail.getUkuran();
                case 3:
                    return App.detailService.getDetailByKodeAndByUkuran(detail.getKodePakaian().getKodePakaian(), detail.getUkuran()).getWarnaPakaian();
                case 4:
                    return detail.getQty();
                case 5:
                    return App.detailService.getDetailByKodeAndByUkuran(detail.getKodePakaian().getKodePakaian(), detail.getUkuran()).getHargaPakaian();
                case 6:
                    return detail.getSubTotal();
                default:
                    return "";
            }
        }
        
    }
}
