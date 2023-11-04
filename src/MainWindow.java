import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    // Instance of GUIPanel
    private GUIPanel guiPanel;
    // Instance of CodeDriver
    private CodeDriver codeDriver;

    public MainWindow() {
        // Initialize GUIPanel and CodeDriver
        this.guiPanel = new GUIPanel();
        this.codeDriver = new CodeDriver();
    
        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
        // Set up JFrame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("DATAPATH VISUALIZER");
        this.setSize(screenSize);
        // this.setSize(1920, 1080);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    
        this.add(guiPanel, BorderLayout.CENTER);
    
        this.setVisible(true);
    }
    

    public static void main(String[] args) {
        // Run the JFrame on the Event Dispatching thread
        SwingUtilities.invokeLater(() -> {
            new MainWindow();
        });
    }

    // Other methods as necessary
}
