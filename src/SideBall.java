public class SideBall extends Baseball{

    private static final double GRAV = -9.8 * 6 / 4;

    /** Creates a new SideBall Object
     *
     * @param xPos x position of the side ball
     * @param yPos y position of the sideball
     * @param vel velocity of the sideball
     * @param initialAngle angle of the sideball
     * @param maxX max x bound
     * @param maxY max y bound
     */
    public SideBall(double xPos, double yPos, double vel, double initialAngle, double maxX, double maxY){
        super(xPos,yPos,RADIUS,RADIUS);

        this.xPos = xPos;
        this.yPos = yPos;
        this.maxX = maxX;
        this.maxY = maxY;

        double initialAngleRadians = Math.toRadians(initialAngle);
        this.xVel = vel * Math.cos(initialAngleRadians);
        this.yVel = vel * -Math.sin(initialAngleRadians);
    }

    /**Moves the ball by updating the position through checking if the ball is in bounds.
     * The change in the position is influenced by the Pitch location, exit velocity(speed off the bat,
     * and launch angle(angle the bat hits the ball).
     * @param dt the change over time
     */
    public void moveBall(double dt) {
        double newX = xVel * dt + xPos;
        double newY = yVel * dt + yPos;
        if (xPos > 0 && xPos < maxX && yPos > 0 && yPos < maxY) {
            xPos += (xVel * dt);
            yPos += (yVel * dt);
            this.setPosition(newX, newY);
            yVel = yVel - GRAV * dt;
        }
    }
}