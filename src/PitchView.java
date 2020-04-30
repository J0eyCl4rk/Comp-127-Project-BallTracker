import comp127graphics.CanvasWindow;
import comp127graphics.Line;

import java.awt.*;
import java.util.Random;

public class PitchView{
    private CanvasWindow canvas;
    private static final Color infColor = new Color(158,100,55);
    private static final Color outColor = new Color(11,158,1);
    private double xPos1= 200;
    private double xPos2= 600;
    private double yPos1=200;
    private double yPos2= 700;
    private double height;
    private double width;
    private TopBall ball;

    public PitchView(double initialX, double initialY, double width, double height, CanvasWindow canvas) {
        this.canvas = canvas;
        xPos1 = .25 * width + initialX;
        xPos2 = .75 * width + initialX;
        yPos1 = .20 * height + initialY;
        yPos2 = 7 / 8.0 * height + initialY;

        this.width = width;
        this.height = height;
    }

    public void makeStrikeZone(){
        double y = yPos1;
        for(int i=0;i<4;i++) {
            Line strikeLine = new Line(xPos1, y, xPos2-80, y);
            strikeLine.setStrokeWidth(5);
            canvas.add(strikeLine);
            y += 180 / 800.0 * height;
        }
        double x = xPos1;
        for(int i=0;i<4;i++){
            Line strikeLineHorizontal= new Line(x,yPos1,x,yPos2);
            strikeLineHorizontal.setStrokeWidth(5);
            canvas.add(strikeLineHorizontal);
            x +=100 / 800.0 * width;
        }

    }

    public void addBall(BallPathTracker game, TopBall ball){
        String pitchLocation = game.getPitchLocation();
        this.ball=ball;
        Random rand= new Random();
        double ballYPos=rand.nextInt(700);
        if(ballYPos<200)
            ballYPos=180;
        if(pitchLocation.equals("inside")){
            ball.setCenter(266.5,ballYPos);
            canvas.add(ball);
        }
        else if(pitchLocation.equals("outside")){
            ball.setCenter(533,ballYPos);
            canvas.add(ball);
        }
        else if(pitchLocation.equals("middle")){
            ball.setCenter(400,ballYPos);
            canvas.add(ball);
        }

    }
}
