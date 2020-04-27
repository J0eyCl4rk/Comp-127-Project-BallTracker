import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.Polygon;

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
        createBleachers();
        createMound();
        addToCanvas(listOfGraphics);

    }

    private void createBleachers() {
        double y1 = .9 * height;
        double x1 = .75 * width;

        List<Point> points = List.of(
                new Point(x1, height),
                new Point(width, height),
                new Point(width, y1 *.95),
                new Point(x1, y1)
        );
        Path bleacher = new Path(points);
        bleacher.setFilled(true);
        bleacher.setFillColor(Color.darkGray);
        listOfGraphics.add(bleacher);
    }

    private void createMound() {
        double x = width * .125;
        double y = height * .99;

        Arc mound = new Arc(x, y, width / 10, y, 0, 180);
        mound.setStrokeColor(new Color(128, 64, 0));
        mound.setStrokeWidth(30);
        listOfGraphics.add(mound);
    }




    private void addToCanvas(List<GraphicsObject> list) {
        for (GraphicsObject object : list) {
            canvas.add(object);
        }
    }
}

