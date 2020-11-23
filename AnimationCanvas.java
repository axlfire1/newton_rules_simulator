
/**
 * @author axl
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class AnimationCanvas extends java.awt.Canvas {

    private static final long serialVersionUID = 1L;
    ConfigurationFile configurationFile;
    String[] configurationElements;
    Graphics2D drawImage;

    public AnimationCanvas() {
        configurationElements = new ConfigurationFile().readElements();
        setBounds(10, 30, 1223, 515);
        setBackground(Color.WHITE);
    }

    public void paint(Graphics g) {
        drawImage = (Graphics2D) g;
    }

    public void initialValues() {
        System.out.println(configurationElements[0]);
        drawImage.drawString(configurationElements[0], 300, 300);
        repaint();
    }

    public void updateGraphics(int height, int width) {
        System.out.println(configurationElements[1]);
        drawImage.drawString(configurationElements[1], 300, 300);
        repaint();
    }
}
