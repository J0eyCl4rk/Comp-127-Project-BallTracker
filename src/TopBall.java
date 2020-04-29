public class TopBall extends Baseball{

    public TopBall(double xPos, double yPos, double xVel, double yVel){
        super(xPos,yPos,RADIUS,RADIUS);
        this.xPos= xPos;
        this.yPos= yPos;
        this.xVel= xVel;
        this.yVel= yVel;
    }

    public void moveBall(double dt, double xMax, double yMax, double xMin, double yMin, BallPathTracker game) {
        String pitchLocation = game.getPitchLocation();
        if((xPos > xMin + RADIUS/2 && xPos < xMax - RADIUS/2) && (yPos > yMin + RADIUS/2 && yPos < yMax - RADIUS/2)){
            if(pitchLocation.equals("inside")) {
                xPos += (xVel * dt);
                yPos += (yVel * dt);
                this.setCenter(xPos, yPos);
            }
            else if(pitchLocation.equals("outside")){
                xPos += (xVel * dt * GRAV);
                yPos += (yVel * dt);
                this.setCenter(xPos, yPos);
            }
            else if(pitchLocation.equals("middle")){
                xPos += 0;
                yPos += yVel*dt;
                this.setCenter(xPos, yPos);
            }
        }
    }
}

