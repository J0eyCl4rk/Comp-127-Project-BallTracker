import comp127graphics.CanvasWindow;
import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;
import comp127graphics.Line;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;


public class BallPathTracker {

    private CanvasWindow canvas;
    private TopBall topBall;
    private SideBall sideBall;
    private StrikeZoneBall strikeZoneBall;
    private String pitchLocation;
    private double exitVelocity;
    private double angle;
    private Random random = new Random();
    private Scanner scan = new Scanner(System.in);;

    public BallPathTracker() {

        getInput();

        canvas = new CanvasWindow("Ball Path Tracker", 1440, 800);
        CreateLayout layout = new CreateLayout(canvas);

        canvas.pause(300);

        double angleInDegrees = 45;
        double ballInitialX = canvas.getWidth() * 5.0 / 9;;
        double ballInitialY = 2/3.0 * 400;
        double maxXBound = canvas.getWidth();
        double maxYBound = canvas.getHeight();

        sideBall = new SideBall(ballInitialX, ballInitialY, exitVelocity, angle, maxXBound, maxYBound / 2);
        topBall = new TopBall(396.25,710, 10 , 40);
        strikeZoneBall= new StrikeZoneBall(960,475);

        addStrikeBall(this,strikeZoneBall);
        canvas.animate(this::moveBalls);

    }

    public void getInput() {
        checkLocation();
        checkVelocity();
        checkAngle();

    }

    public void checkVelocity() {
        System.out.println("Enter a velocity (40-120)");
        exitVelocity = scan.nextDouble();

        if(exitVelocity < 40 || exitVelocity > 120) {
            System.out.println("Illegal velocity");
            System.out.println("Enter a velocity");
            exitVelocity = scan.nextDouble();
            checkVelocity();
        }
    }

    public void checkAngle() {
        System.out.println("Enter an angle (-20-60)");
        angle = scan.nextDouble();

        if (angle < 0 || angle > 90) {
            System.out.println("Illegal angle");
            System.out.println("Enter an angle (0-90)");
            angle = scan.nextDouble();
            checkAngle();
        }
    }

    public void checkLocation() {
        System.out.println("Enter a pitch location: inside, outside, middle.");
        pitchLocation = scan.next();
        pitchLocation = pitchLocation.toLowerCase();
        System.out.println(pitchLocation);

        List<String> listOfLocations= List.of("inside", "middle", "outside");
        if (!listOfLocations.contains(pitchLocation)) {
            System.out.println("Illegal pitch location");
            System.out.println("Enter a pitch location: inside, outside, middle.");
            pitchLocation = scan.next();
            checkLocation();
        }
    }

    public static void main(String[] args) {
        new BallPathTracker();
    }


    public void makeTopBall() {
        canvas.add(topBall);
    }


    public void moveBalls() {
        moveTopBall();
        moveSideBall();
    }

    public void moveSideBall() {
        double oldX = sideBall.getX();
        double oldY = sideBall.getY();
        sideBall.moveBall(0.15);
        Line tracer = new Line(oldX, oldY, sideBall.getX(), sideBall.getY());
        tracer.setStrokeColor(Color.BLACK);
        canvas.add(tracer);
        canvas.draw();
    }

    public String getPitchLocation() {
        return pitchLocation;
    }

    public void moveTopBall(){
        topBall.moveBall(-.15,800,725,0,150,this);
        Line tracer1 = new Line(400,710 , topBall.getX()+5, topBall.getY()+5);
        tracer1.setStrokeColor(Color.BLACK);
        tracer1.setStrokeWidth(.5);
        canvas.add(tracer1);
        makeTopBall();
        canvas.draw();
    }

    public void addStrikeBall(BallPathTracker game, StrikeZoneBall ball) {
        String pitchLocation = game.getPitchLocation();
        Random rand = new Random();
        double ballYPos = rand.nextInt(540)+200;
        if (ballYPos < 475)
            ballYPos = 485;
        if (pitchLocation.equals("inside")) {
            ball.setCenter(1000, ballYPos);
            canvas.add(ball);
        } else if (pitchLocation.equals("outside")) {
            ball.setCenter(1160, ballYPos);
            canvas.add(ball);
        } else if (pitchLocation.equals("middle")) {
            ball.setCenter(1080, ballYPos);
            canvas.add(ball);
        }
    }

}

