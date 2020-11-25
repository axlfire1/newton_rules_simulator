
/**
 * @author axl
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.Toolkit;

public class AnimationCanvas extends Canvas {

    private static final long serialVersionUID = 1L;
    private Graphics2D drawImage;
    private Graphics pen;

    public AnimationCanvas() {
        setBounds(10, 30, 1223, 515);
        setBackground(java.awt.Color.WHITE);
    }

    public void paint(Graphics g) {
        drawImage = (Graphics2D) g;
        pen = drawImage.create();
    }

    public void initialValues(String[] configurationElements) {
        assignImagesFromConfiguration(configurationElements);
        Image imageTren = Toolkit.getDefaultToolkit().getImage("resources/images/train.png");
        Image imageSuburbano = Toolkit.getDefaultToolkit().getImage("resources/images/interurbano.png");
        Image imageTrailer = Toolkit.getDefaultToolkit().getImage("resources/images/trailer.png");
        Image imageAutomovil = Toolkit.getDefaultToolkit().getImage("resources/images/auto.png");

        pen.drawImage(imageTren, 20, 150, this);
        pen.drawImage(imageSuburbano, 20, 250, this);
        pen.drawImage(imageTrailer, 20, 350, this);
        pen.drawImage(imageAutomovil, 20, 450, this);
    }

    public void updateGraphics() {
        pen.drawString("CHANGED VALUES", 350, 350);
    }

    public void assignImagesFromConfiguration(String[] configurationElements) {
        System.out.println(configurationElements[0]);
    }
}
