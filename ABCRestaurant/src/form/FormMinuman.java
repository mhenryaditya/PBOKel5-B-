package form;

import model2.Model_Card;
import com.raven.swing2.ScrollBar;
import com.raven.swing2.WrapLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import mainapk.MainApplication;
import mainapk.TrialConnect;

public class FormMinuman extends javax.swing.JPanel {

    private MainForm main;
    private int idStaff;
    private MainApplication mainApp;
    
    public FormMinuman(MainForm main, int idStaff, MainApplication mainApp) {
        this.main = main;
        this.mainApp = mainApp;
        this.idStaff = idStaff;
        initComponents();
        init();
    }
    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        panel.add(new boxinformation.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es teh.png")), "Es Teh Manis", "Harga : \n       Rp." + String.valueOf(getPrice("Es Teh Manis")) + "\nStok : \n       " + String.valueOf(getStok("Es Teh Manis"))), main, getId("Es Teh Manis"), idStaff, mainApp));
        panel.add(new boxinformation.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es jeruk.png")), "Es Jeruk Segar", "Harga : \n       Rp." + String.valueOf(getPrice("Es Jeruk Segar")) + "\nStok : \n       " + String.valueOf(getStok("Es Jeruk Segar"))), main, getId("Es Jeruk Segar"), idStaff, mainApp));
        panel.add(new boxinformation.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/wedang jahe.png")), "Wedang Jahe", "Harga : \n       Rp." + String.valueOf(getPrice("Wedang Jahe")) + "\nStok : \n       " + String.valueOf(getStok("Wedang Jahe"))), main, getId("Wedang Jahe"), idStaff, mainApp));
        panel.add(new boxinformation.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es cincau hijau.png")), "Es Cincau Hijau", "Harga : \n       Rp." + String.valueOf(getPrice("Es Cincau Hijau")) + "\nStok : \n       " + String.valueOf(getStok("Es Cincau Hijau"))), main, getId("Es Cincau Hijau"), idStaff, mainApp));
        panel.add(new boxinformation.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/sekoteng.png")), "Sekoteng", "Harga : \n       Rp." + String.valueOf(getPrice("Sekoteng")) + "\nStok : \n       " + String.valueOf(getStok("Sekoteng"))), main, getId("Sekoteng"), idStaff, mainApp));
        panel.add(new boxinformation.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/bandrek.png")), "Bandrek", "Harga : \n       Rp." + String.valueOf(getPrice("Bandrek")) + "\nStok : \n       " + String.valueOf(getStok("Bandrek"))), main, getId("Bandrek"), idStaff, mainApp));
        panel.add(new boxinformation.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es Doger.png")), "Es Doger", "Harga : \n       Rp." + String.valueOf(getPrice("Es Doger")) + "\nStok : \n       " + String.valueOf(getStok("Es Doger"))), main, getId("Es Doger"), idStaff, mainApp));
        panel.add(new boxinformation.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es cendol.png")), "Es Cendol", "Harga : \n       Rp." + String.valueOf(getPrice("Es Cendol")) + "\nStok : \n       " + String.valueOf(getStok("Es Cendol"))), main, getId("Es Cendol"), idStaff, mainApp));
        panel.add(new boxinformation.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/teh tarik.png")), "Teh Tarik", "Harga : \n       Rp." + String.valueOf(getPrice("Teh Tarik")) + "\nStok : \n       " + String.valueOf(getStok("Teh Tarik"))), main, getId("Teh Tarik"), idStaff, mainApp));
        panel.revalidate();
        panel.repaint();
    }
    
    int getStok(String nama){
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT stok FROM minuman WHERE namaMinuman = '" + nama + "'";
            ResultSet result = statement.executeQuery(sql);
            int stok = 0;
            while(result.next()){
                stok = result.getInt("stok");
            }
            return stok;
        } catch (SQLException e) {
            return -1;
        }
    }
    
    int getPrice(String nama){
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT hargaMinuman FROM minuman WHERE namaMinuman = '" + nama + "'";
            ResultSet result = statement.executeQuery(sql);
            int harga = 0;
            while(result.next()){
                harga = result.getInt("hargaMinuman");
            }
            return harga;
        } catch (SQLException e) {
            return -1;
        }
    }

    String getId(String nama){
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT IDMinuman FROM minuman WHERE namaMinuman = '" + nama + "'";
            ResultSet result = statement.executeQuery(sql);
            String id = "";
            while(result.next()){
                id = result.getString("IDMinuman");
            }
            return (id + "-i");
        } catch (SQLException e) {
            return "";
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
