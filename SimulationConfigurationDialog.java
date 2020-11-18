
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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.GridLayout;

public class SimulationConfigurationDialog {

    // CONSTRUCTOR
    public SimulationConfigurationDialog(String allowedVeicles) {
        this.allowedVeicles = allowedVeicles;
        dialog = new JDialog(frame, "Seleccionar veiculos", true);
        dialog.setLayout(new GridLayout());
        dialog.setSize(500, 500);
        dialog.setLocationRelativeTo(null);
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

        boxes[0].setIcon(new ImageIcon("images/train.png"));
        boxes[0].setSelectedIcon(new ImageIcon("images/train_selected.png"));
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
            dialog.dispose();
        });
    }

    private void evaluateSelection() {
        getSelectedNames(boxes);
        int veicles = Integer.valueOf(allowedVeicles);
        if (selected_list.size() < 1 || selected_list.size() > veicles) {
            JOptionPane.showMessageDialog(null,
                    "Elementos seleccionados " + selected_list.size()
                            + " ,solo es posible seleccionar como minimo 2 y como maximo " + veicles,
                    "Error", JOptionPane.ERROR_MESSAGE);
            selected_list.clear();
            return;
        }
        saveConfiguration();
        dialog.dispose();
    }

    public void getSelectedNames(JCheckBox[] boxes) {
        for (JCheckBox box : boxes)
            if (box.isSelected())
                selected_list.add(box.getText());
    }

    public void saveConfiguration() {
        try {
            FileWriter fstream = new FileWriter("config.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(selected_list.toString());
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // COMPONENTS

    private static JDialog dialog;
    JFrame frame = new JFrame();
    JPanel buttonsPanel = new JPanel();
    GridLayout contentGridLayout = new GridLayout(0, 1);
    GridLayout buttonsGridLayout = new GridLayout(0, 2);
    GridLayout mainGridLayout = new GridLayout(2, 1);
    JButton acceptButton = new JButton("Aceptar");
    JButton cancelButton = new JButton("Cancelar");
    String[] food = { "Tren", "Tren Ligero", "Trailer", "Automovil" };
    JCheckBox[] boxes = new JCheckBox[food.length];
    ArrayList<String> selected_list = new ArrayList<String>();
    String allowedVeicles = "";
    MainFrame previousFrame;
}
