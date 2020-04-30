import comp127graphics.CanvasWindow;
import comp127graphics.Rectangle;

import java.awt.*;

public class CreateLayout {

    private CanvasWindow canvas;
    private double canvasHeight;
    private double canvasWidth;
    private FieldTopView fieldTop;
    private FieldSideView fieldSide;
    private PitchView pitchView;

    public CreateLayout(CanvasWindow canvas) {
        this.canvas = canvas;
        canvasHeight = canvas.getHeight();
        canvasWidth = canvas.getWidth();

        draw();
    }
    public void draw() {
        addFieldTopView();
        addPitchView();
        addSideView();
        canvas.draw();
    }

    public void addFieldTopView() {
        fieldTop = new FieldTopView(canvas);
    }

    public void addPitchView() {

        double sideHeight = canvasHeight / 2.0;
        double sideWidth = canvasWidth * 4.0 / 9;
        double initialX = canvasWidth - sideWidth;

        pitchView = new PitchView(initialX, sideHeight, sideWidth, sideHeight, canvas);
        pitchView.makeStrikeZone();
    }

    public void addSideView() {
        double sideHeight = canvasHeight / 2.0;
        double sideWidth = canvasWidth * 4.0 / 9;
        double initialX = canvasWidth - sideWidth;
        double initialY = 0;
        fieldSide = new FieldSideView(sideHeight, sideWidth, initialX, initialY, canvas);
    }
}
