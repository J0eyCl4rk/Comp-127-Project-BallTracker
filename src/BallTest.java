import comp127graphics.CanvasWindow;
import comp127graphics.Line;

import java.awt.*;

public class BallTest {
    public static final double SPEED = 40;
    public static final int WINDOW_PADDING = 30;

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Cannon Angles", 1100, 600);

        for (int angle = 0; angle <= 90; angle += 5) {
            double angleInDegrees = angle;
            double ballInitialCenterX = 10;
            double ballInitialCenterY = 500;
            double maxXBound = canvas.getWidth();
            double maxYBound = canvas.getHeight() - WINDOW_PADDING;

            SideBall cannonBall = new SideBall(ballInitialCenterX, ballInitialCenterY, SPEED, angleInDegrees, maxXBound, maxYBound);

            canvas.add(cannonBall);
            boolean ballIsInMotion = true;
            while (ballIsInMotion) {
                double oldX = cannonBall.getX();
                double oldY = cannonBall.getY();
                ballIsInMotion = cannonBall.moveBall(0.1);
                Line tracer = new Line(oldX, oldY, cannonBall.getX(), cannonBall.getY());
                tracer.setStrokeColor(Color.LIGHT_GRAY);
                canvas.add(tracer);
                canvas.draw();
                canvas.pause(5);
            }
        }
    }
}
