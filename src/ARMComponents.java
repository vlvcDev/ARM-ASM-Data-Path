// Use Fontmetrics to draw scaleable text

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Arc2D;

public class ARMComponents {
    // Properties representing different ARM CPU components

    // Get Screen w*h to determine how to scale shapes
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double baseWidth = screenSize.getWidth();
    private double baseHeight = screenSize.getHeight();
    // Testable screen size values
    // private double baseWidth = 1920;
    // private double baseHeight = 1080;


    // test rectangle implementation

    private int rectangle1w = 200;
    private int rectangle1h = 300;

    private final int muxRound = (int)(baseHeight * 0.04);
    private final int circlesRound = (int)(baseHeight);


    public ARMComponents() {
        // Initialize components
        this.rectangle1w = 200;
        this.rectangle1h = 300;

    }

    public int Rec1(char parameter) {
        switch (parameter){
            case 'x':
                return 0;
            case 'y': 
                return 0;
            case 'w':
                return (int)this.rectangle1w;
            case 'h':
                return (int)this.rectangle1h;
            default:
                return 0;
        }
    }
    // Colored components
    public int controlUnit(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.24);
            case 'y':
                return (int)(baseHeight * 0.22);
            case 'w':
                return (int)(baseWidth * 0.06);
            case 'h':
                return (int)(baseHeight * 0.2);
            default:
                return 0;

        }
    }

    public int ALUControl(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.44);
            case 'y':
                return (int)(baseHeight * 0.76);
            case 'w':
                return (int)(baseWidth * 0.04);
            case 'h':
                return (int)(baseHeight * 0.09);
            default:
                return 0;

        }
    }
    // White Rectangles
    public int PC(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.06);
            case 'y':
                return (int)(baseHeight * 0.42);
            case 'w':
                return (int)(baseWidth * 0.02);
            case 'h':
                return (int)(baseHeight * 0.11);
            default:
                return 0;
        }
    }

    public int instructionMem(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.1);
            case 'y':
                return (int)(baseHeight * 0.48);
            case 'w':
                return (int)(baseWidth * 0.05);
            case 'h':
                return (int)(baseHeight * 0.14);
            default:
                return 0;
        }
    }
    
    public int registers(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.28);
            case 'y':
                return (int)(baseHeight * 0.44);
            case 'w':
                return (int)(baseWidth * 0.09);
            case 'h':
                return (int)(baseHeight * 0.22);
            default:
                return 0;
        }
    }

    public int dataMemory(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.66);
            case 'y':
                return (int)(baseHeight * 0.56);
            case 'w':
                return (int)(baseWidth * 0.08);
            case 'h':
                return (int)(baseHeight * 0.18);
            default:
                return 0;
        }
    }

    // Multiplexors
    public int getMuxRound() {
        return muxRound;
    }
    public int muxRegisters(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.25);
            case 'y':
                return (int)(baseHeight * 0.48);
            case 'w':
                return (int)(baseWidth * 0.018);
            case 'h':
                return (int)(baseHeight * 0.08);
            default:
                return 0;
        }
    }

    public int muxALU(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.42);
            case 'y':
                return (int)(baseHeight * 0.54);
            case 'w':
                return (int)(baseWidth * 0.018);
            case 'h':
                return (int)(baseHeight * 0.08);
            default:
                return 0;
        }
    }

    public int muxDataMemory(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.77);
            case 'y':
                return (int)(baseHeight * 0.6);
            case 'w':
                return (int)(baseWidth * 0.018);
            case 'h':
                return (int)(baseHeight * 0.08);
            default:
                return 0;
        }
    }

    public int muxAdd(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.69);
            case 'y':
                return (int)(baseHeight * 0.1);
            case 'w':
                return (int)(baseWidth * 0.018);
            case 'h':
                return (int)(baseHeight * 0.14);
            default:
                return 0;
        }
    }

    // White circles (I'm going manic)
    public int getCirclesRound() {
        return circlesRound;
    }
    public int signExtend(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.31);
            case 'y':
                return (int)(baseHeight * 0.68);
            case 'w':
                return (int)(baseWidth * 0.032);
            case 'h':
                return (int)(baseHeight * 0.09);
            default:
                return 0;
        }
    }

    public int shiftLeft(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.46);
            case 'y':
                return (int)(baseHeight * 0.24);
            case 'w':
                return (int)(baseWidth * 0.03);
            case 'h':
                return (int)(baseHeight * 0.07);
            default:
                return 0;
        }
    }

    // Ugly shapes

    // Maybe make the FIRST point an anchor point for the rest of the shape, so changing the anchor value it moves the whole shape


    // Starting at the top left point and moving clockwise
    private int[] aluPointsX = {(int)(baseWidth * 0.50), (int)(baseWidth * 0.58), (int)(baseWidth * 0.58), (int)(baseWidth * 0.5), (int)(baseWidth * 0.5), (int)(baseWidth * 0.515), (int)(baseWidth * 0.5)};
    private int[] aluPointsY = {(int)(baseHeight * 0.46), (int)(baseHeight * 0.52), (int)(baseHeight * 0.6), (int)(baseHeight * 0.66), (int)(baseHeight * 0.58), (int)(baseHeight * 0.56), (int)(baseHeight * 0.54)};
    public int[] ALU(char parameter){
        switch(parameter) {
            case 'x':
                return aluPointsX;
            case 'y':
                return aluPointsY;
            default:
                return null;
        }
    }

    private int[] aluResultPointsX = {(int)(baseWidth * 0.56), (int)(baseWidth * 0.64), (int)(baseWidth * 0.64), (int)(baseWidth * 0.56), (int)(baseWidth * 0.56), (int)(baseWidth * 0.575), (int)(baseWidth * 0.56)};
    private int[] aluResultPointsY = {(int)(baseHeight * 0.13), (int)(baseHeight * 0.19), (int)(baseHeight * 0.27), (int)(baseHeight * 0.33), (int)(baseHeight * 0.25), (int)(baseHeight * 0.23), (int)(baseHeight * 0.21)};
    public int[] ALUResult(char parameter) {
        switch(parameter) {
            case 'x':
                return aluResultPointsX;
            case 'y':
                return aluResultPointsY;
            default:
                return null;
        }
    }
    
    private int[] addPCPointsX = {(int)(baseWidth * 0.11), (int)(baseWidth * 0.16), (int)(baseWidth * 0.16), (int)(baseWidth * 0.11), (int)(baseWidth * 0.11), (int)(baseWidth * 0.125), (int)(baseWidth * 0.11)};
    private int[] addPCPointsY = {(int)(baseHeight * 0.07), (int)(baseHeight * 0.13), (int)(baseHeight * 0.21), (int)(baseHeight * 0.27), (int)(baseHeight * 0.19), (int)(baseHeight * 0.17), (int)(baseHeight * 0.15)};
    public int[] addPC(char parameter) {
        switch(parameter) {
            case 'x':
                return addPCPointsX;
            case 'y':
                return addPCPointsY;
            default:
                return null;
        }
    } //hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh

    public int controlAND(char parameter) {
        switch(parameter) {
            case 'x':
                return (int)(baseWidth * 0.62);
            case 'y':
                return (int)(baseHeight * 0.36);
            case 'w':
                return (int)(baseWidth * 0.055);
            case 'h':
                return (int)(baseHeight * 0.075);
            default:
                return 0;
        }
    }   


    // Other methods as necessary
}
