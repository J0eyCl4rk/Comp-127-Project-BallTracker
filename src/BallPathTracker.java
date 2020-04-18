
import comp127graphics.CanvasWindow;
import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;

import java.awt.*;
import java.util.Scanner;


public class BallPathTracker {

    private CanvasWindow canvas;
    private FieldTopView fieldTop;
    private Ball ball;
    public String pitchLocation;

    public BallPathTracker(){
        canvas= new CanvasWindow("Ball Path Tracker",800,800);

        fieldTop= new FieldTopView(canvas);

        makeFieldTop();

        canvas.draw();

        Scanner scan= new Scanner(System.in);
        System.out.println("Enter a pitch location: inside, outside, middle.");
        pitchLocation= scan.next();

        ball= new Ball(396.25,710, 5 , 40);
        ball.setFillColor(Color.white);
        makeBall();
        canvas.pause(300);

        canvas.animate(this::moveBall);
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
        ball.moveBall(-.25,800,725,0,150,this);
    }
}
