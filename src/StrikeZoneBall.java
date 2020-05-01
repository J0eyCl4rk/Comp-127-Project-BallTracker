import comp127graphics.CanvasWindow;

public class StrikeZoneBall extends Baseball {

    /** Creates a Baseball to be added to the strike zone portion of the
     * canvas. This class is a child class of Baseball.
     * @param xPos x position of the ball
     * @param yPos y position of the ball
     */
    public StrikeZoneBall(double xPos, double yPos) {
        super(xPos, yPos, 0, 0);
    }

}
