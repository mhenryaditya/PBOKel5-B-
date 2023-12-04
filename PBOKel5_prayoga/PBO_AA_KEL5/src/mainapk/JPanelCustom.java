package mainapk;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class JPanelCustom extends JPanel {
    
    private int radius;
    private Color borderColor;
    int shadowSize = 6;
    float shadowOpacity = 0.5f;
    private Color shadowColor = Color.GRAY;
    
    public JPanelCustom(){
        radius = 25;
        borderColor = Color.WHITE;
        setOpaque(false);
        setSize(200, 300);
        
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
}
