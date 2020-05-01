import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.Rectangle;

import java.awt.*;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;


public class FieldTopView {

    private CanvasWindow canvas;
    private static final Color infColor = new Color(158,100,55);
    private static final Color outColor = new Color(11,158,1);


    /** Creates a new FieldTopView Object that shows the field from
     * a looking down view.
      * @param canvas the canvas the FieldTopView will be added to
     */
    public FieldTopView(CanvasWindow canvas){
        this.canvas=canvas;
        drawField();

    }

    /**Creates the Rectangle that represents the outfield grass
     * and adds it to the canvas.
     */
    public void makeOutField(){
        Rectangle out= new Rectangle(0,canvas.getHeight() * 1.0 / 4.0,800,700);
        out.setFillColor(outColor);
        out.setStrokeColor(outColor);
        canvas.add(out);

    }

    /**
     * Creates the infield including the dirt line,
     * infield grass line, two white foul lines,
     * the pithers mound, and home plate and adds
     * them to the canvas.
     */
    public void makeInfield(){
        double x1=400;
        double y1=550;
        double x2=401;
        double y2=551;

        Line infLine= new Line(x1,y1,x2,y2);
        infLine.setStrokeWidth(250);
        infLine.setStrokeColor(infColor);
        canvas.add(infLine);

        Line baselineLeft= new Line(0,310,401,715);
        baselineLeft.setStrokeWidth(2);
        baselineLeft.setStrokeColor(Color.white);
        canvas.add(baselineLeft);

        Line baselineRight= new Line(803,313,402,715);
        baselineRight.setStrokeWidth(2);
        baselineRight.setStrokeColor(Color.white);
        canvas.add(baselineRight);

        Line infGrass= new Line(398,552,403,557);
        infGrass.setStrokeColor(outColor);
        infGrass.setStrokeWidth(190);
        canvas.add(infGrass);

        Ellipse pitch= new Ellipse(375,525,50,50);
        pitch.setFillColor(infColor);
        pitch.setStrokeColor(infColor);
        canvas.add(pitch);

        Line pitchMound= new Line(397.5,548,403.5,548);
        pitchMound.setStrokeColor(Color.white);
        pitchMound.setStrokeWidth(2);
        canvas.add(pitchMound);

        Rectangle home= new Rectangle(398.25,713,7,7);
        home.setStrokeColor(Color.white);
        home.setFillColor(Color.white);
        canvas.add(home);
    }

    /**
     * Creates the bleachers and adds them to the canvas
     */
    public void bleachers(){

        List<Point> bleacherPoints = List.of(
                new Point(800, 325),
                new Point(800,200),
                new Point(600, 80),
                new Point(200, 80),
                new Point(0, 200),
                new Point(0, 325),
                new Point(200, 200),
                new Point(600, 200)
        );

        Path bleachers = new Path(bleacherPoints);
        bleachers.setFillColor(Color.gray);
        canvas.add(bleachers);
    }

    /**Calls the makeOutField, makeInfield, and bleachers method,
     * creating the graphics objects and adding them to the canvas.
     */
    public void drawField() {
        makeOutField();
        makeInfield();
        bleachers();
    }
}
