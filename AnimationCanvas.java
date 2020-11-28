
/**
 * @author axl
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.Toolkit;

public class AnimationCanvas extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    String[] elements;
    Graphics2D drawImage;
    Graphics pen;
    Image imageTren, imageSuburbano, imageTrailer, imageAutomovil;
    Thread thread = new Thread(this);
    int j;

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
        drawComponentsWhileAnimation();
        draw_initial_selected_elements();
    }

    public void drawComponentsWhileAnimation() {
        pen.drawString("META", 1150, 250);
        pen.drawLine(1100, 20, 1100, 500);
        pen.drawLine(1101, 20, 1101, 500);
        pen.drawLine(1102, 20, 1102, 500);
    }

    public void startAnimation() {
        thread.start();
    }

    public void draw_initial_selected_elements() {
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

    @Override
    public void run() {
        try {
            repaint();
            drawComponentsWhileAnimation();
            for (j = 0; j < 1000; j++) {
                if (imageTren != null) {
                    pen.drawImage(imageTren, j, 150, this);
                }
                if (imageSuburbano != null) {
                    pen.drawImage(imageSuburbano, j, 250, this);
                }
                if (imageTrailer != null) {
                    pen.drawImage(imageTrailer, j, 350, this);
                }
                if (imageAutomovil != null) {
                    pen.drawImage(imageAutomovil, j, 450, this);
                }
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
