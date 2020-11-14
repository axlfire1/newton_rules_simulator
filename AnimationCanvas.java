
/**
 *
 * @author axl
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class AnimationCanvas extends Canvas {

    // FIELDS
    public int WIDTH = 1024;
    public int HEIGHT = 720;

    // METHODS
    public void start() {
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.fillOval(10, 10, 30, 30);
    }
}
