package com.raven.form;

import com.raven.model2.Model_Card;
import com.raven.swing2.ScrollBar;
import com.raven.swing2.WrapLayout;
import javax.swing.ImageIcon;

public class FormMinuman extends javax.swing.JPanel {

    public FormMinuman() {
        initComponents();
        init();
    }
    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es teh.png")), "Es Teh Manis", "Harga : \n       Rp. 5.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es jeruk.png")), "Es Jeruk Segar", "Harga : \n       Rp. 8.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/wedang jahe.png")), "Wedang Jahe", "Harga : \n       Rp. 10.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es cincau hijau.png")), "Es Cincau Hijau", "Harga : \n       Rp. 15.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/sekoteng.png")), "Sekoteng", "Harga : \n       Rp. 12.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/bandrek.png")), "Bandrek", "Harga : \n       Rp. 10.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es Doger.png")), "Es Doger", "Harga : \n       Rp. 20.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/biar pletok.png")), "Bir Pletok", "Harga : \n       Rp. 25.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/es cendol.png")), "Es Cendol", "Harga : \n       Rp. 18.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/teh tarik.png")), "Es Tarik", "Harga : \n       Rp. 12.000\nStok : \n       20")));
        panel.revalidate();
        panel.repaint();
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
