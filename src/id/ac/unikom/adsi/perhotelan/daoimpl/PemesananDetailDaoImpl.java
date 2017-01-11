package id.ac.unikom.adsi.perhotelan.daoimpl;

import id.ac.unikom.adsi.perhotelan.dao.PemesananDetailDao;
import id.ac.unikom.adsi.perhotelan.entitiy.PemesananDetail;
import id.ac.unikom.adsi.perhotelan.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PemesananDetailDaoImpl implements PemesananDetailDao {

    private final Connection conn;

    public PemesananDetailDaoImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<PemesananDetail> getDetail(int kdPesanan) {
        ArrayList<PemesananDetail> arrayDetail = null;
        String sql = "SELECT b.kdBuku,b.judulBuku,b.pengarang,b.penerbit,b.tahun from peminjaman_detail "
                + "INNER JOIN peminjaman ON "
                + "peminjaman.idPeminjaman=peminjaman_detail.idPeminjaman INNER JOIN buku b ON "
                + "peminjaman_detail.idBuku=b.kdBuku where peminjaman.idPeminjaman= ?";
        PreparedStatement state = null;
        try {
            state = conn.prepareStatement(sql);
            state.setInt(1, kdPesanan);
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayDetail = new ArrayList<>();

                while (result.next()) {
                    PemesananDetail p = new PemesananDetail();
                    p.setKdBuku(result.getString(1));
                    p.setJudul(result.getString(2));
                    p.setPengarang(result.getString(3));
                    p.setPenerbit(result.getString(4));
                    p.setTahun(result.getString(5));

                    arrayDetail.add(p);
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
        return arrayDetail;
    }

    @Override
    public boolean insertDetail(int kdPesanan, int idRuangan) {
        String sql = "INSERT INTO peminjaman_detail(idPeminjaman,idBuku) values (?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(sql);
            state.setInt(1, kdPesanan);
            state.setInt(2, idRuangan);
            int result = state.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return false;
        }

    }
}
