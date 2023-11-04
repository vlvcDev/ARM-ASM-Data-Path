import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.List;
import java.awt.geom.Path2D;


// To use this class, create a list of points from starting point, to ending point, and any direction changes in between

public class AnimationLine {
    // Instance of Timer
    private List<Point2D.Float> points;
    private Path2D.Float path;
    private int current;

    private Timer timer;
    private int duration;
    private long startTime;

    public AnimationLine(List<Point2D.Float> points, int duration, Component component) {
        this.points = points;
        this.path = new Path2D.Float();
        this.path.moveTo(points.get(0).x, points.get(0).y);
        this.duration = duration;
        this.current = 0;
        
        int delay = 20;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                updateCurrentPoint();
                
                component.repaint();
            }
        };
        
        this.timer = new Timer(delay, taskPerformer);
        
    }

    // Method to start animation
    public void startAnimation() {
        // Implementation here, System time to keep in sync
        this.startTime = System.currentTimeMillis();
        this.timer.start();
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.GREEN);
        g2d.draw(this.path);
    }

    private void updateCurrentPoint() {
        // Calculate the total distance to move, make the animation smoother with fraction
        long currentTime = System.currentTimeMillis();
        float fraction = (currentTime - this.startTime) / (float) this.duration;
    
        // Calculate the next point along the line
        
        if (fraction > 1) {
            this.current++;
            this.startTime = System.currentTimeMillis();
            fraction = 0;

            if(this.current >= this.points.size() - 1) {
                this.timer.stop();
                return;
            }
            
        }

        Point2D.Float startPoint = this.points.get(this.current);
        Point2D.Float endPoint = this.points.get(this.current + 1);
        float x = startPoint.x + (endPoint.x - startPoint.x) * fraction;
        float y = startPoint.y + (endPoint.y - startPoint.y) * fraction;

        this.path.lineTo(x,y);
    }
    
}
