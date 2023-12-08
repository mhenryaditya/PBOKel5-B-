package form;

import dialog.FormEditRiwayat;
import dialog.Message;
import main.Main;
import model.ModelCard;
import model.ModelBuyer;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.table.EventAction;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import mainapk.TrialConnect;

public class Dashboard extends javax.swing.JPanel {

    MainForm main;

    public Dashboard(MainForm main) {
        initComponents();
        this.main = main;
        table1.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
    }

    private void initData() {
        initCardData();
        initTableData();
    }

    private void initTableData() {

        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelBuyer buyer) {
                if (showMessage(("Apakah Anda yakin untuk menghapus data tersebut?"), GoogleMaterialDesignIcons.WARNING)) {
                    // Trigger proses delete data to database
                    try {
                        Connection connect = TrialConnect.createConnection();
                        Statement statement = connect.createStatement();
                        String sql = "DELETE FROM pembeli WHERE id_pembeli = '" + getId(buyer.getName()) + "'";
                        boolean result = statement.execute(sql);
                        if (result) {
                            JOptionPane.showMessageDialog(null, "Sukses!\nData berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Kesalahan sintaks SQL!", "ERROR SQL", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void update(ModelBuyer buyer) {
                // Trigger proses update data to database
                FormEditRiwayat edit = new FormEditRiwayat(Main.getFrames()[0], true, getId(buyer.getName()));
                if (edit.isOk()) {
                    table1.repaint();
                }
                edit.showMessage();
            }
        };

        dataTable1(table1, eventAction);
        dataTable2(table1, eventAction);
    }

    void dataTable1(com.raven.swing.table.Table table1, EventAction eventAction) {
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            String sql1 = "SELECT pembeli.nama_pembeli AS 'NamaPembeli', "
                    + "riwayatmakanan.id_pesananMakanan AS 'IDPesanan', "
                    + "riwayatmakanan.tanggalPesananMakanan AS 'Tgl', "
                    + "makanan.namaMakanan AS 'NamaMakanan', "
                    + "riwayatmakanan.jumlahMakanan AS 'Jumlah', "
                    + "riwayatmakanan.totalHargaMakanan AS 'Total' "
                    + "FROM ((pembeli INNER JOIN riwayatmakanan ON pembeli.id_pembeli = riwayatmakanan.id_pembeli) "
                    + "INNER JOIN makanan ON riwayatmakanan.IDMakanan = makanan.IDMakanan)";
            ResultSet result = statement.executeQuery(sql1);
            while (result.next()) {
                table1.addRow(new ModelBuyer(result.getString("NamaPembeli"), result.getString("IDPesanan"), result.getString("Tgl"), result.getString("NamaMakanan"), result.getInt("Jumlah"), result.getInt("Total")).toRowTable(eventAction));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kesalahan sintaks SQL!", "ERROR SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    void dataTable2(com.raven.swing.table.Table table1, EventAction eventAction) {
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            String sql2 = "SELECT pembeli.nama_pembeli AS 'NamaPembeli', "
                    + "riwayatminuman.id_pesananMinuman AS 'IDPesanan', "
                    + "riwayatminuman.tanggalPesananMinuman AS 'Tgl', "
                    + "minuman.namaMinuman AS 'NamaMinuman', "
                    + "riwayatminuman.jumlahMinuman AS 'Jumlah', "
                    + "riwayatminuman.totalHargaMinuman AS 'Total' "
                    + "FROM ((pembeli INNER JOIN riwayatminuman ON pembeli.id_pembeli = riwayatminuman.id_pembeli) "
                    + "INNER JOIN minuman ON riwayatminuman.IDMinuman = minuman.IDMinuman)";
            ResultSet result2 = statement.executeQuery(sql2);
            while (result2.next()) {
                table1.addRow(new ModelBuyer(result2.getString("NamaPembeli"), result2.getString("IDPesanan"), result2.getString("Tgl"), result2.getString("NamaMinuman"), result2.getInt("Jumlah"), result2.getInt("Total")).toRowTable(eventAction));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kesalahan sintaks SQL!", "ERROR SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    int getId(String name) {
        Connection connect = TrialConnect.createConnection();
        int id = -1;
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT id_pembeli FROM pembeli WHERE nama_pembeli = '" + name + "'";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                id = result.getInt("id_pembeli");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kesalahan sintaks SQL!", "ERROR SQL", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    int getTotal(String nama) {
        Connection connect = TrialConnect.createConnection();
        try {
            nama = nama.toLowerCase();
            Statement statement = connect.createStatement();
            String sql = null;
            if (nama.equals("makanan") || nama.equals("minuman")) {
                sql = "SELECT SUM(stok) AS total FROM " + nama;
            } else {
                sql = "SELECT (SUM(kas_masuk) - SUM(kas_keluar)) AS total FROM kas";
            }
            ResultSet result = statement.executeQuery(sql);
            int sum = 0;
            while (result.next()) {
                sum = result.getInt("total");
            }
            return sum;
        } catch (SQLException ex) {
            return -1;
        }
    }

    private void initCardData() {
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 100));
        card1.setData(new ModelCard("Total Stok Makanan", getTotal("makanan"), 0, icon1));
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_CART, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 100));
        card2.setData(new ModelCard("Total Stok Minuman", getTotal("minuman"), 0, icon2));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 100));
        card3.setData(new ModelCard("Saldo", getTotal("riwayatpesanan"), 0, icon3));
    }

    private boolean showMessage(String message, GoogleMaterialDesignIcons icon) {
        Message obj = new Message(Main.getFrames()[0], true, icon);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        srch = new javax.swing.JTextField();
        refresB = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        card1 = new mainStruktur.Card();
        card2 = new mainStruktur.Card();
        card3 = new mainStruktur.Card();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Kas Masuk");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "ID Pesanan", "Tanggal", "Pesanan", "Banyak", "Total Biaya", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        srch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        srch.setForeground(new java.awt.Color(204, 204, 204));
        srch.setText("Cari data dalam tabel");
        srch.setToolTipText("");
        srch.setName("Cari data dalam tabel..."); // NOI18N
        srch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                srchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                srchFocusLost(evt);
            }
        });
        srch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                srchKeyPressed(evt);
            }
        });

        refresB.setBackground(new java.awt.Color(255, 255, 255));
        refresB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pct/refresh.png"))); // NOI18N
        refresB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(srch, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(srch)
                    .addComponent(refresB, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        card1.setBackground(new java.awt.Color(51, 51, 255));
        card1.setForeground(new java.awt.Color(255, 255, 255));
        card1.setToolTipText("");
        card1.setColorGradient(new java.awt.Color(51, 51, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel3.add(card1, gridBagConstraints);

        card2.setBackground(new java.awt.Color(255, 153, 0));
        card2.setForeground(new java.awt.Color(255, 255, 255));
        card2.setColorGradient(new java.awt.Color(255, 153, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel3.add(card2, gridBagConstraints);

        card3.setBackground(new java.awt.Color(0, 204, 51));
        card3.setForeground(new java.awt.Color(255, 255, 255));
        card3.setColorGradient(new java.awt.Color(0, 204, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(card3, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void refresBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresBActionPerformed
        main.showForm(new Dashboard(main));
    }//GEN-LAST:event_refresBActionPerformed

    private void srchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srchKeyPressed
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table1.getModel());
        table1.setRowSorter(rowSorter);

        srch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!srch.getText().equals("Cari data dalam tabel")) {
                    String text = srch.getText();
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!srch.getText().equals("Cari data dalam tabel")) {
                    String text = srch.getText();
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }//GEN-LAST:event_srchKeyPressed

    private void srchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_srchFocusGained
        if (srch.getText().equals("Cari data dalam tabel")) {
            srch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            srch.setText("");
            srch.setForeground(Color.black);
        }

    }//GEN-LAST:event_srchFocusGained

    private void srchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_srchFocusLost
        if (srch.getText().isEmpty()) {
            srch.setFont(new Font("Segoe UI", Font.BOLD, 18));
            srch.setText("Cari data dalam tabel");
            srch.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_srchFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mainStruktur.Card card1;
    private mainStruktur.Card card2;
    private mainStruktur.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresB;
    private javax.swing.JTextField srch;
    public com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
