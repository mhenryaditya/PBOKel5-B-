package com.raven.form;

import com.raven.model2.Model_Card;
import com.raven.swing2.ScrollBar;
import com.raven.swing2.WrapLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import mainapk.TrialConnect;

public class FormMakanan extends javax.swing.JPanel {

    private MainForm main;
    private int idStaff;
    
    public FormMakanan(MainForm main, int idStaff) {
        this.main = main;
        this.idStaff = idStaff;
        initComponents();
        init();

    }

    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/nasi-goreng-from-indonesia-in-illustration-vector-removebg-preview.png")), "Nasi Goreng Spesial", "Harga : \n       Rp." + String.valueOf(getPrice("Nasi Goreng Special")) + "\nStok : \n       " + String.valueOf(getStok("Nasi Goreng Special"))), main, getData("Nasi Goreng Special"), idStaff));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/65f26bce6c7502b469ff8ffe3a02e35a-removebg-preview.png")), "Sate Ayam Madura", "Harga : \n       Rp." + String.valueOf(getPrice("Sate Ayam Madura")) + "\nStok : \n       " + String.valueOf(getStok("Sate Ayam Madura"))), main, getData("Sate Ayam Madura"), idStaff));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/rendang.png")), "Rendang Daging", "Harga : \n       Rp." + String.valueOf(getPrice("Rendang Daging")) + "\nStok : \n       " + String.valueOf(getStok("Rendang Daging"))), main, getData("Rendang Daging"), idStaff));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/gado gado.png")), "Gado-Gado", "Harga : \n       Rp." + String.valueOf(getPrice("Gado-Gado")) + "\nStok : \n       " + String.valueOf(getStok("Gado-Gado"))), main, getData("Gado-Gado"), idStaff));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/soto ayam.png")), "Soto Ayam", "Harga : \n       Rp." + String.valueOf(getPrice("Soto Ayam")) + "\nStok : \n       " + String.valueOf(getStok("Soto Ayam"))), main, getData("Soto Ayam"), idStaff));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/pecel lele.png")), "Pecel Lele", "Harga : \n       Rp." + String.valueOf(getPrice("Pecel Lele")) + "\nStok : \n       " + String.valueOf(getStok("Pecel Lele"))), main, getData("Pecel Lele"), idStaff));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/nasi Padang.png")), "Nasi Padang", "Harga : \n       Rp." + String.valueOf(getPrice("Nasi Padang")) + "\nStok : \n       " + String.valueOf(getStok("Nasi Padang"))), main, getData("Nasi Padang"), idStaff));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/bakso malang.png")), "Bakso Malang", "Harga : \n       Rp." + String.valueOf(getPrice("Bakso Malang")) + "\nStok : \n       " + String.valueOf(getStok("Bakso Malang"))), main, getData("Bakso Malang"), idStaff));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/ayam goreng Kalasan.png")), "Ayam Goreng Kalasan", "Harga : \n       Rp." + String.valueOf(getPrice("Ayam Goreng Kalasan")) + "\nStok : \n       " + String.valueOf(getStok("Ayam Goreng Kalasan"))), main, getData("Ayam Goreng Kalasan"), idStaff));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/lontong sayur Betawi.png")), "Lontong Sayur Betawi", "Harga : \n       Rp." + String.valueOf(getPrice("Lontong Sayur Betawi")) + "\nStok : \n       " + String.valueOf(getStok("Lontong Sayur Betawi"))), main, getData("Lontong Sayur Betawi"), idStaff));
        panel.revalidate();
        panel.repaint();
    }
    
    int getStok(String nama){
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT stok FROM makanan WHERE namaMakanan = '" + nama + "'";
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
            String sql = "SELECT hargaMakanan FROM makanan WHERE namaMakanan = '" + nama + "'";
            ResultSet result = statement.executeQuery(sql);
            int harga = 0;
            while(result.next()){
                harga = result.getInt("stok");
            }
            return harga;
        } catch (SQLException e) {
            return -1;
        }
    }

    int getId(String nama){
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT IDMakanan FROM makanan WHERE namaMakanan = '" + nama + "'";
            ResultSet result = statement.executeQuery(sql);
            int id = 0;
            while(result.next()){
                id = result.getInt("stok");
            }
            return id;
        } catch (SQLException e) {
            return -1;
        }
    }
    
    String[] getData(String nama){
        String[] data = new String[6];
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT * FROM makanan WHERE namaMakanan = '" + nama + "'";
            ResultSet result = statement.executeQuery(sql);
            int i = 0;
            while(result.next()){
                data[i] = result.getString(i);
            }
            data[5] = "makanan";
            return data;
        } catch (SQLException e) {
            return data;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        jScrollPane1.setBorder(null);

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
                .addComponent(jScrollPane1)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
