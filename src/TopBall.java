import comp127graphics.Ellipse;

import java.awt.*;

public class TopBall extends Baseball{

    protected Ellipse baseball;

    public TopBall(double xPos, double yPos, double xVel, double yVel){
        super(xPos,yPos,RADIUS,RADIUS);
        this.xPos= xPos;
        this.yPos= yPos;
        this.xVel= xVel;
        this.yVel= yVel;
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
            else if(game.pitchLocation.equals("middle")){
                xPos += 0;
                yPos += yVel*dt;
                this.setCenter(xPos, yPos);
                return true;
            }
        }
        return false;
    }
}

