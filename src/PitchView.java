import comp127graphics.CanvasWindow;
import comp127graphics.Line;

import java.awt.*;
import java.util.Random;

public class PitchView{
    private CanvasWindow canvas;
    private static final Color infColor = new Color(158,100,55);
    private static final Color outColor = new Color(11,158,1);
    private double xPos1= 200;
    private double xPos2= 600;
    private double yPos1=200;
    private double yPos2= 700;
    private double height;
    private double width;
    private TopBall ball;


    /** Creates a PitchView Object that shows the
     * location of the pitch in a strike zone.
     * @param initialX the top left x of the object
     * @param initialY the top left y of the object
     * @param width the width of the canvas
     * @param height the height of the canvas
     * @param canvas the canvas to which the object is added
     */
    public PitchView(double initialX, double initialY, double width, double height, CanvasWindow canvas) {
        this.canvas = canvas;
        xPos1 = .25 * width + initialX;
        xPos2 = .75 * width + initialX;
        yPos1 = .20 * height + initialY;
        yPos2 = 7 / 8.0 * height + initialY;

        this.width = width;
        this.height = height;
    }

    /** Creates the lines used to represent the strikezone
     * and adds them to the canvas
     */
    public void makeStrikeZone(){
        double y = yPos1;
        for(int i=0;i<4;i++) {
            Line strikeLine = new Line(xPos1, y, xPos2-80, y);
            strikeLine.setStrokeWidth(5);
            canvas.add(strikeLine);
            y += 180 / 800.0 * height;
        }
        double x = xPos1;
        for(int i=0;i<4;i++){
            Line strikeLineHorizontal= new Line(x,yPos1,x,yPos2);
            strikeLineHorizontal.setStrokeWidth(5);
            canvas.add(strikeLineHorizontal);
            x +=100 / 800.0 * width;
        }

    }
}
