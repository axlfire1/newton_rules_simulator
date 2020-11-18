
/**
 * @author David Sarmiento
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener {

    // CONSTRUCTOR

    public MainFrame() {
        prepareMainWindow();
        animation_canvas.start();
    }

    public static void main(String[] args) {
        MainFrame window = new MainFrame();
        window.build_menus();
        window.menuActions();
        window.setVisible(true);
    }

    // BUILDING GUI

    private void prepareMainWindow() {
        setTitle("Newton Physics Simulator");
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(menubar);
        setJMenuBar(menubar);
        add(animation_canvas);
    }

    public void build_menus() {
        menubar.add(menu);
        menubar.add(credits_menu);
        credits_menu.add(credits_menu_item);
        menu.add(configure_simulation_menu_item);
        menu.add(exit_menu_item);
    }

    // LOGIC

    public void menuActions() {
        credits_menu_item.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Developer, David Sarmiento.");
        });
        configure_simulation_menu_item.addActionListener((ActionEvent e) -> {
            String veicles_number = JOptionPane.showInputDialog(null,
                    "Ingresa cuantos veiculos vas a simular? \n (permitidos de 2 a 4)", "veiculos a simular",
                    JOptionPane.QUESTION_MESSAGE);
            lunchConfiguration(veicles_number);
        });
        exit_menu_item.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    public void lunchConfiguration(String veicles_number) {
        switch (veicles_number) {
            case "2":
                simulation_configuration = new SimulationConfigurationDialog(veicles_number);
                readConfigurationFromFile();
                break;
            case "3":
                simulation_configuration = new SimulationConfigurationDialog(veicles_number);
                readConfigurationFromFile();
                break;
            case "4":
                simulation_configuration = new SimulationConfigurationDialog(veicles_number);
                readConfigurationFromFile();
                break;
            default:
                JOptionPane.showMessageDialog(null, veicles_number + " no es valido", "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readConfigurationFromFile() {
        System.out.println("checking configurartion file");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // COMPONENTS

    JMenuBar menubar = new JMenuBar();
    JMenu menu = new JMenu("Aplicación");
    JMenu credits_menu = new JMenu("Acerca");
    JMenuItem credits_menu_item = new JMenuItem("Creditos");
    JMenuItem configure_simulation_menu_item = new JMenuItem("Configurar simulación");
    JMenuItem exit_menu_item = new JMenuItem("Salir de la aplicación");

    // CUSTOM CLASES

    AnimationCanvas animation_canvas = new AnimationCanvas();
    SimulationConfigurationDialog simulation_configuration;
}
