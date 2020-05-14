package sample;

public class Model {
    private View view;
    private double aX, aY, bX, bY;
    private Point a, b;
    private Vector v;

    public Model(Controller controller, double aX, double aY, double bX, double bY) {
        this.view = new View(this, controller);

        this.aX = aX;
        this.aY = aY;
        this.bX = bX;
        this.bY = bY;

        this.a = new Point(aX, aY);
        this.b = new Point(bX, bY);
        this.v = new Vector(a, b);

        view.both();
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Vector getV() {
        return v;
    }
}
