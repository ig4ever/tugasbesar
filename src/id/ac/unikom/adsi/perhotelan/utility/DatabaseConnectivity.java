package id.ac.unikom.adsi.perhotelan.utility;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnectivity {

    private static Connection conn;

    private final static String url = "jdbc:mysql://localhost:3306/db_crowne_plaza";
    private final static String user = "root";
    private final static String password = "";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Koneksi database gagal dengan pesan : " + ex.getMessage());
        }
        return conn;
    }
}
