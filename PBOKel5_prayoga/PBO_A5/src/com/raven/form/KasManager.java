package com.raven.form;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import mainapk.MainApplication;
import mainapk.TrialConnect;

public class KasManager extends javax.swing.JPanel {

//    private String[] arr;
    private MainForm main;
    private int idStaff;

    public KasManager(MainForm main, int idStaff) {
//        this.arr = arr;
        this.idStaff = idStaff;
        this.main = main;
        initComponents();
    }

//    int qty = Integer.parseInt(arr[2]), price = Integer.parseInt(arr[3]), qty1 = 1;
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
//    void setStok(String pengenal, String id) {
//        Connection vKoneksi = TrialConnect.createConnection();
//        String a = (arr[5].equals("makanan")) ? "IDMakanan" : "IDMinuman";
//        qty -= qty1;
//        try {
//            Statement statement = vKoneksi.createStatement();
//            String sql = "UPDATE FROM " + pengenal + " SET stok = '" + qty + "' WHERE " + a + " = '" + id + "'";
//            statement.execute(sql);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        judulDesk = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        submitData = new com.raven.swing.Button();
        cstName = new mainapk.TextFieldCustom();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        kategori = new javax.swing.JLabel();
        backHome = new com.raven.swing.ButtonBadges();
        jScrollPane1 = new javax.swing.JScrollPane();
        tujuanTarik = new javax.swing.JTextArea();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        judulDesk.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        judulDesk.setForeground(new java.awt.Color(76, 76, 76));
        judulDesk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulDesk.setText("Form Kas Manager");
        judulDesk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel9.setText("Nama Pegawai");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel10.setOpaque(true);

        submitData.setBackground(new java.awt.Color(0, 153, 0));
        submitData.setForeground(new java.awt.Color(255, 255, 255));
        submitData.setText("Proses");
        submitData.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        submitData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDataActionPerformed(evt);
            }
        });

        cstName.setEditable(false);
        cstName.setEnabled(false);
        cstName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cstName.setLabelText("Nama Pegawai");
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
        jLabel11.setText("Ringkasan Penarikan");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Tanggal penarikan :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Jumlah penarikan :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Tujuan penarikan : ");

        name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        name.setText("jLabel5");

        kategori.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        kategori.setText("jLabel5");

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

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tujuanTarik.setColumns(20);
        tujuanTarik.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        tujuanTarik.setForeground(new java.awt.Color(204, 204, 204));
        tujuanTarik.setRows(5);
        tujuanTarik.setText("Jelaskan Tujuan Penarikan Anda");
        tujuanTarik.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tujuanTarikFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tujuanTarikFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(tujuanTarik);

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
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(submitData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(kategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1))
                                .addGap(31, 31, 31))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cstName, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 42, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kategori))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backHome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        submitData.setEnabled(false);

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

    private void submitDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitDataActionPerformed
//        if (arr[5].equals("makanan")) {
//            insertMakanan(arr[0], (qty1) + "");
//            setStok("makanan", arr[0]);
//        } else {
//            insertMinuman(arr[0], (qty1) + "");
//            setStok("minuman", arr[0]);
//        }
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
//        main.showForm(new MainApplication(idStaff));
        main.showForm(new Dashboard(main));
    }//GEN-LAST:event_backHomeActionPerformed

    private void tujuanTarikFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tujuanTarikFocusGained

        tujuanTarik.setFont(new Font("Arial", Font.PLAIN, 16));
        tujuanTarik.setText("");
        tujuanTarik.setForeground(Color.black);

    }//GEN-LAST:event_tujuanTarikFocusGained

    private void tujuanTarikFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tujuanTarikFocusLost

        tujuanTarik.setFont(new Font("Arial", Font.BOLD, 16));
        tujuanTarik.setText("Jelaskan Tujuan Penarikan Anda");
        tujuanTarik.setForeground(new Color(204, 204, 204));

    }//GEN-LAST:event_tujuanTarikFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.ButtonBadges backHome;
    private mainapk.TextFieldCustom cstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judulDesk;
    private javax.swing.JLabel kategori;
    private javax.swing.JLabel name;
    private com.raven.swing.Button submitData;
    private javax.swing.JTextArea tujuanTarik;
    // End of variables declaration//GEN-END:variables
}
