package mainapk;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setTitle("Login Application - ABC Restaurant");
        setSize(getWidth() + 200, getHeight());
        setLocationRelativeTo(null);

        // Set Favicon App
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pct/logo-removebg-preview.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        customPanelGradient1 = new mainapk.CustomPanelGradient();
        container = new mainapk.JPanelCustom();
        left = new mainapk.JPanelCustom();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        right = new mainapk.JPanelCustom();
        mainForm = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        username = new mainapk.TextFieldCustom();
        password = new mainapk.JPasswordCustom();
        buttontoLogin = new mainapk.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customPanelGradient1.setLayout(new java.awt.GridBagLayout());

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new java.awt.GridBagLayout());

        left.setBackground(new java.awt.Color(234, 135, 35));
        left.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pct/Chef-bro1.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        left.add(jLabel1, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pct/FullLogo-removebg-preview1.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(35, 0, 0, 0);
        left.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        container.add(left, gridBagConstraints);

        right.setBackground(new java.awt.Color(255, 255, 255));
        right.setLayout(new java.awt.GridBagLayout());

        mainForm.setBackground(new java.awt.Color(255, 255, 255));
        mainForm.setLayout(new java.awt.GridBagLayout());

        jLabel3.setBackground(new java.awt.Color(234, 135, 35));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(234, 135, 35));
        jLabel3.setText("Login Aplikasi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        mainForm.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Silakan masukkan username dan password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        mainForm.add(jLabel4, gridBagConstraints);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pct/user.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 9, 10);
        mainForm.add(jLabel5, gridBagConstraints);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pct/lock.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 10);
        mainForm.add(jLabel6, gridBagConstraints);

        username.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        username.setLabelText("Username");
        username.setLineColor(new java.awt.Color(255, 153, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        mainForm.add(username, gridBagConstraints);

        password.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        password.setLabelText("Password");
        password.setLineColor(new java.awt.Color(255, 153, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        mainForm.add(password, gridBagConstraints);

        buttontoLogin.setBackground(new java.awt.Color(255, 153, 0));
        buttontoLogin.setText("Login");
        buttontoLogin.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttontoLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttontoLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttontoLoginMouseExited(evt);
            }
        });
        buttontoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttontoLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        mainForm.add(buttontoLogin, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 30);
        right.add(mainForm, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        container.add(right, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(150, 100, 150, 100);
        customPanelGradient1.add(container, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customPanelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customPanelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttontoLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttontoLoginMouseEntered
        buttontoLogin.setBackground(new Color(252, 176, 73));
        setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_buttontoLoginMouseEntered

    private void buttontoLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttontoLoginMouseExited
        buttontoLogin.setBackground(new Color(255, 153, 0));
        setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_buttontoLoginMouseExited

    private void buttontoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttontoLoginActionPerformed
        String usr = username.getText();
        char[] pass = password.getPassword();
        String password = "";
        for (char i : pass) {
            password += i;
        }
        toLogin(usr, password);
    }//GEN-LAST:event_buttontoLoginActionPerformed

    void toLogin(String username, String password) {
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            String sql = "SELECT * FROM staff";
            ResultSet hasil = statement.executeQuery(sql);
            int id = 0;
            boolean cek = false;
            while (hasil.next()) {
                if (hasil.getString("username").equals(username) && hasil.getString("pass").equals(password)) {
                    id = hasil.getInt("IDStaff");
                    cek = true;
                    break;
                }
            }
            if (cek) {
                JOptionPane.showMessageDialog(null, "Login berhasil!");
                // Application move to the Dashboard view
                MainApplication main = new MainApplication(id);
                main.setMainAPP(main);
                main.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login gagal!\nUsername atau password salah.\nSilakan coba kembali!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kesalahan!\nError Log : " + ex);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mainapk.ButtonCustom buttontoLogin;
    private mainapk.JPanelCustom container;
    private mainapk.CustomPanelGradient customPanelGradient1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private mainapk.JPanelCustom left;
    private javax.swing.JPanel mainForm;
    private mainapk.JPasswordCustom password;
    private mainapk.JPanelCustom right;
    private mainapk.TextFieldCustom username;
    // End of variables declaration//GEN-END:variables
}
