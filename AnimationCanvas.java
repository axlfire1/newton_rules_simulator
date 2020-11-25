
/**
 * @author axl
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;

public class AnimationCanvas extends Canvas {

    private static final long serialVersionUID = 1L;
    Graphics2D drawImage;
    Graphics temp;

    public AnimationCanvas() {
        setBounds(10, 30, 1223, 515);
    }

    public void paint(Graphics g) {
        drawImage = (Graphics2D) g;
        temp = drawImage.create();
    }

    public void initialValues(String[] configurationElements) {
        temp.drawString(configurationElements[0], 300, 300);
        temp.drawString(configurationElements[1], 300, 350);
    }

    public void updateGraphics() {
        temp.drawString("CHANGED VALUES", 350, 350);
    }
}
