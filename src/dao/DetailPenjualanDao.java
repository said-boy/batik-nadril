/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DetailPenjualan;


public class DetailPenjualanDao {
    private Connection connection;

    private PreparedStatement simpanStatement;
    
    private final String queryInsert = "INSERT INTO detail_penjualan (kode_penjualan, kode_pakaian, ukuran, qty, sub_total) VALUES (?,?,?,?,?)";
    
    public void setConnection(Connection connection) throws SQLException{
        this.connection = connection;

        simpanStatement = connection.prepareStatement(queryInsert);
    }
    
    public DetailPenjualan simpan(DetailPenjualan p) throws SQLException{
        simpanStatement.setString(1, p.getKodePenjualan().getKodeTransaksi());
        simpanStatement.setString(2, p.getKodePakaian().getKodePakaian());
        simpanStatement.setString(3, p.getUkuran());
        simpanStatement.setInt(4, p.getQty());
        simpanStatement.setInt(5, p.getSubTotal());
        simpanStatement.executeUpdate();
        return p;
    }
}
