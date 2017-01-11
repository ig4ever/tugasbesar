/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.perhotelan.daoimpl;

import id.ac.unikom.adsi.perhotelan.dao.RuanganDAO;
import id.ac.unikom.adsi.perhotelan.entitiy.Ruangan;
import id.ac.unikom.adsi.perhotelan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class RuanganDAOImpl implements RuanganDAO{

    private final Connection conn;

    public RuanganDAOImpl(){
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Ruangan> getRuangan() {
        return getRuangan(null);
    }

    @Override
    public ArrayList<Ruangan> getRuangan(String tipeRuangan) {
        ArrayList<Ruangan> arrayRuangan = null;
        PreparedStatement state = null;

        boolean isSearching = tipeRuangan != null && !tipeRuangan.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT tipe_ruangan, kapasitas, harga, keterangan FROM ruangan WHERE tipe_ruangan LIKE ? ";
        } else {
            SELECT = "SELECT tipe_ruangan, kapasitas, harga, keterangan FROM ruangan ";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, tipeRuangan + "%");
            }

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayRuangan = new ArrayList<>();

                while (result.next()) {
                    Ruangan a = new Ruangan();
                    a.setTipeRuangan(result.getString(1));
                    a.setKapasitas(result.getInt(2));
                    a.setHarga(result.getFloat(3));
                    a.setKeterangan(result.getString(4));
                    arrayRuangan.add(a);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayRuangan;
    }
}
