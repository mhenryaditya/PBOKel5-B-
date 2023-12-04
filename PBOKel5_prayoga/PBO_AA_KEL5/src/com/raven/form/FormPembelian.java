package com.raven.form;

import com.raven.model2.Model_Card;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FormPembelian extends javax.swing.JPanel {

    public FormPembelian() {
        initComponents();
//        initNoticeBoard();
    }
    
    
    private void initNoticeBoard(Model_Card model){
        String nama = model.getTitle();
        String deskripsi = "abc";
        String harga = "1213";
        ImageIcon a = new ImageIcon("");
        if (nama.equals("Nasi Goreng")) {
            deskripsi = " Nasi goreng yang lezat dengan campuran daging ayam, udang, telur, dan sayuran, disajikan dengan irisan mentimun dan kerupuk.";
            harga = "35.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/nasi-goreng-from-indonesia-in-illustration-vector-removebg-preview.png"));
        }else if (nama.equals("Sate Ayam")) {
            deskripsi = "Sate ayam yang dibumbui dengan rempah khas Madura, disajikan dengan bumbu kacang dan lontong.";
            harga = "25.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/65f26bce6c7502b469ff8ffe3a02e35a-removebg-preview.png"));
        }else if (nama.equals("Rendang Daging")) {
            deskripsi = "Daging sapi yang dimasak dalam santan dan bumbu rempah-rempah kaya rasa, disajikan dengan nasi putih.";
            harga = "50.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/rendang.png"));
        }else if (nama.equals("Gado-Gado")) {
            deskripsi = "Sayuran segar seperti kubis, tauge, kentang, dan telur rebus yang disajikan dengan bumbu kacang khas gado-gado.";
            harga = "30.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/gado gado.png"));
        }else if (nama.equals("Soto Ayam")) {
            deskripsi = "Sup ayam dengan kuah bening, disajikan dengan mie, potongan ayam, telur rebus, seledri, dan bawang goreng.";
            harga = "40.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/soto ayam.png"));
        }else if (nama.equals("Pecel Lele")){
            deskripsi = "Lele goreng yang renyah disajikan dengan sambal pecel, lalapan, dan nasi.";
            harga = "35.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/pecel lele.png"));
        }else if (nama.equals("Nasi Padang")) {
            deskripsi = "Beberapa hidangan Padang seperti rendang, gulai ayam, sambal ijo, dan telur balado, disajikan dengan nasi.";
            harga = "60.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/nasi Padang.png"));
        }else if (nama.equals("Bakso Malang")) {
            deskripsi = "Bakso yang lezat dengan tambahan mie, tahu, pangsit, ";
            harga = "25.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/bakso malang.png"));
        }else if (nama.equals("Ayam Goreng")) {
            deskripsi = "Ayam yang digoreng dengan bumbu khas Kalasan, disajikan dengan sambal dan nasi.";
            harga = "45.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/ayam goreng Kalasan.png"));
        }else if (nama.equals("Lontong Sayur")) {
            deskripsi = "Sayur lodeh dengan tahu, tempe, dan telur rebus, disajikan dengan lontong dan sambal.";
            harga = "30.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/lontong sayur Betawi.png"));
        }
        if (nama.equals("Es Teh Manis")) {
            deskripsi = " Teh manis yang disajikan dingin dengan es batu.";
            harga = "5.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es teh.png"));
        }else if (nama.equals("Es Jeruk Segar")) {
            deskripsi = "Jeruk segar yang diperas dengan gula dan es, menyegarkan.";
            harga = "8.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es jeruk.png"));
        }else if (nama.equals("Wedang Jahe")) {
            deskripsi = "Minuman jahe hangat dengan tambahan gula dan rempah, cocok untuk menghangatkan tubuh.";
            harga = "10.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/wedang jahe.png"));
        }else if (nama.equals("Es Cincau Hijau")) {
            deskripsi = "Minuman segar dengan cincau hijau, santan kelapa, dan sirup gula merah.";
            harga = "15.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es cincau hijau.png"));
        }else if (nama.equals("Sekoteng")) {
            deskripsi = "Minuman tradisional dengan campuran jahe, kacang hijau, pacar cina, dan biji salak.";
            harga = "12.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/sekoteng.png"));
        }else if (nama.equals("Bandrek")) {
            deskripsi = " Minuman hangat dengan campuran jahe, kelapa parut, dan gula aren.";
            harga = "10.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/bandrek.png"));
        }else if (nama.equals("Es Doger")) {
            deskripsi = "Minuman es campur dengan campuran kelapa muda, alpukat, nangka, dan es serut.";
            harga = "20.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es Doger.png"));
        }else if (nama.equals("Bir Pletok")) {
            deskripsi = "Minuman tradisional beralkohol dengan campuran rempah-rempah khas Betawi.";
            harga = "25.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/biar pletok.png"));
        }else if (nama.equals("Es Cendol")) {
            deskripsi = "Minuman segar dengan campuran cendol, kelapa muda, santan, dan gula merah.";
            harga = "18.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es cendol.png"));
        }else if (nama.equals("Es Tarik")) {
            deskripsi = "Teh susu yang dihasilkan dengan cara tarik yang memberikan tekstur yang lembut.";
            harga = "12.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/teh tarik.png"));
        }
        noticeBoard.addDate("Deskripsi");
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Harga : Rp. ", harga, deskripsi));
        noticeBoard.scrollToTop();
        judulDesk.setText(nama);
        gambarDesk.setIcon(a);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        judulDesk = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        noticeBoard = new com.raven.swing.noticeboard.NoticeBoard();
        gambarDesk = new javax.swing.JLabel();
        button1 = new com.raven.swing.Button();
        tambahBeli = new com.raven.swing.ButtonBadges();
        kurangBeli = new com.raven.swing.ButtonBadges();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        judulDesk.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        judulDesk.setForeground(new java.awt.Color(76, 76, 76));
        judulDesk.setText(".....");
        judulDesk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(105, 105, 105));
        jLabel9.setText("Deskripsi");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel10.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(judulDesk, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulDesk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(9, 9, 9)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(426, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(noticeBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        gambarDesk.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        gambarDesk.setForeground(new java.awt.Color(159, 159, 159));
        gambarDesk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        button1.setBackground(new java.awt.Color(102, 255, 51));
        button1.setText("Order Now");
        button1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N

        tambahBeli.setText("+");
        tambahBeli.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        tambahBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBeliActionPerformed(evt);
            }
        });

        kurangBeli.setText("-");
        kurangBeli.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        kurangBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangBeliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(kurangBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(tambahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(gambarDesk, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(kurangBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(tambahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(gambarDesk, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tambahBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBeliActionPerformed
        
    }//GEN-LAST:event_tambahBeliActionPerformed

    private void kurangBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kurangBeliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private javax.swing.JLabel gambarDesk;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel judulDesk;
    private com.raven.swing.ButtonBadges kurangBeli;
    private com.raven.swing.noticeboard.NoticeBoard noticeBoard;
    private com.raven.swing.ButtonBadges tambahBeli;
    // End of variables declaration//GEN-END:variables
}
