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
    private Scanner scan = new Scanner(System.in);
    CreateLayout layout;

    /** Creates a Ball Path Tracker Object that asks the user to input the parameters,
     * draws the visual layout of a baseball field, adds the balls, and animates the
     * movement of the balls
     */

    public BallPathTracker() {

        getInput();

        canvas = new CanvasWindow("Ball Path Tracker", 1440, 800);
        layout = new CreateLayout(canvas);
        canvas.pause(300);

        addBalls();

        canvas.animate(this::moveBalls);
    }

    /** Creates objects of SideBall, TopBall, and StrikeZoneBall,
     * which are the visual representation of the balls, and sets
     * the initial X and Y location and bounds
     */

    public void addBalls() {
        double ballInitialX = canvas.getWidth() * 5.0 / 9;;
        double ballInitialY = 2/3.0 * canvas.getHeight() / 2 - 10;
        double maxXBound = canvas.getWidth();
        double maxYBound = canvas.getHeight() / 3.0;

        sideBall = new SideBall(ballInitialX, ballInitialY , exitVelocity, angle, maxXBound, maxYBound);
        topBall = new TopBall(396.25,710, exitVelocity , angle);
        strikeZoneBall= new StrikeZoneBall(960,475);
        addStrikeZoneBall();
    }

    /** Calls checkLocation(), checkVelocity(), and checkAngle() which
     * asks the user for inputs for location, velocity, and angle.
     */

    public void getInput() {
        checkLocation();
        checkVelocity();
        checkAngle();
    }

    /** Asks the user to input an initial velocity for the balls,
     * and then checks to see if the velocity falls withing the legal bounds
     * If the velocity is illegal, it prompts the use to enter a new velocity.
     */

    public void checkVelocity() {
        System.out.println("Enter a velocity (40-120)");
        exitVelocity = scan.nextDouble();
        System.out.println("--------------------");

        if(exitVelocity < 40 || exitVelocity > 120) {
            System.out.println("Illegal velocity");
            checkVelocity();
        }
    }

    /** Asks the user to input an initial angle for the ball,
     * and then checks to see if the angle falls within the correct bounds.
     * If the angle does not, it prompts the use to enter a new angle.
     */

    public void checkAngle() {
        System.out.println("Enter an angle (0-60)");
        angle = scan.nextDouble();
        System.out.println("--------------------");

        if (angle < 0 || angle > 60) {
            System.out.println("Illegal angle");
            checkAngle();
        }
    }

    /** Asks the user to enter a location (inside, outside, middle)
     * and then checks to see if the location entered was valid
     */
    public void checkLocation() {
        System.out.println("Enter a pitch location: inside, outside, middle.");
        pitchLocation = scan.next().toLowerCase();
        System.out.println("--------------------");

        List<String> listOfLocations= List.of("inside", "middle", "outside");
        if (!listOfLocations.contains(pitchLocation)) {
            System.out.println("Illegal pitch location");
            checkLocation();
        }
    }

    /** main method that creates and runs the Ball Path Tracker
     */
    public static void main(String[] args) {
        new BallPathTracker();
    }

    /** Adds the topBall, which is the visual representation of the ball from
     * the top view, to the canvas.
     */

    public void makeTopBall() {
        canvas.add(topBall);
    }

    /** Moves both the balls by calling methods that deal with
     * the individual movement of each of the balls
     */

    public void moveBalls() {
        moveTopBall();
        moveSideBall();
    }

    /** Moves the visual representation of the ball from the side view
     * and traces the tail which shows the path of the ball.
     */

    public void moveSideBall() {
        double oldX = sideBall.getX();
        double oldY = sideBall.getY();
        sideBall.moveBall(0.15);
        Line tracer = new Line(oldX, oldY, sideBall.getX(), sideBall.getY());
        tracer.setStrokeColor(Color.BLACK);
        canvas.add(tracer);
        canvas.draw();
    }

    /** Moves the visual representation of the ball from the top view
     * and adds a tail showing the path.
     */

    public void moveTopBall(){
        double oldX = topBall.getCenter().getX();
        double oldY = topBall.getCenter().getY();
        topBall.moveBall(-.15, pitchLocation);
        Line tracer = new Line(oldX, oldY, topBall.getCenter().getX(), topBall.getCenter().getY());
        tracer.setStrokeColor(Color.BLACK);
        canvas.add(tracer);
        makeTopBall();
        canvas.draw();
    }

    /** Adds the visual ball to the visual representation of the Strike zone
     */

    public void addStrikeZoneBall() {
        canvas.add(strikeZoneBall.uopdatePosition(pitchLocation));
    }
}