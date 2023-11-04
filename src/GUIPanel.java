import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.ArrayList;

public class GUIPanel extends JPanel {
    // Instance of AnimationLine

    private AnimationLine animationLine;
    private JPanel buttonPanel;
    private JPanel cpuPanel;
    ARMComponents cpu = new ARMComponents();

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double baseWidth = screenSize.getWidth();
    private double baseHeight = screenSize.getHeight();


    
    public GUIPanel() {
        // Initialize AnimationLine
        this.setLayout(new BorderLayout());

        // Initialize button panel for all buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.GRAY);

        // Add text to buttons
        JButton ADDButton = new JButton("ADD, R0, R1, #2");
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point2D.Float startPoint = new Point2D.Float(cpu.Rec1('w') + cpu.Rec1('x'), cpu.Rec1('h')/2);
                Point2D.Float midPoint = new Point2D.Float(1080, cpu.Rec1('h')/2); 
                Point2D.Float midPoint2 = new Point2D.Float(1080, 1020); 
                Point2D.Float endPoint = new Point2D.Float(1180, 1020);

                List<Point2D.Float> firstLine = new ArrayList<Point2D.Float>();
                firstLine.add(startPoint); firstLine.add(midPoint); firstLine.add(midPoint2);firstLine.add(endPoint);
                
                animationLine = new AnimationLine(firstLine, 6000 ,  GUIPanel.this);
                animationLine.startAnimation();
            }
        });

        JButton LDRButton = new JButton("LDR R0, =arr");
        JButton UDIVButton = new JButton("UDIV R2, R1, #0");

        // Add buttons to button panel, create space in between buttons, plan to make buttons a uniform size
        buttonPanel.add(ADDButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(LDRButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(UDIVButton);

        // Initialize panel for CPU components to be drawn and draw CPU components
        cpuPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                cpuPanel.setLayout(new BorderLayout());
                cpuPanel.setBackground(Color.decode("#2F2F2F"));

                
                // Stroke details for CPU shapes
                g2d.setStroke(new BasicStroke(6));
                // Example shape
                // g2d.drawRoundRect(50, 50, cpu.Rec1('w'), cpu.Rec1('h'), 50, 50);
                
                // Draw all CYAN components first
                g2d.setColor(Color.CYAN);
                // Draw Control Unit
                g2d.drawRoundRect(cpu.controlUnit('x'), cpu.controlUnit('y'), cpu.controlUnit('w'), cpu.controlUnit('h'), 1000, 1000);
                // Draw ALU Control
                g2d.drawRoundRect(cpu.ALUControl('x'), cpu.ALUControl('y'), cpu.ALUControl('w'), cpu.ALUControl('h'),1000, 1000);

                // Draw all WHITE components (Ordered as 1. Rectangles, 2. Rounded Rectangles, 3. Misc Shapes)
                g2d.setColor(Color.decode("#BFAFBF"));
                // Draw PC
                g2d.drawRect(cpu.PC('x'), cpu.PC('y'), cpu.PC('w'), cpu.PC('h'));
                // Draw Instruction Memory
                g2d.drawRect(cpu.instructionMem('x'), cpu.instructionMem('y'), cpu.instructionMem('w'), cpu.instructionMem('h'));
                // Draw Registers
                g2d.drawRect(cpu.registers('x'), cpu.registers('y'), cpu.registers('w'), cpu.registers('h'));
                // Draw Data Memory
                g2d.drawRect(cpu.dataMemory('x'), cpu.dataMemory('y'), cpu.dataMemory('w'), cpu.dataMemory('h'));
                // Draw Multiplexor (Registers)
                g2d.drawRoundRect(cpu.muxRegisters('x'), cpu.muxRegisters('y'), cpu.muxRegisters('w'), cpu.muxRegisters('h'), cpu.getMuxRound(), cpu.getMuxRound());
                // Draw Multiplexor (ALU)
                g2d.drawRoundRect(cpu.muxALU('x'), cpu.muxALU('y'), cpu.muxALU('w'), cpu.muxALU('h'), cpu.getMuxRound(), cpu.getMuxRound());
                // Draw Multiplexor (Data Memory)
                g2d.drawRoundRect(cpu.muxDataMemory('x'), cpu.muxDataMemory('y'), cpu.muxDataMemory('w'), cpu.muxDataMemory('h'), cpu.getMuxRound(), cpu.getMuxRound());
                // Draw Multiplexor (ADD) TODO:
                g2d.drawRoundRect(cpu.muxAdd('x'), cpu.muxAdd('y'), cpu.muxAdd('w'), cpu.muxAdd('h'), cpu.getMuxRound(), cpu.getMuxRound());
                // Draw Sign Extend
                g2d.drawRoundRect(cpu.signExtend('x'), cpu.signExtend('y'), cpu.signExtend('w'), cpu.signExtend('h'), cpu.getCirclesRound(), cpu.getCirclesRound());
                // Draw Shift Left
                g2d.drawRoundRect(cpu.shiftLeft('x'), cpu.shiftLeft('y'), cpu.shiftLeft('w'), cpu.shiftLeft('h'), cpu.getCirclesRound(), cpu.getCirclesRound());
                // Draw ALU
                g2d.drawPolygon(cpu.ALU('x'), cpu.ALU('y'), 7);
                // Draw ALUResult
                g2d.drawPolygon(cpu.ALUResult('x'), cpu.ALUResult('y'), 7);
                // Draw addPC
                g2d.drawPolygon(cpu.addPC('x'), cpu.addPC('y'), 7);
                // Draw the lil AND thing
                g2d.drawArc(cpu.controlAND('x'), cpu.controlAND('y'), cpu.controlAND('w'), cpu.controlAND('h'), 90, -180);
                g2d.drawLine(cpu.controlAND('x') + (int)(baseWidth * 0.025), cpu.controlAND('y'), cpu.controlAND('x') + (int)(baseWidth * 0.025), cpu.controlAND('y') + (int)(baseHeight * 0.074));
                // Draw the pathing lines between the components, starting coordinates and ending coordinates based on the components' IO
                LinePath linepath = new LinePath();
                linepath.draw(g2d);

                if (animationLine != null) {
                    g2d.setStroke(new BasicStroke(4));
                    animationLine.draw(g);
                }
            }
        };

        // Add all panels to the GUIPanel
        this.add(buttonPanel, BorderLayout.EAST);
        this.add(cpuPanel, BorderLayout.CENTER);


    }


    

    // Other methods as necessary
}
