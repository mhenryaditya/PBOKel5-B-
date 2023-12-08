package form;

import com.raven.swing.noticeboard.ModelNoticeBoard;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import mainapk.MainApplication;
import mainapk.TrialConnect;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;

public class FormBEL extends javax.swing.JPanel {

    private ResultSet result;
    private MainForm main;
    private int qty, price, qty1 = 1;
    private String[] idSplit;

    public FormBEL(String id, MainForm main) {
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
        initComponents();
        System.out.println(name.getText());
        initFotoDes(name.getText());

    }

    private void initFotoDes(String nama) {
        String deskripsi = "abc";
        String harga = "1213";
        ImageIcon a = new ImageIcon("");
        if (nama.equals("Nasi Goreng Special")) {
            deskripsi = " Nasi goreng yang lezat dengan campuran daging ayam, udang, telur, dan sayuran, disajikan dengan irisan mentimun dan kerupuk.";
            harga = "35.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/nasi-goreng-from-indonesia-in-illustration-vector-removebg-preview.png"));
        } else if (nama.equals("Sate Ayam Madura")) {
            deskripsi = "Sate ayam yang dibumbui dengan rempah khas Madura, disajikan dengan bumbu kacang dan lontong.";
            harga = "25.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/65f26bce6c7502b469ff8ffe3a02e35a-removebg-preview.png"));
        } else if (nama.equals("Rendang Daging")) {
            deskripsi = "Daging sapi yang dimasak dalam santan dan bumbu rempah-rempah kaya rasa, disajikan dengan nasi putih.";
            harga = "50.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/rendang.png"));
        } else if (nama.equals("Gado-Gado")) {
            deskripsi = "Sayuran segar seperti kubis, tauge, kentang, dan telur rebus yang disajikan dengan bumbu kacang khas gado-gado.";
            harga = "30.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/gado gado.png"));
        } else if (nama.equals("Soto Ayam")) {
            deskripsi = "Sup ayam dengan kuah bening, disajikan dengan mie, potongan ayam, telur rebus, seledri, dan bawang goreng.";
            harga = "40.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/soto ayam.png"));
        } else if (nama.equals("Pecel Lele")) {
            deskripsi = "Lele goreng yang renyah disajikan dengan sambal pecel, lalapan, dan nasi.";
            harga = "35.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/pecel lele.png"));
        } else if (nama.equals("Nasi Padang")) {
            deskripsi = "Beberapa hidangan Padang seperti rendang, gulai ayam, sambal ijo, dan telur balado, disajikan dengan nasi.";
            harga = "60.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/nasi Padang.png"));
        } else if (nama.equals("Bakso Malang")) {
            deskripsi = "Bakso yang lezat dengan tambahan mie, tahu, pangsit, ";
            harga = "25.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/bakso malang.png"));
        } else if (nama.equals("Ayam Goreng Kalasan")) {
            deskripsi = "Ayam yang digoreng dengan bumbu khas Kalasan, disajikan dengan sambal dan nasi.";
            harga = "45.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/ayam goreng Kalasan.png"));
        } else if (nama.equals("Lontong Sayur Betawi")) {
            deskripsi = "Sayur lodeh dengan tahu, tempe, dan telur rebus, disajikan dengan lontong dan sambal.";
            harga = "30.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/lontong sayur Betawi.png"));
        }
        if (nama.equals("Es Teh Manis")) {
            deskripsi = " Teh manis yang disajikan dingin dengan es batu.";
            harga = "5.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es teh.png"));
        } else if (nama.equals("Es Jeruk Segar")) {
            deskripsi = "Jeruk segar yang diperas dengan gula dan es, menyegarkan.";
            harga = "8.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es jeruk.png"));
        } else if (nama.equals("Wedang Jahe")) {
            deskripsi = "Minuman jahe hangat dengan tambahan gula dan rempah, cocok untuk menghangatkan tubuh.";
            harga = "10.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/wedang jahe.png"));
        } else if (nama.equals("Es Cincau Hijau")) {
            deskripsi = "Minuman segar dengan cincau hijau, santan kelapa, dan sirup gula merah.";
            harga = "15.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es cincau hijau.png"));
        } else if (nama.equals("Sekoteng")) {
            deskripsi = "Minuman tradisional dengan campuran jahe, kacang hijau, pacar cina, dan biji salak.";
            harga = "12.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/sekoteng.png"));
        } else if (nama.equals("Bandrek")) {
            deskripsi = " Minuman hangat dengan campuran jahe, kelapa parut, dan gula aren.";
            harga = "10.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/bandrek.png"));
        } else if (nama.equals("Es Doger")) {
            deskripsi = "Minuman es campur dengan campuran kelapa muda, alpukat, nangka, dan es serut.";
            harga = "20.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es Doger.png"));
        } else if (nama.equals("Bir Pletok")) {
            deskripsi = "Minuman tradisional beralkohol dengan campuran rempah-rempah khas Betawi.";
            harga = "25.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/biar pletok.png"));
        } else if (nama.equals("Es Cendol")) {
            deskripsi = "Minuman segar dengan campuran cendol, kelapa muda, santan, dan gula merah.";
            harga = "18.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/es cendol.png"));
        } else if (nama.equals("Es Tarik")) {
            deskripsi = "Teh susu yang dihasilkan dengan cara tarik yang memberikan tekstur yang lembut.";
            harga = "12.000";
            a = new ImageIcon(getClass().getResource("/fotoMenu/teh tarik.png"));
        }
        noticeBoard.addDate("Deskripsi");
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Harga : Rp. " + harga, "", deskripsi));
        judulDesk.setText(nama);
        GambarA.setIcon(a);
//        GambarA.setIcon(new ImageIcon(a.getImage().getScaledInstance(GambarA.getWidth(), GambarA.getHeight(), Image.SCALE_DEFAULT)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panela = new javax.swing.JPanel();
        GambarA = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        judulDesk = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        noticeBoard = new com.raven.swing.noticeboard.NoticeBoard();
        jPanel4 = new javax.swing.JPanel();
        judulDesk1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        kurangBeli1 = new com.raven.swing.ButtonBadges();
        tambahBeli1 = new com.raven.swing.ButtonBadges();
        submitData = new com.raven.swing.Button();
        cstName = new mainapk.TextFieldCustom();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        kategori = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        gambarDesk = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panela.setBackground(new java.awt.Color(255, 255, 255));
        panela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelaLayout = new javax.swing.GroupLayout(panela);
        panela.setLayout(panelaLayout);
        panelaLayout.setHorizontalGroup(
            panelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelaLayout.createSequentialGroup()
                .addComponent(GambarA, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelaLayout.setVerticalGroup(
            panelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GambarA, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );

        add(panela, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 580, 430));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        judulDesk.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        judulDesk.setForeground(new java.awt.Color(76, 76, 76));
        judulDesk.setText(".....");
        judulDesk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(105, 105, 105));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Deskripsi");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel10.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(judulDesk, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noticeBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 580, 210));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        judulDesk1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        judulDesk1.setForeground(new java.awt.Color(76, 76, 76));
        judulDesk1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulDesk1.setText("Form Pembelian Produk Pembeli");
        judulDesk1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 0, 0);
        jPanel4.add(judulDesk1, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel11.setText("Identitas Pembeli");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 36, 0, 0);
        jPanel4.add(jLabel11, gridBagConstraints);

        jLabel12.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 487;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 12, 0, 0);
        jPanel4.add(jLabel12, gridBagConstraints);

        kurangBeli1.setBackground(new java.awt.Color(255, 0, 0));
        kurangBeli1.setForeground(new java.awt.Color(255, 255, 255));
        kurangBeli1.setText("-");
        kurangBeli1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        kurangBeli1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kurangBeli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangBeli1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 61, 0, 0);
        jPanel4.add(kurangBeli1, gridBagConstraints);

        tambahBeli1.setBackground(new java.awt.Color(51, 51, 255));
        tambahBeli1.setForeground(new java.awt.Color(255, 255, 255));
        tambahBeli1.setText("+");
        tambahBeli1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        tambahBeli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBeli1ActionPerformed(evt);
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
        jPanel4.add(tambahBeli1, gridBagConstraints);

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
        jPanel4.add(submitData, gridBagConstraints);
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
        jPanel4.add(cstName, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel13.setText("Ringkasan Pembelian");
        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 36, 0, 0);
        jPanel4.add(jLabel13, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Nama Produk : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 61, 0, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Kategori Produk : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 61, 0, 0);
        jPanel4.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Quantity : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 61, 0, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Harga Total : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 61, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        name.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 203;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 19, 0, 0);
        jPanel4.add(name, gridBagConstraints);

        kategori.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        kategori.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 18, 0, 0);
        jPanel4.add(kategori, gridBagConstraints);

        quantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        quantity.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 18, 0, 0);
        jPanel4.add(quantity, gridBagConstraints);

        harga.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        harga.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 204;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 0, 0);
        jPanel4.add(harga, gridBagConstraints);
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

        gambarDesk.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        gambarDesk.setForeground(new java.awt.Color(159, 159, 159));
        gambarDesk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(gambarDesk, new java.awt.GridBagConstraints());

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 530, 670));
    }// </editor-fold>//GEN-END:initComponents

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
            while (result.next()) {
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
            String sqlInsert = "insert into riwayatmakanan (id_pesananMakanan, id_pembeli, IDMakanan, jumlahMakanan, tanggalPesananMakanan) values ('" + ts.getTime() + "','" + getPembeli(nama) + "','" + menu + "','" + jumlah + "','" + currentDate + "')";
            result.next();
            statement.execute(sqlInsert);
//            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan");
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
//            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan");
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

    private void kurangBeli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangBeli1ActionPerformed
        qty1--;
        if (qty1 <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah barang melampaui batas minimum!", "Error", JOptionPane.ERROR_MESSAGE);
            qty1 = 1;
            quantity.setText("1");
            harga.setText((price * 1) + "");
        }
        quantity.setText(qty1 + "");
        harga.setText((qty1 * price) + "");
    }//GEN-LAST:event_kurangBeli1ActionPerformed

    private void tambahBeli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBeli1ActionPerformed
        qty1++;
        if (qty1 > qty) {
            JOptionPane.showMessageDialog(null, "Jumlah barang melebihi batas maksimal!", "Error", JOptionPane.ERROR_MESSAGE);
            qty1 = 1;
        }
        quantity.setText(qty1 + "");
        harga.setText((qty1 * price) + "");
    }//GEN-LAST:event_tambahBeli1ActionPerformed

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
            main.showForm(new Dashboard(main));
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
    public javax.swing.JLabel GambarA;
    private mainapk.TextFieldCustom cstName;
    private javax.swing.JLabel gambarDesk;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel judulDesk;
    private javax.swing.JLabel judulDesk1;
    private javax.swing.JLabel kategori;
    private com.raven.swing.ButtonBadges kurangBeli1;
    private javax.swing.JLabel name;
    private com.raven.swing.noticeboard.NoticeBoard noticeBoard;
    private javax.swing.JPanel panela;
    private javax.swing.JLabel quantity;
    private com.raven.swing.Button submitData;
    private com.raven.swing.ButtonBadges tambahBeli1;
    // End of variables declaration//GEN-END:variables
}
