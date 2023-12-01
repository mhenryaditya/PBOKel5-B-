package mainapk;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class CustomPanelGradient extends JPanel {
//    
//    @Override
//    protected void paintComponent(Graphics g){
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D)g;
//        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        int w = getWidth(), h = getHeight();
//        Color color1 = new Color(234, 71, 19);
//        Color color2 = new Color(234, 135, 35);
//        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
//        g2d.setPaint(gp);
//        g2d.fillRect(0, 0, w, h);
//    }
    
    private Color color1;
    private Color color2;
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
//        Color color1 = new Color(0, 66, 255);
//        Color color2 = new Color(0, 216, 255);
        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
    
    public void setColor1(int r, int g, int b){
        color1 = new Color(r, g, b);
    }
    
    public void setColor2(int r, int g, int b){
        color2 = new Color(r, g, b);
    }
    
}
