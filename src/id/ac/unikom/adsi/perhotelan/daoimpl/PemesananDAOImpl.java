package id.ac.unikom.adsi.perhotelan.daoimpl;

import id.ac.unikom.adsi.perhotelan.dao.PemesananDAO;
import id.ac.unikom.adsi.perhotelan.entitiy.Pemesanan;
import id.ac.unikom.adsi.perhotelan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PemesananDAOImpl implements PemesananDAO {

    private final Connection conn;

    public PemesananDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Pemesanan> getPemesanan(String company) {
        boolean isSearching = company != null && !company.isEmpty();
        String SELECT;
        ArrayList<Pemesanan> arrayPemesanan = null;
        if(isSearching){
         SELECT = "SELECT "
                + "p.nama_pelanggan, "
                + "p.alamat, "
                + "o.beginning_time, "
                + "o.ending_time, "
                + "r.tipe_ruangan, "
                + "p.noTelp "
                + "FROM pelanggan p INNER JOIN pemesanan o ON p.idPelanggan = o.idPelanggan "
                + "INNER JOIN ruangan r ON o.idRuangan = r.idRuangan "
                + "nama_pelanggan LIKE ? ";
        }else{
            SELECT = "SELECT "
                + "p.nama_pelanggan, "
                + "p.alamat, "
                + "o.beginning_time, "
                + "o.ending_time, "
                + "r.tipe_ruangan, "
                + "r.harga, "
                + "p.noTelp "
                + "FROM pelanggan p INNER JOIN pemesanan o ON p.idPelanggan = o.idPelanggan "
                + "INNER JOIN ruangan r ON o.idRuangan = r.idRuangan "
                + "ORDER BY o.beginning_time DESC ";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                    state.setString(1, company + "%");
                }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();
                
                while (result.next()) {
                    Pemesanan p = new Pemesanan();
                    p.setCompany(result.getString(1));
                    p.setAlamat(result.getString(2));
                    p.setBeginning_time(result.getDate(3));
                    p.setEnding_time(result.getDate(4));
                    p.setTipeRuangan(result.getString(5));
                    p.setHarga(result.getFloat(6));
                    p.setNoTelp(result.getInt(7));

                    arrayPemesanan.add(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return arrayPemesanan;
    }

    @Override
    public boolean pesanan(String nama, String alamat, int noTelp, Calendar begin, Calendar end) {
        String INSERT = "INSERT INTO pemesanan "
                + "(beginning_time,ending_time) "
                + "VALUES (?, ?)";
        
        String INSERT2 = "INSERT INTO pelanggan "
                + "(nama_pelanggan,alamat,noTelp) "
                + "VALUES (?, ?, ?)";
        
        PreparedStatement state = null;
        PreparedStatement state2 = null;

        try {
            state = conn.prepareStatement(INSERT);
            state2 = conn.prepareStatement(INSERT2);
            state.setDate(1, new Date(begin.getTimeInMillis()));
            state.setDate(2, new Date(end.getTimeInMillis()));
            state2.setString(1, nama);
            state2.setString(2, alamat);
            state2.setInt(3, noTelp);
            
            int result = state.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }

    @Override
    public boolean end(int kdPesanan, Calendar end) {

        String UPDATE = "UPDATE peminjaman "
                + "SET tgl_kem = ?, harga = ? "
                + "WHERE id_pin = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setDate(1, new Date(end.getTimeInMillis()));
            //state.setFloat(2, harga);
            state.setInt(3, kdPesanan);

            int result = state.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }

    @Override
    public int getIdPemesanan() {
        int idPesan = 0;
        String last = "SELECT * FROM pemesanan ORDER BY kdPemesanan DESC LIMIT 1";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(last);
            ResultSet res = state.executeQuery();
            if(res != null){
                res.last();
                idPesan = res.getInt("kdPemesanan");
            }else{
                System.out.println("Error get data");
            }
         
            
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPesan;
    }

    @Override
    public ArrayList<Pemesanan> getPemesanan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
