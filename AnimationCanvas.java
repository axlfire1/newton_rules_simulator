
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
    SecondNewtonLaw secondNewtonLaw;
    Image imageTren, imageSuburbano, imageTrailer, imageAutomovil;
    Thread thread = new Thread(this);
    String[] elements;
    Graphics2D drawImage;
    Graphics pen;
    int j;

    public AnimationCanvas() {
        setBounds(10, 30, 1223, 535);
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
        pen.drawLine(100, 180, 100, 530);
        pen.drawLine(1100, 180, 1100, 530);
        pen.drawString("DESTINO", 1110, 325);
    }

    public void drawScoreBoard() {
        // square containing values
        pen.setColor(Color.RED);
        pen.drawRect(100, 5, 900, 160);
        pen.setColor(Color.BLUE);
        // Titles:
        pen.drawString("Masa (m):", 130, 40);
        pen.drawString("Velocidad Inicial:", 130, 60);
        pen.drawString("Velocidad Final:", 130, 80);
        pen.drawString("Tiempo:", 130, 100);
        pen.drawString("Aceleracion:", 130, 120);
        pen.drawString("Fuerza:", 130, 140);
    }

    public void startAnimation() {
        thread.start();
    }

    public void draw_initial_selected_elements() {
        if (imageTren != null) {
            pen.drawImage(imageTren, 0 - 100, 200, this);
        }
        if (imageSuburbano != null) {
            pen.drawImage(imageSuburbano, 0 - 100, 280, this);
        }
        if (imageTrailer != null) {
            pen.drawImage(imageTrailer, 0 - 100, 380, this);
        }
        if (imageAutomovil != null) {
            pen.drawImage(imageAutomovil, 0 - 100, 480, this);
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
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        try {
            for (j = 1; j <= 1000; j++) {// time comparison
                elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                pen.clearRect(350, 30, 550, 130);
                pen.clearRect(0, 180, 1098, 480);
                if (imageTren != null) {
                    secondNewtonLaw = new SecondNewtonLaw(j, 14000.0, "train");
                    pen.setColor(Color.BLUE);
                    pen.drawString("TREN", 350, 20);
                    pen.setColor(Color.BLACK);
                    pen.drawString(String.valueOf(secondNewtonLaw.mass) + " kg", 350, 40);
                    pen.drawString(String.valueOf(1) + " m/s", 350, 60);
                    pen.drawString(String.valueOf(j) + " m/s", 350, 80);
                    pen.drawString(String.valueOf(elapsedTime) + " s", 350, 100);
                    pen.drawString(String.valueOf(secondNewtonLaw.calculateAcceleration() + " m/s2"), 350, 120);
                    pen.drawString(String.valueOf(secondNewtonLaw.calculateForce() + " Kg*m/s2"), 350, 140);
                    pen.drawImage(imageTren, j - 100, 180, this);
                }
                if (imageSuburbano != null) {
                    secondNewtonLaw = new SecondNewtonLaw(j, 1070.0, "interurban");
                    pen.setColor(Color.BLUE);
                    pen.drawString("TREN MEX-TOL", 500, 20);
                    pen.setColor(Color.BLACK);
                    pen.drawString(String.valueOf(secondNewtonLaw.mass) + " kg", 500, 40);
                    pen.drawString(String.valueOf(1) + " m/s", 500, 60);
                    pen.drawString(String.valueOf(j) + " m/s", 500, 80);
                    pen.drawString(String.valueOf(elapsedTime) + " s", 500, 100);
                    pen.drawString(String.valueOf(secondNewtonLaw.calculateAcceleration() + " m/s2"), 500, 120);
                    pen.drawString(String.valueOf(secondNewtonLaw.calculateForce() + " Kg*m/s2"), 500, 140);

                    pen.drawImage(imageSuburbano, j - 100, 280, this);
                }
                if (imageTrailer != null) {
                    secondNewtonLaw = new SecondNewtonLaw(j, 80.0, "trailer");
                    pen.setColor(Color.BLUE);
                    pen.drawString("TRAILER NOM(012)", 650, 20);
                    pen.setColor(Color.BLACK);
                    pen.drawString(String.valueOf(secondNewtonLaw.mass) + " kg", 650, 40);
                    pen.drawString(String.valueOf(1) + " m/s", 650, 60);
                    pen.drawString(String.valueOf(j) + " m/s", 650, 80);
                    pen.drawString(String.valueOf(elapsedTime) + " s", 650, 100);
                    pen.drawString(String.valueOf(secondNewtonLaw.calculateAcceleration() + " m/s2"), 650, 120);
                    pen.drawString(String.valueOf(secondNewtonLaw.calculateForce() + " Kg*m/s2"), 650, 140);

                    pen.drawImage(imageTrailer, j - 100, 380, this);
                }
                if (imageAutomovil != null) {
                    secondNewtonLaw = new SecondNewtonLaw(j, 1.330, "auto");
                    pen.setColor(Color.BLUE);
                    pen.drawString("AUTO FAMILIAR", 800, 20);
                    pen.setColor(Color.BLACK);
                    pen.drawString(String.valueOf(secondNewtonLaw.mass) + " kg", 800, 40);
                    pen.drawString(String.valueOf(1) + " m/s", 800, 60);
                    pen.drawString(String.valueOf(j) + " m/s", 800, 80);
                    pen.drawString(String.valueOf(elapsedTime) + " s", 800, 100);
                    pen.drawString(String.valueOf(secondNewtonLaw.calculateAcceleration() + " m/s2"), 800, 120);
                    pen.drawString(String.valueOf(secondNewtonLaw.calculateForce() + " Kg*m/s2"), 800, 140);

                    pen.drawImage(imageAutomovil, j - 100, 480, this);
                }
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
