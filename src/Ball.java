import comp127graphics.Ellipse;

import java.awt.*;

public class Ball extends Ellipse{

    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;
    private Ellipse baseball;
    private static final Color baseballColor= Color.white;
    private static final Color seamColor= Color.red;
    private static final double RADIUS= 10;
    private static final double GRAV=-.98;

    public Ball(double xPos, double yPos, double xVel, double yVel){
        super(xPos,yPos,RADIUS,RADIUS);
        this.xPos= xPos;
        this.yPos= yPos;
        this.xVel= xVel;
        this.yVel= yVel;

        baseball= new Ellipse(xPos, yPos, RADIUS, RADIUS);
        baseball.setFillColor(baseballColor);
        baseball.setStrokeColor(seamColor);
    }

    public boolean moveBall(double dt, double xMax, double yMax, double xMin, double yMin, BallPathTracker game) {
        if((xPos > xMin + RADIUS/2 && xPos < xMax - RADIUS/2) && (yPos > yMin + RADIUS/2 && yPos < yMax - RADIUS/2)){
            if(game.pitchLocation.equals("inside")) {
                xPos += (xVel * dt);
                yPos += (yVel * dt);
                this.setCenter(xPos, yPos);
                return true;
            }
            else if(game.pitchLocation.equals("outside")){
                xPos += (xVel * dt * GRAV);
                yPos += (yVel * dt);
                this.setCenter(xPos, yPos);
                return true;
            }
        }
        return false;
    }
}
