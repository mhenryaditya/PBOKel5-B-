package form;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import mainapk.TrialConnect;

public class KasManager extends javax.swing.JPanel {

    private MainForm main;
    private Connection connect = TrialConnect.createConnection();
    private LocalDate currentDate = LocalDate.now();
    private int typed;
    private int sumDbt;
    private String namaPegawai;
    
    public KasManager(MainForm main, String namaPegawai) {
        this.main = main;
        this.namaPegawai = namaPegawai;
        initComponents();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        judulDesk = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        submitData = new com.raven.swing.Button();
        cstName = new mainapk.TextFieldCustom();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        backHome = new com.raven.swing.ButtonBadges();
        listPilihan = new javax.swing.JComboBox<>();
        countPay = new mainapk.TextFieldCustom();
        showMoney = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel9.setText("Nama Pegawai");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 30, 5, 30);
        jPanel2.add(jLabel9, gridBagConstraints);

        judulDesk.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        judulDesk.setForeground(new java.awt.Color(76, 76, 76));
        judulDesk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulDesk.setText("Keuangan");
        judulDesk.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 15, 15);
        jPanel2.add(judulDesk, gridBagConstraints);

        jLabel10.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 30);
        jPanel2.add(jLabel10, gridBagConstraints);

        submitData.setBackground(new java.awt.Color(0, 153, 0));
        submitData.setForeground(new java.awt.Color(255, 255, 255));
        submitData.setText("Proses");
        submitData.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        submitData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel2.add(submitData, gridBagConstraints);
        if (cstName.getText().isEmpty() && countPay.getText().isEmpty()) {
            submitData.setEnabled(false);
        } else {
            submitData.setEnabled(true);
        }
        if(!submitData.isEnabled()){
            submitData.setBackground(new Color(158, 228, 154));
        } else {
            submitData.setBackground(new Color(0, 153, 0));
        }

        cstName.setEnabled(false);
        cstName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cstName.setLabelText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 409;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 10, 30);
        jPanel2.add(cstName, gridBagConstraints);
        cstName.setText(namaPegawai);

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel11.setText("Ringkasan Penarikan");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 10, 30);
        jPanel2.add(jLabel11, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Tanggal penarikan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 10, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Jumlah penarikan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 10, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Tujuan penarikan : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 15, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        name.setText(currentDate + "");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 164;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 30);
        jPanel2.add(name, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 11);
        jPanel2.add(backHome, gridBagConstraints);

        listPilihan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        String[] list = new String[3];
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT * FROM ref_kas WHERE id_ref_ket != '1'";
            ResultSet result = statement.executeQuery(sql);

            int i = 0;
            while(result.next()){
                list[i] = result.getString("id_ref_ket") + " - " + result.getString("keterangan");
                i++;
            }
        } catch (SQLException e) {
            System.out.println(e);
            for (int i = 0; i < list.length; i++){
                list[i] = "NULL - NULL VALUE!!";
            }
        }
        listPilihan.setModel(new javax.swing.DefaultComboBoxModel<>(list));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 381;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 15, 30);
        jPanel2.add(listPilihan, gridBagConstraints);

        countPay.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        countPay.setLabelText("Penarikan");
        countPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                countPayKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 257;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 30);
        jPanel2.add(countPay, gridBagConstraints);

        showMoney.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        String money = "", debit = "", kredit = "";
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT SUM(kas_masuk) - SUM(kas_keluar) AS 'Total', SUM(kas_masuk) AS 'Debit', SUM(kas_keluar) AS 'Kredit' FROM kas";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                money = result.getString("Total");
                debit = result.getString("Debit");
                kredit = result.getString("Kredit");
            }
            sumDbt = Integer.parseInt(debit);
        } catch (SQLException e) {
            System.out.println(e);
        }
        showMoney.setText("Total Kas : Rp" + money + "                Debit : Rp" + debit + "                Kredit : Rp" + kredit);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 30, 15, 30);
        jPanel2.add(showMoney, gridBagConstraints);

        jLabel12.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 30);
        jPanel2.add(jLabel12, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        jPanel3.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void submitDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitDataActionPerformed
        if (cstName.getText().isEmpty() || countPay.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data isian tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean cek = true;
            for (int i = 0; i < countPay.getText().length(); i++) {
                if ((int)(countPay.getText().charAt(i)) < 48 || (int)(countPay.getText().charAt(i)) > 57) {
                    cek = false;
                    break;
                }
            }
            if (cek) {
                if (Integer.parseInt(countPay.getText()) > 0 && Integer.parseInt(countPay.getText()) <= sumDbt) {
                    if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin untuk menarik uang?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        try {
                            Statement statement = connect.createStatement();
                            String sql = "INSERT INTO kas (kas_keluar,id_ref_ket) VALUES ('" + countPay.getText() + "','" + (listPilihan.getSelectedIndex() + 2) + "')";
                            statement.execute(sql);
                            JOptionPane.showMessageDialog(null, "Uang berhasil ditarik", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                            main.showForm(new KasManager(main, namaPegawai));
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Penarikan kas tidak sesuai!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Inputan invalid!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_submitDataActionPerformed

    private void backHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backHomeActionPerformed
        main.showForm(new Dashboard(main));
    }//GEN-LAST:event_backHomeActionPerformed

    private void countPayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_countPayKeyPressed
        if (countPay.getText().isEmpty()) {
            typed = 0;
        } else {
            typed = 1;
        }
        
        if (typed == 0) {
            submitData.setEnabled(false);
            submitData.setBackground(new Color(158, 228, 154));
        } else {
            submitData.setEnabled(true);
            submitData.setBackground(new Color(0, 153, 0));
        }
        
    }//GEN-LAST:event_countPayKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.ButtonBadges backHome;
    private mainapk.TextFieldCustom countPay;
    private mainapk.TextFieldCustom cstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel judulDesk;
    private javax.swing.JComboBox<String> listPilihan;
    private javax.swing.JLabel name;
    private javax.swing.JLabel showMoney;
    private com.raven.swing.Button submitData;
    // End of variables declaration//GEN-END:variables
}
