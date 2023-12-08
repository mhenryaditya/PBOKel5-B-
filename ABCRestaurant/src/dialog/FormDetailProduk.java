package dialog;

import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mainapk.TrialConnect;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class FormDetailProduk extends javax.swing.JDialog {

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    private boolean ok;
    private final Animator animator;
    private boolean show = true;
    private String[] idSplit;

    public FormDetailProduk(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        setSize(getWidth(), getHeight());
        initComponents();
        setOpacity(0f);
        getContentPane().setBackground(Color.WHITE);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (show == false) {
                    setVisible(false);
                }
            }

        };
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        lbIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(254, 86, 96), new Color(113, 74, 67)));
        this.idSplit = id.split("-");
    }

    public void showMessage() {
        animator.start();
        Connection connect = TrialConnect.createConnection();
        try {
            Statement statement = connect.createStatement();
            ResultSet result = null;
            if (idSplit[1].equals("m")) {
                String sql = "SELECT * FROM makanan WHERE IDMakanan = '" + idSplit[0] + "'";
                result = statement.executeQuery(sql);
                result.next();
                name.setText(result.getString("namaMakanan"));
            } else {
                String sql = "SELECT * FROM minuman WHERE IDMinuman = '" + idSplit[0] + "'";
                result = statement.executeQuery(sql);
                result.next();
                name.setText(result.getString("namaMinuman"));
            }
            desk.setText(result.getString("deskripsi"));
            stok.setText(result.getString("stok"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR SQL \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        prosesBeli = new com.raven.swing.Button();
        cancel = new com.raven.swing.Button();
        lbIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        stok = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desk = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        lbMessage.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage.setText("Detail Produk");

        prosesBeli.setBackground(new java.awt.Color(0, 0, 255));
        prosesBeli.setForeground(new java.awt.Color(255, 255, 255));
        prosesBeli.setText("Proses Pembelian");
        prosesBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesBeliActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(255, 0, 51));
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Nama Produk");

        jLabel2.setText("Deskripsi Produk");

        jLabel3.setText("Stok Ketersediaan");

        name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        name.setText("jLabel4");

        stok.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        stok.setText("jLabel6");

        desk.setColumns(20);
        desk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desk.setLineWrap(true);
        desk.setRows(5);
        desk.setWrapStyleWord(true);
        jScrollPane1.setViewportView(desk);
        desk.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prosesBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbIcon)
                        .addGap(18, 18, 18)
                        .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prosesBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prosesBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesBeliActionPerformed
        ok = true;
        closeMenu();
    }//GEN-LAST:event_prosesBeliActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        ok = false;
        closeMenu();
    }//GEN-LAST:event_cancelActionPerformed

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button cancel;
    private javax.swing.JTextArea desk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel name;
    private com.raven.swing.Button prosesBeli;
    private javax.swing.JLabel stok;
    // End of variables declaration//GEN-END:variables
}
