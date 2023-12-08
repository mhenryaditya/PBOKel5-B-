package mainapk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonCustom extends JButton implements ActionListener{
    
    public ButtonCustom() {
        setBackground(new Color(25, 68, 233));
        setForeground(Color.WHITE);
        setText("Tombol");
        setBorderColor(new Color(25, 68, 233, 1));
        setRadius(30);
        setContentAreaFilled(false);
    }
    
    

//    public void setOver(boolean over) {
//        this.over = over;
//    }
//
//    public void setColor(Color color) {
//        this.color = color;
//    }
//
//    public void setColorOver(Color colorOver) {
//        this.colorOver = colorOver;
//    }
//
//    public void setColorClicked(Color colorClicked) {
//        this.colorClicked = colorClicked;
//    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        Graphics2D g2 = (Graphics2D)graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(graphics);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
//    private boolean over;
//    private Color color;
//    private Color colorOver;
//    private Color colorClicked;
    private Color borderColor;
    private int radius;

}
