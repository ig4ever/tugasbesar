/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.perhotelan.daoimpl;

import id.ac.unikom.adsi.perhotelan.dao.PegawaiDAO;
import id.ac.unikom.adsi.perhotelan.entitiy.Pegawai;
import id.ac.unikom.adsi.perhotelan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PegawaiDAOImpl implements PegawaiDAO {
    
    private final Connection conn;
    
    public PegawaiDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }
    
    @Override
    public ArrayList<Pegawai> getPegawai() {
        return getPegawai(null);
    }
    
    @Override
    public ArrayList<Pegawai> getPegawai(String namaPegawai) {
        ArrayList<Pegawai> arrayPegawai = null;
        PreparedStatement state = null;
        
        boolean isSearching = namaPegawai != null && !namaPegawai.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT p.nip, p.nama_pegawai, l.jabatan, p.noTelp FROM pegawai p "
                    +" INNER JOIN login l ON p.login_id = l.login_id "
                    +" WHERE nama_pegawai LIKE ?";
        } else {
            SELECT = "SELECT p.nip, p.nama_pegawai, l.jabatan, p.noTelp FROM pegawai p "
                    +" INNER JOIN login l ON p.login_id = l.login_id ";
        }
        
        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, namaPegawai + "%");
            }
            
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPegawai = new ArrayList<>();
                
                while (result.next()) {
                    Pegawai a = new Pegawai();
                    a.setNip(result.getInt(1));
                    a.setNamaPegawai(result.getString(2));
                    a.setJabatan(result.getString(3));
                    a.setNoTelp(result.getString(4));
                    arrayPegawai.add(a);
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
        return arrayPegawai;
    }
    
    @Override
    public Pegawai login(String userName, String password, String jabatan) {
        Pegawai pegawai = null;
        PreparedStatement state = null;
        
        String SELECT = "SELECT p.nip, p.nama_pegawai, l.jabatan, p.noTelp FROM login l " 
                + "INNER JOIN pegawai p ON l.login_id = p.login_id "
                + "WHERE l.login_username = ? AND l.login_password = ? AND l.jabatan = ?";

        try {
            state = conn.prepareStatement(SELECT);
            state.setString(1, userName);
            state.setString(2, password);
            state.setString(3, jabatan);
            
            ResultSet result = state.executeQuery();
            if (result != null && result.next()) {
                pegawai = new Pegawai();
                pegawai.setNip(result.getInt(1));
                pegawai.setNamaPegawai(result.getString(2));
                pegawai.setJabatan(result.getString(3));
                pegawai.setNoTelp(result.getString(4));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pegawai;
    }
}
