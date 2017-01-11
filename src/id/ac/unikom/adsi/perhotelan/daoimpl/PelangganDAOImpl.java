package id.ac.unikom.adsi.perhotelan.daoimpl;

import id.ac.unikom.adsi.perhotelan.dao.PelangganDAO;
import id.ac.unikom.adsi.perhotelan.entitiy.Pelanggan;
import id.ac.unikom.adsi.perhotelan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PelangganDAOImpl implements PelangganDAO {

    private final Connection conn;

    public PelangganDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Pelanggan> getPelanggan() {
        return getPelanggan(null);
    }

    @Override
    public ArrayList<Pelanggan> getPelanggan(String nama) {

        ArrayList<Pelanggan> arrayPelanggan = null;
        PreparedStatement state = null;

        boolean isSearching = nama != null && !nama.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM anggota WHERE nama LIKE ?";
        } else {
            SELECT = "SELECT * FROM anggota";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, nama + "%");
            }

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPelanggan = new ArrayList<>();

                while (result.next()) {
                    Pelanggan a = new Pelanggan();
                    a.setnamaPelanggan(result.getString(1));
                    a.setAlamat(result.getString(2));
                    a.setNoTelp(result.getInt(3));

                    arrayPelanggan.add(a);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(PelangganDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PelangganDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPelanggan;
    }

}
