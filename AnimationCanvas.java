
/**
 *
 * @author axl
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class AnimationCanvas extends Canvas {

    // FIELDS
    public int WIDTH = 1024;
    public int HEIGHT = 720;

    // METHODS
    public void start() {
        configurationString = readConfigurationFromFile();
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
    }

    public void paint(Graphics g) {
        for (int i = 0; i <= configurationString.length; i++) {
            g.setColor(Color.WHITE);
            g.fillRect(0 + (i * 10), 0 + (i * 10), WIDTH, HEIGHT);
            g.setColor(Color.BLACK);
            g.fillOval(10, 10, 30, 30);
        }
    }

    public String[] readConfigurationFromFile() {
        try {
            objReader = new BufferedReader(new FileReader("config.txt"));
            // while ((strCurrentLine = objReader.readLine()) != null) {
            strCurrentLine = objReader.readLine();
            strNoLeftbrackets = strCurrentLine.replace("[", "");
            strNoRightBrackets = strNoLeftbrackets.replace("]", "");
            strFinal = strNoRightBrackets.split(",");
            // }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return strFinal;
    }

    BufferedReader objReader;
    String strCurrentLine, strNoLeftbrackets, strNoRightBrackets;
    String[] strFinal, configurationString;
}
