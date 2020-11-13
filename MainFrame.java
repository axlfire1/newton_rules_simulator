
/**
 *
 * @author David Sarmiento
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener {

    // constructor
    public MainFrame() {
        super.setTitle("Newton Physics Simulator");
        super.setSize(1280, 720);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.add(menubar);
        super.setJMenuBar(menubar);
        super.add(animation_canvas);
        animation_canvas.start();
    }

    public static void main(String[] args) {
        MainFrame window = new MainFrame();
        window.build_application();
    }

    public void build_application() {
        build_menus();
        setVisible(true);
    }

    public void build_menus() {
        menubar.add(menu);
        menubar.add(credits_menu);

        credits_menu.add(credits_menu_item);

        menu.add(configure_simulation_menu_item);
        menu.add(exit_menu_item);

        credits_menu_item.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Developer, David Sarmiento.");
        });
        configure_simulation_menu_item.addActionListener((ActionEvent e) -> {
            String veicles_number = JOptionPane.showInputDialog(null,
                    "Ingresa cuantos veiculos vas a simular? \n (permitidos 2 y 3)", "veiculos a simular",
                    JOptionPane.QUESTION_MESSAGE);
            lunch_configuration(veicles_number);
        });
        exit_menu_item.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void lunch_configuration(String veicles_number) {

        switch (veicles_number) {
            // case statements
            // values must be of same type of expression
            case "2":
                simulation_configuration_frame.setVisible(true);
                break;
            case "3":
                simulation_configuration_frame.setVisible(true);
                break;
            default:
                System.out.println(veicles_number.length());
                JOptionPane.showMessageDialog(null, veicles_number + " no es valido", "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }

    // components
    JButton button = new JButton("Press");
    JMenuBar menubar = new JMenuBar();
    JMenu menu = new JMenu("Aplicación");
    JMenu credits_menu = new JMenu("Acerca");
    JMenuItem credits_menu_item = new JMenuItem("Creditos");
    JMenuItem configure_simulation_menu_item = new JMenuItem("Configurar simulación");
    JMenuItem exit_menu_item = new JMenuItem("Salir de la aplicación");
    // custom clases
    AnimationCanvas animation_canvas = new AnimationCanvas();
    SimulationConfigurationFrame simulation_configuration_frame = new SimulationConfigurationFrame();
}
