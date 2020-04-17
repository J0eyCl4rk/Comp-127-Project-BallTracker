
import comp127graphics.CanvasWindow;
import comp127graphics.FontStyle;
import comp127graphics.GraphicsText;


public class BallPathTracker {

    private CanvasWindow canvas;
    private FieldTopView fieldTop;

    public BallPathTracker(){
        canvas= new CanvasWindow("Ball Path Tracker",800,800);
        fieldTop= new FieldTopView(canvas);
        makeFieldTop();


    }

    public static void main(String[] args){
        new BallPathTracker();
    }

    public void makeFieldTop(){
        fieldTop.makeOutField();
        fieldTop.makeInfield();
        fieldTop.bleachers();

    }
}
