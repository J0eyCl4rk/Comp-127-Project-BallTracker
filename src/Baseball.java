import comp127graphics.Ellipse;

import java.awt.*;

public class Baseball extends Ellipse {

    protected double xPos;
    protected double yPos;
    protected double xVel;
    protected double yVel;
    protected static final Color baseballColor= Color.white;
    protected static final Color seamColor= Color.red;
    protected static final double RADIUS= 10;
    protected static final double GRAV=-.98;
    protected Ellipse baseball;

    public Baseball(double xPos, double yPos, double xVel, double yVel) {
        super(xPos, yPos, RADIUS, RADIUS);
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;

        baseball = new Ellipse(xPos, yPos, RADIUS, RADIUS);
        baseball.setFillColor(baseballColor);
        baseball.setStrokeColor(seamColor);
    }
}
