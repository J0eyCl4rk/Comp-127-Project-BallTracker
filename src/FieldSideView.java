import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.Polygon;
import comp127graphics.Rectangle;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;

public class FieldSideView {

    CanvasWindow canvas;
    double height;
    double width;
    List<GraphicsObject> listOfGraphics = new ArrayList<>();

    public FieldSideView(CanvasWindow canvas) {
        this.canvas = canvas;
        this.height = canvas.getHeight();
        this.width = canvas.getWidth();
        draw();

    }

    private void draw() {
        createSky();
        createBleachers();
        createMound();
        createGrass();
        addToCanvas(listOfGraphics);


    }

    private void createBleachers() {
        double y1 = .9 * height-200;
        double x1 = .75 * width;

        List<Point> points = List.of(
                new Point(x1, height-200),
                new Point(width, height-200),
                new Point(width, (y1 *.95)),
                new Point(x1, y1)
        );
        Path bleacher = new Path(points);
        bleacher.setFilled(true);
        bleacher.setFillColor(Color.darkGray);
        listOfGraphics.add(bleacher);
    }

    private void createMound() {
        double x = width * .125;
        double y = height * .99-200;

        Arc mound = new Arc(x, y, width / 10, y, 0, 180);
        mound.setStrokeColor(new Color(128, 64, 0));
        mound.setStrokeWidth(30);
        listOfGraphics.add(mound);
    }

    private void createSky(){
        Rectangle sky= new Rectangle(0,200,800,400);
        sky.setFillColor(new Color(51,204,255));
        sky.setStrokeColor(new Color(51,204,255));
        listOfGraphics.add(sky);
    }

    public void createGrass(){
        Rectangle grass= new Rectangle(0,600,800,200);
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

