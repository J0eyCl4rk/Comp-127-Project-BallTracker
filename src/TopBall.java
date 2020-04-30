public class TopBall extends Baseball{

    public TopBall(double xPos, double yPos, double xVel, double yVel){
        super(xPos,yPos,RADIUS,RADIUS);
        this.xPos= xPos;
        this.yPos= yPos;
        this.xVel= xVel;
        this.yVel= yVel;
    }

    public void moveBall(double dt, double xMax, double yMax, double xMin, BallPathTracker game) {
        double yMin = 0;
        if(game.getAngle()>=0 && game.getAngle()<=20 && game.getExitVelocity()>=40 && game.getExitVelocity()<=60){
            yMin=450;
        }
        else if(game.getAngle()>=0 && game.getAngle()<=20 && game.getExitVelocity()>60 && game.getExitVelocity()<=80){
            yMin=350;
        }
        else if(game.getAngle()>=0 && game.getAngle()<=20 && game.getExitVelocity()>80 && game.getExitVelocity()<=90){
            yMin=250;
        }
        else if(game.getAngle()>=0 && game.getAngle()<=20 && game.getExitVelocity()>90 && game.getExitVelocity()<=120){
            yMin=150;
        }
        else if(game.getAngle()>20 && game.getAngle()<=30 && game.getExitVelocity()>=40 && game.getExitVelocity()<=60){
            yMin=400;
        }
        else if(game.getAngle()>20 && game.getAngle()<=30 && game.getExitVelocity()>60 && game.getExitVelocity()<=80){
            yMin=300;
        }
        else if(game.getAngle()>20 && game.getAngle()<=30 && game.getExitVelocity()>80 && game.getExitVelocity()<=100){
            yMin=150;
        }
        else if(game.getAngle()>20 && game.getAngle()<=30 && game.getExitVelocity()>100 && game.getExitVelocity()<=120){
            yMin=100;
        }
        else if(game.getAngle()>30 && game.getAngle()<=40 && game.getExitVelocity()>=40 && game.getExitVelocity()<=60){
            yMin=450;
        }
        else if(game.getAngle()>30 && game.getAngle()<=40 && game.getExitVelocity()>60 && game.getExitVelocity()<=80){
            yMin=350;
        }
        else if(game.getAngle()>30 && game.getAngle()<=40 && game.getExitVelocity()>80 && game.getExitVelocity()<=100){
            yMin=250;
        }
        else if(game.getAngle()>30 && game.getAngle()<=40 && game.getExitVelocity()>100 && game.getExitVelocity()<=120){
            yMin=150;
        }
        else if(game.getAngle()>40 && game.getAngle()<=60 && game.getExitVelocity()>=40 && game.getExitVelocity()<=60){
            yMin=500;
        }
        else if(game.getAngle()>40 && game.getAngle()<=60 && game.getExitVelocity()>60 && game.getExitVelocity()<=120){
            yMin=300;
        }

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

