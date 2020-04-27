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
    private TopBall ball;

    public PitchView(CanvasWindow canvas) {
        this.canvas = canvas;

    }

    public void makeStrikeZone(){
        for(int i=0;i<4;i++) {
            Line strikeLine = new Line(xPos1, yPos1, xPos2, yPos1);
            strikeLine.setStrokeWidth(8);
            canvas.add(strikeLine);
            yPos1 += 167;
        }
        for(int i=0;i<4;i++){
            yPos1=200;
            Line strikeLineHorizontal= new Line(xPos1,yPos1,xPos1,yPos2);
            strikeLineHorizontal.setStrokeWidth(8);
            canvas.add(strikeLineHorizontal);
            xPos1+=134;
        }

    }

    public void addBall(BallPathTracker game, TopBall ball){
        this.ball=ball;
        Random rand= new Random();
        double ballYPos=rand.nextInt(700);
        if(ballYPos<200)
            ballYPos=180;
        if(game.pitchLocation.equals("inside")){
            ball.setCenter(266.5,ballYPos);
            canvas.add(ball);
        }
        else if(game.pitchLocation.equals("outside")){
            ball.setCenter(533,ballYPos);
            canvas.add(ball);
        }
        else if(game.pitchLocation.equals("middle")){
            ball.setCenter(400,ballYPos);
            canvas.add(ball);
        }

    }
}
