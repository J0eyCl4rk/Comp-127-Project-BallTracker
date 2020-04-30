import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.Polygon;
import comp127graphics.Rectangle;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;

public class FieldSideView {

    private double height;
    private double width;
    private double initialX;
    private double initialY;
    private CanvasWindow canvas;
    private List<GraphicsObject> listOfGraphics = new ArrayList<>();

    public FieldSideView(double height, double width, double intialX, double initialY, CanvasWindow canvas) {
        this.canvas = canvas;
        this.height = height;
        this.width = width;
        initialX = intialX;
        this.initialY = initialY;
        draw();

    }

    private void draw() {
        createSky();
        createBleachers();
        createMound();
        createGrass();
        drawBorder();
        addToCanvas(listOfGraphics);


    }

    private void drawBorder() {
        Rectangle border = new Rectangle(initialX, initialY, width, height);
        border.setStrokeColor(Color.BLACK);
        listOfGraphics.add(border);
    }

    private void createBleachers() {
        double y1 = height * 2.0 / 3;
        double y2 = height * .6;
        double y3 = height * .55;
        double x1 = .75 * width + initialX;
        double x2 = width + initialX;

        List<Point> points = List.of(
                new Point(x1, y1),
                new Point(x1, y2),
                new Point(x2, y3),
                new Point(x2, y1)
        );
        Path bleacher = new Path(points);
        bleacher.setFilled(true);
        bleacher.setFillColor(Color.darkGray);
        listOfGraphics.add(bleacher);
    }

    private void createMound() {
        double x = width * .125 + initialX;
        double y = height * .99 + initialY;

        Arc mound = new Arc(x, 2 / 3.0 * height, width / 15, y, 60, 60);
        mound.setStrokeColor(new Color(128, 64, 0));
        mound.setStrokeWidth(18);
        listOfGraphics.add(mound);
    }

    private void createSky(){
        Rectangle sky= new Rectangle(initialX, initialY, width,height * 2.0 / 3);
        sky.setFillColor(new Color(51,204,255));
        sky.setStrokeColor(new Color(51,204,255));
        listOfGraphics.add(sky);
    }

    public void createGrass(){
        Rectangle grass= new Rectangle(initialX,height * 2.0 / 3, width, height * 1/3);
        grass.setStrokeColor(new Color(0,153,0));
        grass.setFillColor(new Color(0,153,0));
        listOfGraphics.add(grass);
    }



    private void addToCanvas(List<GraphicsObject> list) {
        for (GraphicsObject object : list) {
            canvas.add(object);
        }
    }
}

