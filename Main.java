
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
import java.util.Arrays;

public class Main extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    // UI COMPONENTS
    JMenuBar menubar = new JMenuBar();
    JMenu menu = new JMenu("Aplicación");
    JMenu creditsMenu = new JMenu("Acerca");
    JMenuItem creditsMenuItem = new JMenuItem("Creditos");
    JMenuItem configureSimulationMenuItem = new JMenuItem("Configurar simulación");
    JMenuItem exitMenuItem = new JMenuItem("Salir de la aplicación");
    JPanel panelCanvas = new JPanel();
    JPanel panelControls = new JPanel();
    JButton buttonStartRace = new JButton("Inciar simulación");
    // CUSTOM CLASES
    AnimationCanvas animationCanvas = new AnimationCanvas();

    // CONSTRUCTOR

    public Main() {
        setLayout(null);
        setTitle("2ª Ley de Newton Aplicado a un Sistema Ferroviario");
        setDefaultLookAndFeelDecorated(true);
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        add(menubar);
        setJMenuBar(menubar);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main window = new Main();
                window.buildMenus();
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

    public void buildMenus() {
        menubar.add(menu);
        menubar.add(creditsMenu);
        creditsMenu.add(creditsMenuItem);
        menu.add(configureSimulationMenuItem);
        menu.add(exitMenuItem);
    }

    public void buildPanelControlsContent() {
        ImageIcon startButtonImage = new ImageIcon("resources/images/unpressed_start_icon2.png");
        buttonStartRace.setIcon(startButtonImage);
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
            String veiclesNumber = JOptionPane.showInputDialog(null,
                    "Ingresa cuantos vehiculos vas a simular? \n (permitidos de 2 a 4)", "vehiculos a simular",
                    JOptionPane.QUESTION_MESSAGE);
            if (veiclesNumber != null) {
                lunchConfiguration(veiclesNumber);
            }
        });
        exitMenuItem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    public void controlActions() {
        buttonStartRace.setEnabled(false);
        buttonStartRace.addActionListener((ActionEvent e) -> {
            animationCanvas.startAnimation();
            buttonStartRace.setEnabled(false);
        });
    }

    public void lunchConfiguration(String veiclesNumber) {
        if (veiclesNumber.equals("2") || veiclesNumber.equals("3") || veiclesNumber.equals("4")) {
            new SimulationConfigurationDialog(veiclesNumber);
            String[] configuration = readConfiguration();
            if (!Arrays.toString(configuration).equals("[nothing]")) {
                buttonStartRace.setEnabled(true);
                animationCanvas.initialValues(configuration);
            }
        } else {
            JOptionPane.showMessageDialog(null, veiclesNumber + " no es valido", "Error", JOptionPane.ERROR_MESSAGE);
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
