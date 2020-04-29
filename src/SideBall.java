import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;

public class SideBall extends Baseball{

    public SideBall(double xPos, double yPos, double vel, double initialAngle, double maxX, double maxY){
        super(xPos,yPos,RADIUS,RADIUS);

        this.xPos = xPos;
        this.yPos = yPos;
        this.maxX = maxX;
        this.maxY = maxY;

        double initialAngleRadians = Math.toRadians(initialAngle);
        this.xVel = vel * Math.cos(initialAngleRadians);
        this.yVel = vel * -Math.sin(initialAngleRadians);
    }

    public boolean moveBall(double dt) {
        double newX = xVel * dt + xPos;
        double newY = yVel * dt + yPos;
        if (xPos > 0 && xPos < maxX && yPos > 0 && yPos < maxY) {
            xPos += (xVel * dt);
            yPos += (yVel * dt);
            this.setPosition(newX, newY);
            yVel = yVel - GRAV * dt;
            return true;
        }
        else
            return false;
    }
}