package com.raven.form;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import mainapk.MainApplication;
import mainapk.TrialConnect;

public class FormPembelian extends javax.swing.JPanel {

    private String[] arr;
    private MainForm main;
    private int idStaff;

    public FormPembelian(String[] arr, MainForm main, int idStaff) {
        this.arr = arr;
        this.idStaff = idStaff;
        this.main = main;
        initComponents();
    }

    int qty = Integer.parseInt(arr[2]), price = Integer.parseInt(arr[3]), qty1 = 1;
    
    //Insert makanan
    public void insertMakanan(String menu, String jumlah) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        LocalDate currentDate = LocalDate.now();
        Connection vKoneksi = TrialConnect.createConnection();
        try {
            Statement statement = vKoneksi.createStatement();
            String sqlInsert = "insert into riwayatmakanan (id_pesananMakanan, IDMakanan, jumlahMakanan, tanggalPesananMakanan) values ('" + ts.getTime() + "','" + menu + "','" + jumlah + "','" + currentDate + "')";
            statement.execute(sqlInsert);
            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Insert minuman
    public void insertMinuman(String menu, String jumlah) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        LocalDate currentDate = LocalDate.now();
        Connection vKoneksi = TrialConnect.createConnection();
        try {
            Statement statement = vKoneksi.createStatement();
            String sqlInsert = "insert into riwayatminuman (id_pesananMinuman, IDMinuman, jumlahMinuman, tanggalPesananMinuman) values ('" + ts.getTime() + "','" + menu + "','" + jumlah + "','" + currentDate + "')";
            statement.execute(sqlInsert);
            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    //Ubah jumlah makanan
    void setStok(String pengenal, String id){
        Connection vKoneksi = TrialConnect.createConnection();
        String a = (arr[5].equals("makanan")) ? "IDMakanan" : "IDMinuman";
        qty -= qty1;
        try {
            Statement statement = vKoneksi.createStatement();
            String sql = "UPDATE FROM " + pengenal + " SET stok = '" + qty + "' WHERE " + a + " = '" + id + "'";
            statement.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        backHome = new com.raven.swing.ButtonBadges();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        judulDesk.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        judulDesk.setForeground(new java.awt.Color(76, 76, 76));
        judulDesk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulDesk.setText("Form Pembelian Produk Pembeli");
        judulDesk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel9.setText("Identitas Pembeli");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel10.setOpaque(true);

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

        tambahBeli.setBackground(new java.awt.Color(51, 51, 255));
        tambahBeli.setForeground(new java.awt.Color(255, 255, 255));
        tambahBeli.setText("+");
        tambahBeli.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        tambahBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBeliActionPerformed(evt);
            }
        });

        submitData.setBackground(new java.awt.Color(0, 153, 0));
        submitData.setForeground(new java.awt.Color(255, 255, 255));
        submitData.setText("Proses");
        submitData.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        submitData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDataActionPerformed(evt);
            }
        });

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

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel11.setText("Ringkasan Pembelian");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Nama Produk : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Kategori Produk : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Quantity : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Harga Total : ");

        name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        name.setText("jLabel5");

        kategori.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        kategori.setText("jLabel5");

        quantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        quantity.setText("jLabel5");

        harga.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        harga.setText("jLabel5");

        backHome.setBackground(new java.awt.Color(255, 0, 0));
        backHome.setForeground(new java.awt.Color(255, 255, 255));
        backHome.setText("Kembali");
        backHome.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        backHome.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        backHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(judulDesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 36, Short.MAX_VALUE)
                                        .addComponent(cstName, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(kurangBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tambahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(submitData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(36, 36, 36)
                                                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(kategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(71, 71, 71)
                                                .addComponent(quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(48, 48, 48)
                                                .addComponent(harga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(backHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(36, 36, 36))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(judulDesk)
                .addGap(25, 25, 25)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kategori))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantity))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(harga))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kurangBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backHome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        submitData.setEnabled(false);
        name.setText(arr[1]);
        kategori.setText(arr[5]);
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
        if (arr[5].equals("makanan")) {
            insertMakanan(arr[0], (qty1) + "");
            setStok("makanan", arr[0]);
        } else {
            insertMinuman(arr[0], (qty1) + "");
            setStok("minuman", arr[0]);
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

    private void backHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backHomeActionPerformed
        main.showForm(new MainApplication(idStaff));
    }//GEN-LAST:event_backHomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.ButtonBadges backHome;
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
