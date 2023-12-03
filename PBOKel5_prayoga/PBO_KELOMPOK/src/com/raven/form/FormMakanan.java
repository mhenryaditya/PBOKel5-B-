package com.raven.form;

import com.raven.form.Makanan.FormPembelian;
import com.raven.model2.Model_Card;
import com.raven.swing2.ScrollBar;
import com.raven.swing2.WrapLayout;
import javax.swing.ImageIcon;

public class FormMakanan extends javax.swing.JPanel {

    public FormMakanan() {
        initComponents();
        init();

    }

    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/nasi-goreng-from-indonesia-in-illustration-vector-removebg-preview.png")), "Nasi Goreng", "Harga : \n       Rp. 35.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/65f26bce6c7502b469ff8ffe3a02e35a-removebg-preview.png")), "Sate Ayam", "Harga : \n       Rp. 25.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/rendang.png")), "Rendang Daging", "Harga : \n       Rp. 50.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/gado gado.png")), "Gado-Gado", "Harga : \n       Rp. 30.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/soto ayam.png")), "Soto Ayam", "Harga : \n       Rp. 40.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/pecel lele.png")), "Pecel Lele", "Harga : \n       Rp. 35.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/nasi Padang.png")), "Nasi Padang", "Harga : \n       Rp. 60.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/bakso malang.png")), "Bakso Malang", "Harga : \n       Rp. 25.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/ayam goreng Kalasan.png")), "Ayam Goreng", "Harga : \n       Rp. 45.000\nStok : \n       20")));
        panel.add(new com.raven.component2.Card(new Model_Card(new ImageIcon(getClass().getResource("/fotoMenu/lontong sayur Betawi.png")), "Lontong Sayur", "Harga : \n       Rp. 30.000\nStok : \n       20")));
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
                .addComponent(jScrollPane1)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
