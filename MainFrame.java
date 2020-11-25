
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    // UI COMPONENTS
    JMenuBar menubar = new JMenuBar();
    JMenu menu = new JMenu("Aplicación");
    JMenu credits_menu = new JMenu("Acerca");
    JMenuItem creditsMenuItem = new JMenuItem("Creditos");
    JMenuItem configureSimulationMenuItem = new JMenuItem("Configurar simulación");
    JMenuItem exitMenuItem = new JMenuItem("Salir de la aplicación");
    JPanel panelCanvas = new JPanel();
    JPanel panelControls = new JPanel();
    JButton buttonStartRace = new JButton("Inciar simulación");
    // CUSTOM CLASES
    AnimationCanvas animationCanvas = new AnimationCanvas();

    // CONSTRUCTOR

    public MainFrame() {
        setLayout(null);
        setTitle("Newton Physics Simulator");
        setDefaultLookAndFeelDecorated(true);
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(menubar);
        setJMenuBar(menubar);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame window = new MainFrame();
                window.build_menus();
                window.buildLayouts();
                window.menuActions();
                window.controlActions();
                window.buildPanelControlsContent();
                window.setVisible(true);
            }
        });
    }

    // BUILDING GUI

    public void buildLayouts() {
        Border eBorder = BorderFactory.createEtchedBorder();
        panelControls.setBounds(10, 10, 1245, 70);
        panelCanvas.setBounds(10, 80, 1245, 570);
        panelCanvas.setBorder(BorderFactory.createTitledBorder(eBorder, "Pantalla de simulacion"));
        panelControls.setBorder(BorderFactory.createTitledBorder(eBorder, "Controles"));
        add(panelControls);
        add(panelCanvas);
    }

    public void build_menus() {
        menubar.add(menu);
        menubar.add(credits_menu);
        credits_menu.add(creditsMenuItem);
        menu.add(configureSimulationMenuItem);
        menu.add(exitMenuItem);
    }

    public void buildPanelControlsContent() {
        ImageIcon start_bitton_image = new ImageIcon("resources/images/unpressed_start_icon2.png");
        buttonStartRace.setIcon(start_bitton_image);
        panelCanvas.add(animationCanvas);
        panelControls.add(buttonStartRace);
    }

    // LOGIC

    public void menuActions() {
        creditsMenuItem.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null,
                    "Clustec de Investigacion Ferroviaria: \n Dr. Ismael Cortez. \n MC. David Sarmiento. \n Lic. Luis Miguel Carbajal.");
        });
        configureSimulationMenuItem.addActionListener((ActionEvent e) -> {
            String veicles_number = JOptionPane.showInputDialog(null,
                    "Ingresa cuantos vehiculos vas a simular? \n (permitidos de 2 a 4)", "vehiculos a simular",
                    JOptionPane.QUESTION_MESSAGE);
            if (veicles_number != null) {
                lunchConfiguration(veicles_number);
            }
        });
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    public void controlActions() {
        buttonStartRace.setEnabled(false);
        buttonStartRace.addActionListener((ActionEvent e) -> {
            animationCanvas.updateGraphics();
        });
    }

    public void lunchConfiguration(String veicles_number) {
        if (veicles_number.equals("2") || veicles_number.equals("3") || veicles_number.equals("4")) {
            SimulationConfigurationDialog returnValue = new SimulationConfigurationDialog(veicles_number);
            buttonStartRace.setEnabled(true);
            animationCanvas.initialValues(readConfiguration());
        } else {
            JOptionPane.showMessageDialog(null, veicles_number + " no es valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String[] readConfiguration() {
        String[] configurationElements;
        configurationElements = new ConfigurationFile().readElements();
        return configurationElements;
    }
}
