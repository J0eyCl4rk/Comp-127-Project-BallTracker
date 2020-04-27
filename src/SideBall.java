import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;

public class SideBall extends Baseball{

    double initialAngle;
    CanvasWindow canvas;

    public SideBall(double xPos, double yPos, double initialSpeed, double initialAngle, CanvasWindow canvas) {
        super(xPos, yPos, 0, 0);
        this.initialAngle = initialAngle;
        double initialAngleRadians = Math.toRadians(initialAngle);
        this.xVel = initialSpeed * Math.cos(initialAngleRadians);
        this.yVel = initialSpeed * -Math.sin(initialAngleRadians);
        this.canvas = canvas;
    }

    public boolean updatePosition(double dt) {
        if(xPos < canvas.getWidth() && yPos < canvas.getHeight()) {
            xPos += (xVel * dt);
            yPos += (yVel * dt);
            this.setCenter(xPos, yPos);
            yVel = yVel - GRAV * dt;
            return true;
        }
        return false;
    }
}