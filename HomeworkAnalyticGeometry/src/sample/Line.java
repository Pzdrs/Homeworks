package sample;

public class Line {
    private Point a, b;
    private Vector v;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Line(Point a, Vector v) {
        this.a = a;
        this.v = v;
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
