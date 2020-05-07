
import java.util.Random;

public class TopBall extends Baseball{

    private static final double GRAV = -9.8 * 3;
    private double initialY;
    private double trackVelo;
    private double trackPos;

    /** Creates a TopBall object that is used on the FieldTopView part of the canvas.
     * This is a child class of the Baseball class.
     * @param xPos x position of the TopBall
     * @param yPos y position of the TopBall
     * @param vel initial velocity of the TopBall
     * @param angle launch angle of the TopBall
     */

    public TopBall(double xPos, double yPos, double vel, double angle) {
        super(xPos,yPos,RADIUS,RADIUS);
        this.initialY = yPos;
        this.xPos= xPos;
        this.yPos= yPos;


        double initialAngleRadians = Math.toRadians(angle);
        this.yVel = 27 / 16.0 * vel * Math.cos(initialAngleRadians);
        this.xVel = 27 / 16.0 * vel * -Math.sin(initialAngleRadians);

        trackVelo = yVel;
        trackPos = yPos;
    }

    /** Moves the ball by updating the position by using a variable to represent the path of the ball (track pos)
     * which tracks the flight if it were seen from the side. As soon as the ball returns to the initial y pos,
     * the path of the ball is stopped
     * The change in the position is influenced by the Pitch location, exit velocity(speed off the bat,
     * and launch angle(angle the bat hits the ball). The pitch location
     * determines which part of the field the ball will be hit to.
     *
     * @param dt change over time
     * @param pitchLocation location of the pitch given by the user
     */
    public void moveBall(double dt, String pitchLocation) {

        if (trackPos <= initialY && yPos > 100) {

            trackVelo = trackVelo - GRAV * dt;
            trackPos += trackVelo * dt;

            switch (pitchLocation) {
                case "inside":
                    xPos += (40 * dt);
                    yPos += (yVel * dt);
                    this.setCenter(xPos, yPos);
                    break;

                case "outside":
                    xPos += (-40 * dt);
                    yPos += (yVel * dt);
                    this.setCenter(xPos, yPos);
                    break;

                case "middle":
                    yPos += yVel * dt;
                    this.setCenter(xPos, yPos);
                    break;
            }
        }
    }
}

