import comp127graphics.CanvasWindow;

public class BallTest {

    private CanvasWindow canvas;
    private FieldSideView fieldSideView;
    private SideBall ball;

    public BallTest() {
        canvas = new CanvasWindow("ball", 1600, 800);
        fieldSideView = new FieldSideView(canvas);

        ball = new SideBall(0, 1600, 10, 45, canvas);
        while(ball.updatePosition(.1)) {
            ball.updatePosition(.1);
            canvas.pause(100);
            System.out.println(ball.getCenter());
        }
    }

    public static void main(String[] args) {
        new BallTest();
    }


}
