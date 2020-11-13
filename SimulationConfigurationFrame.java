
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;

public class SimulationConfigurationFrame extends JFrame {

    public SimulationConfigurationFrame() {
        super.setTitle("Configurar veiculos");
        super.setSize(500, 500);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showGridLayoutDemo();
    }

    private void showGridLayoutDemo() {
        GridLayout layout = new GridLayout(0, 1);
        layout.setHgap(10);
        layout.setVgap(10);

        super.setLayout(layout);
        super.add(new JButton("Button 1"));
        super.add(new JButton("Button 2"));
        super.add(new JButton("Button 3"));
        super.add(new JButton("Button 4"));
        super.add(new JButton("Button 5"));
    }

}
