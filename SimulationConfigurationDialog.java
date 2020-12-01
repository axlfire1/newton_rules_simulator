
/**
 * @author David Sarmiento
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.GridLayout;

public class SimulationConfigurationDialog {

    // COMPONENTS
    JFrame frame = new JFrame();
    JDialog dialog = new JDialog(frame, "Seleccionar vehiculos", true);
    ConfigurationFile configurationFile = new ConfigurationFile();
    JPanel buttonsPanel = new JPanel();
    GridLayout contentGridLayout = new GridLayout(0, 1);
    GridLayout buttonsGridLayout = new GridLayout(0, 2);
    GridLayout mainGridLayout = new GridLayout(2, 1);
    JButton acceptButton = new JButton("Aceptar");
    JButton cancelButton = new JButton("Cancelar");
    String[] food = { "Tren", "Tren Mexico Toluca", "Trailer (NOM 012)", "Automovil Familiar" };
    JCheckBox[] boxes = new JCheckBox[food.length];
    ArrayList<String> selectedList = new ArrayList<String>();
    String allowedVeicles = "";
    MainFrame previousFrame;

    // CONSTRUCTOR
    public SimulationConfigurationDialog(String allowedVeicles) {
        this.allowedVeicles = allowedVeicles;
        dialog.setLayout(new GridLayout());
        dialog.setSize(320, 430);
        dialog.setLocationRelativeTo(null);
        dialog.setBackground(java.awt.Color.WHITE);
        dialog.setResizable(false);
        orderLayout();
        addButtonActions();
        dialog.setVisible(true);

    }

    // BUILDING GUI
    private void orderLayout() {
        mainGridLayout.setHgap(50);
        mainGridLayout.setVgap(50);
        dialog.setLayout(contentGridLayout);

        buildContentSection();
        buildButtonsSection();
    }

    private void buildContentSection() {
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new JCheckBox(food[i]);
            dialog.add(boxes[i]);
        }

        boxes[0].setIcon(new ImageIcon("resources/images/train.png"));
        boxes[1].setIcon(new ImageIcon("resources/images/interurbano.png"));
        boxes[2].setIcon(new ImageIcon("resources/images/trailer.png"));
        boxes[3].setIcon(new ImageIcon("resources/images/auto.png"));
        boxes[0].setSelectedIcon(new ImageIcon("resources/images/train_selected.png"));
        boxes[1].setSelectedIcon(new ImageIcon("resources/images/interurbano_selected.png"));
        boxes[2].setSelectedIcon(new ImageIcon("resources/images/trailer_selected.png"));
        boxes[3].setSelectedIcon(new ImageIcon("resources/images/auto_selected.png"));

    }

    private void buildButtonsSection() {
        buttonsPanel.setLayout(buttonsGridLayout);
        buttonsPanel.add(acceptButton);
        buttonsPanel.add(cancelButton);
        dialog.add(buttonsPanel);
    }

    // LOGIC
    public void addButtonActions() {
        acceptButton.addActionListener((ActionEvent e) -> {
            evaluateSelection();
        });
        cancelButton.addActionListener((ActionEvent e) -> {
            selectedList.add("nothing");
            configurationFile.saveConfiguration(selectedList);
            dialog.dispose();
        });
    }

    private void evaluateSelection() {
        getSelectedNames(boxes);
        int veicles = Integer.valueOf(allowedVeicles);
        if (selectedList.size() < 2 || selectedList.size() > veicles) {
            JOptionPane.showMessageDialog(null,
                    "Elementos seleccionados " + selectedList.size()
                            + " ,solo es posible seleccionar como minimo 2 y como maximo " + veicles,
                    "Error", JOptionPane.ERROR_MESSAGE);
            selectedList.clear();
            return;
        }
        configurationFile.saveConfiguration(selectedList);
        dialog.dispose();
    }

    public void getSelectedNames(JCheckBox[] boxes) {
        for (JCheckBox box : boxes)
            if (box.isSelected())
                selectedList.add(box.getText());
    }
}
