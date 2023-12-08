package form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import mainapk.MainApplication;
import mainapk.TrialConnect;

public class FormPembelian extends javax.swing.JPanel {

    private ResultSet result;
    private MainForm main;
    private int idStaff, qty, price, qty1 = 1;
    private String[] idSplit;
    private MainApplication mainApp;

    public FormPembelian(String id, MainForm main, int idStaff, MainApplication mainApp) {
        this.idStaff = idStaff;
        this.mainApp = mainApp;
        this.main = main;
        idSplit = id.split("-");
        initComponents();
        Connection connect = TrialConnect.createConnection();
        if (idSplit[1].equals("m")) {
            try {
                Statement statement = connect.createStatement();
                String sql = "SELECT * FROM makanan WHERE IDMakanan = '" + idSplit[0] + "'";
                result = statement.executeQuery(sql);
                result.next();
                qty = Integer.parseInt(result.getString("stok"));
                price = Integer.parseInt(result.getString("hargaMakanan"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                Statement statement = connect.createStatement();
                String sql = "SELECT * FROM minuman WHERE IDMinuman = '" + idSplit[0] + "'";
                result = statement.executeQuery(sql);
                result.next();
                qty = Integer.parseInt(result.getString("stok"));
                price = Integer.parseInt(result.getString("hargaMinuman"));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void insertPembeli(String name) {
        Connection vKoneksi = TrialConnect.createConnection();
        try {
            Statement statement = vKoneksi.createStatement();
            String sqlInsert = "insert into pembeli (nama_pembeli) values ('" + name + "')";
            result.next();
            statement.execute(sqlInsert);
            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    String getPembeli(String name) {
        Connection vKoneksi = TrialConnect.createConnection();
        try {
            Statement statement = vKoneksi.createStatement();
            String sql = "SELECT id_pembeli FROM pembeli WHERE nama_pembeli = '" + name + "'", getName = "";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                getName = result.getString("id_pembeli");
            }
            return getName;
        } catch (SQLException ex) {
            return "";
        }
    }
    
    //Insert makanan
    public void insertMakanan(String menu, String jumlah, String nama) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        LocalDate currentDate = LocalDate.now();
        Connection vKoneksi = TrialConnect.createConnection();
        try {
            Statement statement = vKoneksi.createStatement();
            String sqlInsert = "insert into riwayatmakanan (id_pesananMakanan, id_pembeli, IDMakanan, jumlahMakanan, tanggalPesananMakanan) values ('" + ts.getTime() + "','"+ getPembeli(nama) + "','" + menu + "','" + jumlah + "','" + currentDate + "')";
            result.next();
            statement.execute(sqlInsert);
            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Insert minuman
    public void insertMinuman(String menu, String jumlah, String nama) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        LocalDate currentDate = LocalDate.now();
        Connection vKoneksi = TrialConnect.createConnection();
        try {
            Statement statement = vKoneksi.createStatement();
            String sqlInsert = "insert into riwayatminuman (id_pesananMinuman, id_pembeli, IDMinuman, jumlahMinuman, tanggalPesananMinuman) values ('" + ts.getTime() + "','" + getPembeli(nama) + "','" + menu + "','" + jumlah + "','" + currentDate + "')";
            result.next();
            statement.execute(sqlInsert);
            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Ubah jumlah makanan
    void setStok(String pengenal, String id) {
        Connection vKoneksi = TrialConnect.createConnection();
        qty -= qty1;
        if (idSplit[1].equals("m")) {
            try {
                Statement statement = vKoneksi.createStatement();
                String sql = "UPDATE " + pengenal + " SET stok = '" + qty + "' WHERE IDMakanan = '" + id + "'";
                result.next();
                statement.execute(sql);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {
            try {
                Statement statement = vKoneksi.createStatement();
                String sql = "UPDATE FROM " + pengenal + " SET stok = '" + qty + "' WHERE IDMinuman = '" + id + "'";
                result.next();
                statement.execute(sql);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        judulDesk = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kurangBeli = new com.raven.swing.ButtonBadges();
        tambahBeli = new com.raven.swing.ButtonBadges();
        submitData = new com.raven.swing.Button();
        cstName = new mainapk.TextFieldCustom();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        kategori = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        judulDesk.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        judulDesk.setForeground(new java.awt.Color(76, 76, 76));
        judulDesk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulDesk.setText("Form Pembelian Produk Pembeli");
        judulDesk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 0, 0);
        jPanel3.add(judulDesk, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel9.setText("Identitas Pembeli");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 36, 0, 0);
        jPanel3.add(jLabel9, gridBagConstraints);

        jLabel10.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 487;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 12, 0, 0);
        jPanel3.add(jLabel10, gridBagConstraints);

        kurangBeli.setBackground(new java.awt.Color(255, 0, 0));
        kurangBeli.setForeground(new java.awt.Color(255, 255, 255));
        kurangBeli.setText("-");
        kurangBeli.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        kurangBeli.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kurangBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangBeliActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 61, 0, 0);
        jPanel3.add(kurangBeli, gridBagConstraints);

        tambahBeli.setBackground(new java.awt.Color(51, 51, 255));
        tambahBeli.setForeground(new java.awt.Color(255, 255, 255));
        tambahBeli.setText("+");
        tambahBeli.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        tambahBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBeliActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 9, 0, 0);
        jPanel3.add(tambahBeli, gridBagConstraints);

        submitData.setBackground(new java.awt.Color(0, 153, 0));
        submitData.setForeground(new java.awt.Color(255, 255, 255));
        submitData.setText("Proses");
        submitData.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        submitData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 143;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 7, 102, 0);
        jPanel3.add(submitData, gridBagConstraints);
        //submitData.setEnabled(false);

        cstName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cstName.setLabelText("Nama Pembeli");
        cstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cstNameActionPerformed(evt);
            }
        });
        cstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cstNameKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 421;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 36, 0, 0);
        jPanel3.add(cstName, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel11.setText("Ringkasan Pembelian");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 36, 0, 0);
        jPanel3.add(jLabel11, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Nama Produk : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 61, 0, 0);
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Kategori Produk : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 61, 0, 0);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Quantity : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 61, 0, 0);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Harga Total : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 61, 0, 0);
        jPanel3.add(jLabel4, gridBagConstraints);

        name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        name.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 203;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 19, 0, 0);
        jPanel3.add(name, gridBagConstraints);

        kategori.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        kategori.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 18, 0, 0);
        jPanel3.add(kategori, gridBagConstraints);

        quantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        quantity.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 18, 0, 0);
        jPanel3.add(quantity, gridBagConstraints);

        harga.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        harga.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 0, 0);
        jPanel3.add(harga, gridBagConstraints);
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            if (idSplit[1].equals("m")) {
                String sql = "SELECT namaMakanan, hargaMakanan FROM makanan WHERE IDMakanan = '" + idSplit[0] + "'";
                ResultSet result = statement.executeQuery(sql);
                result.next();
                name.setText(result.getString("namaMakanan"));
                price = result.getInt("hargaMakanan");
            } else {
                String sql = "SELECT namaMinuman, hargaMinuman FROM minuman WHERE IDMinuman = '" + idSplit[0] + "'";
                ResultSet result = statement.executeQuery(sql);
                result.next();
                name.setText(result.getString("namaMinuman"));
                price = result.getInt("hargaMinuman");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR SQL", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        if (idSplit[1].equals("m")) {
            kategori.setText("Makanan");
        } else {
            kategori.setText("Minuman");
        }

        quantity.setText("1");
        harga.setText((qty1 * price) + "");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tambahBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBeliActionPerformed
        qty1++;
        if (qty1 > qty) {
            JOptionPane.showMessageDialog(null, "Jumlah barang melebihi batas maksimal!", "Error", JOptionPane.ERROR_MESSAGE);
            qty1 = 1;
        }
        quantity.setText(qty1 + "");
        harga.setText((qty1 * price) + "");
    }//GEN-LAST:event_tambahBeliActionPerformed

    private void kurangBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangBeliActionPerformed
        qty1--;
        if (qty1 <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah barang melampaui batas minimum!", "Error", JOptionPane.ERROR_MESSAGE);
            qty1 = 1;
            quantity.setText("1");
            harga.setText((price * 1) + "");
        }
        quantity.setText(qty1 + "");
        harga.setText((qty1 * price) + "");
    }//GEN-LAST:event_kurangBeliActionPerformed

    private void submitDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitDataActionPerformed
        if (!cstName.getText().isEmpty()) {
            if (idSplit[1].equals("m")) {
                insertPembeli(cstName.getText());
                insertMakanan(idSplit[0], (qty1) + "", cstName.getText());
                setStok("makanan", idSplit[0]);
            } else {
                insertPembeli(cstName.getText());
                insertMinuman(idSplit[0], (qty1) + "", cstName.getText());
                setStok("minuman", idSplit[0]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kesalahan!\nNama tidak boleh kosong!", "Galat Inputan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitDataActionPerformed

    private void cstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cstNameActionPerformed

    }//GEN-LAST:event_cstNameActionPerformed

    private void cstNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cstNameKeyPressed
        if (!cstName.getText().isEmpty()) {
            submitData.setEnabled(true);
        } else {
            submitData.setEnabled(false);
        }
    }//GEN-LAST:event_cstNameKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mainapk.TextFieldCustom cstName;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel judulDesk;
    private javax.swing.JLabel kategori;
    private com.raven.swing.ButtonBadges kurangBeli;
    private javax.swing.JLabel name;
    private javax.swing.JLabel quantity;
    private com.raven.swing.Button submitData;
    private com.raven.swing.ButtonBadges tambahBeli;
    // End of variables declaration//GEN-END:variables
}
