
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
    Graphics2D drawImage;
    Graphics pen;
    Image imageTren, imageSuburbano, imageTrailer, imageAutomovil;

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

        if (imageTren != null) {
            pen.drawImage(imageTren, 20, 150, this);
        }
        if (imageSuburbano != null) {
            pen.drawImage(imageSuburbano, 20, 250, this);
        }
        if (imageTrailer != null) {
            pen.drawImage(imageTrailer, 20, 350, this);
        }
        if (imageAutomovil != null) {
            pen.drawImage(imageAutomovil, 20, 450, this);
        }
    }

    public void updateGraphics() {
        pen.drawString("CHANGED VALUES", 350, 350);
    }

    public void assignImagesFromConfiguration(String[] configurationElements) {
        for (int i = 0; i < configurationElements.length; i++) {
            System.out.println(configurationElements[i]);
            if (configurationElements[i].equals("Tren")) {
                imageTren = Toolkit.getDefaultToolkit().getImage("resources/images/train.png");
            } else if (configurationElements[i].equals("TrenMexicoToluca")) {
                imageSuburbano = Toolkit.getDefaultToolkit().getImage("resources/images/interurbano.png");
            } else if (configurationElements[i].equals("Trailer(NOM012)")) {
                imageTrailer = Toolkit.getDefaultToolkit().getImage("resources/images/trailer.png");
            } else if (configurationElements[i].equals("AutomovilFamiliar")) {
                imageAutomovil = Toolkit.getDefaultToolkit().getImage("resources/images/auto.png");
            }
        }
    }
}
