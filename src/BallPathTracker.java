
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
    private String pitchLocation;
    private PitchView pitchView;
    private Random random = new Random();
    private CreateLayout layout;

    public BallPathTracker() {
        canvas = new CanvasWindow("Ball Path Tracker", 1440, 800);
        layout = new CreateLayout(canvas);


//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter a pitch location: inside, outside, middle.");
//        pitchLocation = scan.next();


        topBall = new TopBall(398.25,713, 100, 100);
        makeBall();

        canvas.pause(300);

        double angleInDegrees = 45;
        double ballInitialX = canvas.getWidth() * 5.0 / 9;;
        double ballInitialY = 2/3.0 * 400;
        double maxXBound = canvas.getWidth();
        double maxYBound = canvas.getHeight();

        sideBall = new SideBall(ballInitialX, ballInitialY, 40, angleInDegrees, maxXBound, maxYBound);

        canvas.animate(this::moveBalls);

}

    public static void main(String[] args) {
        new BallPathTracker();
    }


    public void makeBall() {
        canvas.add(topBall);
    }


    public void moveBalls() {
        topBall.moveBall(.1, 800,700, 0, 0, this);
        moveSideBall();


    }

    public void moveSideBall() {
        double oldX = sideBall.getX();
        double oldY = sideBall.getY();
        sideBall.moveBall(0.1);
        Line tracer = new Line(oldX, oldY, sideBall.getX(), sideBall.getY());
        tracer.setStrokeColor(Color.BLACK);
        canvas.add(tracer);
        canvas.draw();
    }

    public String getPitchLocation() {
        return pitchLocation;
    }
}

