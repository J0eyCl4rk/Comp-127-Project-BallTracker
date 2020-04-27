
import comp127graphics.CanvasWindow;
import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;


public class BallPathTracker {

    private CanvasWindow canvas;
    private FieldTopView fieldTop;
    private FieldSideView fieldSide;
    private SideBall ball;
    public String pitchLocation;
    private PitchView pitchView;
    private Random random= new Random();

    public BallPathTracker(){
        canvas= new CanvasWindow("Ball Path Tracker",800,800);

        fieldTop= new FieldTopView(canvas);
        fieldSide= new FieldSideView(canvas);


        //makeFieldTop();

        canvas.draw();

        Scanner scan= new Scanner(System.in);
        System.out.println("Enter a pitch location: inside, outside, middle.");
        pitchLocation= scan.next();


        ball= new SideBall(396.25,710, 10 , 40,canvas);
        ball.setFillColor(Color.white);
        makeBall();
        canvas.pause(300);

        canvas.animate(this::moveBall);

        //addPitchView();
   }


    public static void main(String[] args){
        new BallPathTracker();
    }


    public void makeFieldTop(){
        fieldTop.makeOutField();
        fieldTop.makeInfield();
        fieldTop.bleachers();
    }




    public void makeBall(){
        canvas.add(ball);
    }


    public void moveBall(){
        ball.updatePosition(-.25);
    }

//    public void addPitchView(){
//        pitchView=new PitchView(canvas);
//        pitchView.makeStrikeZone();
//        pitchView.addBall(this,ball);
}

