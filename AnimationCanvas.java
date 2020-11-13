/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newton_rules_simulator;

/**
 *
 * @author axl
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class AnimationCanvas extends Canvas{
    
     //FIELDS
    public int WIDTH  = 1024;
    public int HEIGHT = WIDTH / 16 * 9;
    
    //METHODS
    public void start(){
        Dimension size = new Dimension (WIDTH, HEIGHT);
        setPreferredSize(size);
    }

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.fillOval(100, 100, 30, 30);
    }
}