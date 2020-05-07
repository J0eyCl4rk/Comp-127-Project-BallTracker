import java.util.Random;

public class StrikeZoneBall extends Baseball {

    /** Creates a Baseball to be added to the strike zone portion of the
     * canvas. This class is a child class of Baseball.
     * @param xPos x position of the ball
     * @param yPos y position of the ball
     */
    public StrikeZoneBall(double xPos, double yPos) {
        super(xPos, yPos, 0, 0);
        this.setWidthAndHeight(30, 30);
    }

    /** updates the position of the strike zone ball
     *
     * @param pitchLocation pitch location given by the user's input
     * @return StrikeZoneBall at its new updated position
     */
    public StrikeZoneBall uopdatePosition(String pitchLocation) {
        Random rand = new Random();
        double ballYPos = rand.nextInt(540)+200;

        if (ballYPos < 475)
            ballYPos = 485;

        if (pitchLocation.equals("inside")) {
            this.setCenter(1000, ballYPos);
            return this;
        }
        else if (pitchLocation.equals("outside")) {
            this.setCenter(1160, ballYPos);
            return this;
        }
        else {
            this.setCenter(1080, ballYPos);
            return this;
        }
    }
}
