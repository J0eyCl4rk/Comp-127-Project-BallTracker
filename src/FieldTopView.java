import comp127graphics.*;
import comp127graphics.Rectangle;

import java.awt.*;


public class FieldTopView {

    private CanvasWindow canvas;
    private static final Color infColor = new Color(158,100,55);
    private static final Color outColor = new Color(11,158,1);



    public FieldTopView(CanvasWindow canvas){
        this.canvas=canvas;


    }

    public void makeOutField(){
        Rectangle out= new Rectangle(0,200,800,700);
        out.setFillColor(outColor);
        out.setStrokeColor(outColor);
        canvas.add(out);

    }

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

    public void bleachers(){

        Line leftBleacher= new Line(0,255,185,155);
        leftBleacher.setStrokeWidth(95);
        leftBleacher.setStrokeColor(Color.GRAY);
        canvas.add(leftBleacher);

        Line rightBleacher= new Line(800,255,600,146);
        rightBleacher.setStrokeWidth(95);
        rightBleacher.setStrokeColor(Color.GRAY);
        canvas.add(rightBleacher);

        Rectangle centerBleacher=new Rectangle(200,80,400,120);
        centerBleacher.setFillColor(Color.GRAY);
        canvas.add(centerBleacher);
    }
}
