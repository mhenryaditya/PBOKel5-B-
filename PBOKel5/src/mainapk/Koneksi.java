package mainapk;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private static Connection mKoneksi;

    public static Connection createKoneksi() {
        String url = "jdbc:mysql://localhost:3306/database_pbo",
                user = "root",
                pass = "";
        if (mKoneksi == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                mKoneksi = DriverManager.getConnection(url, user, pass);
                System.out.println("ok");
            } catch (Exception e) {
                System.out.println("fail");
            }
        }
        return mKoneksi;
    }
}
