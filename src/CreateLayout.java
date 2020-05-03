import comp127graphics.CanvasWindow;
import comp127graphics.Rectangle;

import java.awt.*;

public class CreateLayout {

    private CanvasWindow canvas;
    private double canvasHeight;
    private double canvasWidth;

    /** Creates and displays the visual layout of the canvas
     *
     * @param canvas x position of the Baseball
     */
    public CreateLayout(CanvasWindow canvas) {
        this.canvas = canvas;
        canvasHeight = canvas.getHeight();
        canvasWidth = canvas.getWidth();

        draw();
    }

    /** Draws the layout of the Top View, Side View,
     * and Pitch View
     */
    public void draw() {
        addFieldTopView();
        addPitchView();
        addSideView();
        canvas.draw();
    }

    /** Creates the visual of the
     * Top of The Field
     */
    public void addFieldTopView() {
        new FieldTopView(canvas);
    }


    /** Creates the Visual of the Pitch View by scaling the graphic
     * to the right size and location
     */
    public void addPitchView() {

        double sideHeight = canvasHeight / 2.0;
        double sideWidth = canvasWidth * 4.0 / 9;
        double initialX = canvasWidth - sideWidth;

        new PitchView(initialX, sideHeight, sideWidth, sideHeight, canvas);
    }


    /** Adds teh visual of the side of the field by
     * scaling to the right size and location
     */
    public void addSideView() {
        double sideHeight = canvasHeight / 2.0;
        double sideWidth = canvasWidth * 4.0 / 9;
        double initialX = canvasWidth - sideWidth;
        double initialY = 0;
        new FieldSideView(sideHeight, sideWidth, initialX, initialY, canvas);
    }
}
