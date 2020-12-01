
/**
 * @author axl
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

public class AnimationCanvas extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    Image imageTren, imageSuburbano, imageTrailer, imageAutomovil;
    Thread thread = new Thread(this);
    Speed speed = new Speed();
    String[] elements;
    Graphics2D drawImage;
    Graphics pen;
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
        drawScoreBoard();
        draw_initial_selected_elements();
    }

    public void drawComponentsWhileAnimation() {
        pen.drawLine(100, 150, 100, 500);
        pen.drawLine(1100, 150, 1100, 500);
        pen.drawString("DESTINO", 1110, 325);
    }

    public void drawScoreBoard() {
        // square containing values
        pen.setColor(Color.RED);
        pen.drawRect(100, 5, 900, 130);
        pen.setColor(Color.BLUE);
        // Titles:
        pen.drawString("Velocidad inicial (v):", 130, 40);
        pen.drawString("Fuerza (f):", 130, 60);
        pen.drawString("Aceleracion: (a):", 130, 80);
        pen.drawString("Coeficiente de friccion (µ):", 130, 100);
        pen.drawString("Aceleraciond de la gravedad (g):", 130, 120);
    }

    public void startAnimation() {
        thread.start();
    }

    public void draw_initial_selected_elements() {
        if (imageTren != null) {
            pen.drawImage(imageTren, 0 - 100, 150, this);
        }
        if (imageSuburbano != null) {
            pen.drawImage(imageSuburbano, 0 - 100, 250, this);
        }
        if (imageTrailer != null) {
            pen.drawImage(imageTrailer, 0 - 100, 350, this);
        }
        if (imageAutomovil != null) {
            pen.drawImage(imageAutomovil, 0 - 100, 450, this);
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
        int gP = 1100;
        int sP = 100;
        long startTime = System.currentTimeMillis();
        try {
            for (j = 1; j <= 1000; j++) {
                // time comparison
                long elapsedTime = System.currentTimeMillis() - startTime;
                long elapsedSeconds = elapsedTime / 1000;

                pen.clearRect(350, 30, 500, 100);
                pen.clearRect(0, 150, 1098, 450);
                if (imageTren != null) {
                    pen.setColor(Color.BLUE);
                    pen.drawString("TREN", 350, 20);
                    pen.setColor(Color.BLACK);
                    pen.drawString(String.valueOf(speed.calculate(elapsedSeconds, gP, sP - j)) + " m/s", 350, 40);
                    pen.drawString(String.valueOf(j), 350, 60);
                    pen.drawString(String.valueOf(j), 350, 80);
                    pen.drawString(String.valueOf(j), 350, 100);
                    pen.drawString(String.valueOf(j), 350, 120);
                    pen.drawImage(imageTren, j - 100, 150, this);
                }
                if (imageSuburbano != null) {
                    pen.setColor(Color.BLUE);
                    pen.drawString("TREN MEX-TOL", 500, 20);
                    pen.setColor(Color.BLACK);
                    pen.drawString(String.valueOf(j), 500, 40);
                    pen.drawString(String.valueOf(j), 500, 60);
                    pen.drawString(String.valueOf(j), 500, 80);
                    pen.drawString(String.valueOf(j), 500, 100);
                    pen.drawString(String.valueOf(j), 500, 120);
                    pen.drawImage(imageSuburbano, j - 100, 250, this);
                }
                if (imageTrailer != null) {
                    pen.setColor(Color.BLUE);
                    pen.drawString("TRAILER NOM(012)", 650, 20);
                    pen.setColor(Color.BLACK);
                    pen.drawString(String.valueOf(j), 650, 40);
                    pen.drawString(String.valueOf(j), 650, 60);
                    pen.drawString(String.valueOf(j), 650, 80);
                    pen.drawString(String.valueOf(j), 650, 100);
                    pen.drawString(String.valueOf(j), 650, 120);
                    pen.drawImage(imageTrailer, j - 100, 350, this);
                }
                if (imageAutomovil != null) {
                    pen.setColor(Color.BLUE);
                    pen.drawString("AUTO FAMILIAR", 800, 20);
                    pen.setColor(Color.BLACK);
                    pen.drawString(String.valueOf(j), 800, 40);
                    pen.drawString(String.valueOf(j), 800, 60);
                    pen.drawString(String.valueOf(j), 800, 80);
                    pen.drawString(String.valueOf(j), 800, 100);
                    pen.drawString(String.valueOf(j), 800, 120);
                    pen.drawImage(imageAutomovil, j - 100, 450, this);
                }
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
