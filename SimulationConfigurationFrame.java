
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.GridLayout;

public class SimulationConfigurationFrame extends JFrame {

    public SimulationConfigurationFrame() {
        super.setTitle("Seleccionar veiculos");
        super.setSize(500, 500);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Layout();
    }

    private void Layout() {
        mainGridLayout.setHgap(50);
        mainGridLayout.setVgap(50);
        super.setLayout(contentGridLayout);

        buildContentSection();
        buildButtonsSection();
    }

    private void buildContentSection() {
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new JCheckBox(food[i]);
            super.add(boxes[i]);
        }

        boxes[0].setIcon(new ImageIcon("images/train.png"));
        boxes[0].setSelectedIcon(new ImageIcon("images/train_selected.png"));
    }

    private void buildButtonsSection() {
        buttonsPanel.setLayout(buttonsGridLayout);
        acceptButton.addActionListener((ActionEvent e) -> {
            System.out.println(getSelectedNames(boxes));
        });
        cancelButton.addActionListener((ActionEvent e) -> {
            super.dispose();
        });

        buttonsPanel.add(acceptButton);
        buttonsPanel.add(cancelButton);
        super.add(buttonsPanel);
    }

    public Object getSelectedNames(JCheckBox[] boxes) {
        ArrayList<String> selected_list = new ArrayList<String>();
        for (JCheckBox box : boxes)
            if (box.isSelected())
                selected_list.add(box.getText());

        return selected_list;
    }

    JPanel buttonsPanel = new JPanel();
    GridLayout contentGridLayout = new GridLayout(0, 1);
    GridLayout buttonsGridLayout = new GridLayout(0, 2);
    GridLayout mainGridLayout = new GridLayout(2, 1);

    JButton acceptButton = new JButton("Aceptar");
    JButton cancelButton = new JButton("Cancelar");

    String[] food = { "Tren", "Tren Ligero", "Trailer", "Automovil" };
    JCheckBox[] boxes = new JCheckBox[food.length];
}
