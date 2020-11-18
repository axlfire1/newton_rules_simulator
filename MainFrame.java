
/**
 * @author David Sarmiento
 */

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

public class MainFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    // CONSTRUCTOR

    public MainFrame() {
        prepareMainWindow();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() { // important
            @Override
            public void run() {
                MainFrame window = new MainFrame();
                window.build_menus();
                window.buildLayouts();
                window.menuActions();
                window.buildPanelControlsContent();
                window.setVisible(true);
            }
        });
    }

    // BUILDING GUI

    public void prepareMainWindow() {
        setTitle("Newton Physics Simulator");
        setDefaultLookAndFeelDecorated(true);
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(menubar);
        setJMenuBar(menubar);
    }

    public void buildLayouts() {
        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Border eBorder = BorderFactory.createEtchedBorder();

        panelCanvas.setBorder(BorderFactory.createTitledBorder(eBorder, "Simulacion"));
        panelControls.setBorder(BorderFactory.createTitledBorder(eBorder, "Controles"));

        add(panelCanvas, gbc);
        add(panelControls, gbc);
    }

    public void build_menus() {
        menubar.add(menu);
        menubar.add(credits_menu);
        credits_menu.add(credits_menu_item);
        menu.add(configure_simulation_menu_item);
        menu.add(exit_menu_item);
    }

    public void buildPanelControlsContent() {
        ImageIcon start_bitton_image = new ImageIcon("images/unpressed_start_icon.png");
        startRace.setIcon(start_bitton_image);
        panelControls.add(startRace);
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
            if (veicles_number != null) {
                lunchConfiguration(veicles_number);
            }
        });
        exit_menu_item.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    public void lunchConfiguration(String veicles_number) {
        switch (veicles_number) {
            case "2":
                simulation_configuration = new SimulationConfigurationDialog(veicles_number);
                break;
            case "3":
                simulation_configuration = new SimulationConfigurationDialog(veicles_number);
                break;
            case "4":
                simulation_configuration = new SimulationConfigurationDialog(veicles_number);
                break;
            default:
                JOptionPane.showMessageDialog(null, veicles_number + " no es valido", "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }

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
    JPanel panelCanvas = new JPanel();
    JPanel panelControls = new JPanel();
    JButton startRace = new JButton();
    // CUSTOM CLASES

    SimulationConfigurationDialog simulation_configuration;
}
