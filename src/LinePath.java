import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;

public class LinePath {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double baseWidth = screenSize.getWidth();
    private double baseHeight = screenSize.getHeight();

    // All coordinates of IO ports of CPU components listed as Input>Output and Top>Bottom
    // EX:       -------
    //          |       |
    //          0       |
    //          |       2       [0, 1, 2]
    //          1       |
    //          |       |
    //           -------


    private int[] PCports = {};

    public LinePath() {
        List<Point2D.Float> PCIO = new ArrayList<Point2D.Float>();
        PCIO.add(new Point2D.Float(1, 0));
    }

    // perhaps create method to automatically position a line if it's not in bounds of components

 //   public int PCtoIM(int )

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.gray);
        //g2d.drawLine(0, 0, 1000, 1000);
    }
}