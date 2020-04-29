import comp127graphics.CanvasWindow;
import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;
import comp127graphics.Line;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;


public class BallPathTracker {

    private CanvasWindow canvas;
    private FieldTopView fieldTop;
    private FieldSideView fieldSide;
    private TopBall topBall;
    private SideBall sideBall;
    private StrikeZoneBall strikeZoneBall;
    private String pitchLocation;
    private PitchView pitchView;
    private Random random = new Random();
    private CreateLayout layout;

    public BallPathTracker() {
        canvas = new CanvasWindow("Ball Path Tracker", 1440, 800);
        layout = new CreateLayout(canvas);


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a pitch location: inside, outside, middle.");
        pitchLocation = scan.next();


        canvas.pause(300);

        double angleInDegrees = 45;
        double ballInitialX = canvas.getWidth() * 5.0 / 9;;
        double ballInitialY = 2/3.0 * 400;
        double maxXBound = canvas.getWidth();
        double maxYBound = canvas.getHeight();

        sideBall = new SideBall(ballInitialX, ballInitialY, 40, angleInDegrees, maxXBound, maxYBound);
        topBall = new TopBall(396.25,710, 10 , 40);
        strikeZoneBall= new StrikeZoneBall(960,475);

        addStrikeBall(this,strikeZoneBall);
        canvas.animate(this::moveBalls);

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

