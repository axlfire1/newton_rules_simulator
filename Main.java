/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newton_rules_simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author David Sarmiento
 */
public class Main extends JFrame implements ActionListener {

    // constructor
    public Main() {
        super.setTitle("Newton Physics Simulator");
        super.setSize(1024, 640);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.add(menubar);
        super.setJMenuBar(menubar);
        super.add(animation_canvas);
        animation_canvas.start();
    }

    public static void main(String[] args) {
        Main window = new Main();
        window.build_application();
    }

    public void build_application() {
        build_menus();
        setVisible(true);
    }

    public void build_menus() {
        menubar.add(credits_menu);
        credits_menu.add(credits_menu_item);
        credits_menu_item.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Developer, David Sarmiento.");
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // components
    JButton button = new JButton("Press");
    JMenuBar menubar = new JMenuBar();
    JMenu credits_menu = new JMenu("Acerca");
    JMenuItem credits_menu_item = new JMenuItem("Creditos");
    JOptionPane credits_advice = new JOptionPane();

    // other clases
    AnimationCanvas animation_canvas = new AnimationCanvas();
}
