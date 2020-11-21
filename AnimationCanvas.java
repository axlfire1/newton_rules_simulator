
/**
 *
 * @author axl
 */

import java.io.FileReader;
import javax.swing.JOptionPane;
import java.io.BufferedReader;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class AnimationCanvas extends Canvas {

    public AnimationCanvas() {
        readConfigurationFromFile();
        setBounds(10, 30, 1223, 515);
        setBackground(Color.GRAY);
    }

    // METHODS

    public void paint(Graphics g) {
        g.drawString(readConfigurationFromFile()[1], 300, 300);
    }

    public void paintConfigurationElements(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(75, 75, 150, 75);
    }

    // READ FILE METHODS

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

    // File Attributes

    BufferedReader objReader;
    String strCurrentLine, strNoLeftbrackets, strNoRightBrackets;
    String[] strFinal, configurationString;
}
