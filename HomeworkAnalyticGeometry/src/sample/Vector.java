package sample;

public class Vector {
    private Point p1, p2, normal, directional;

    public Vector(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;

        this.directional = new Point(p2.getX() - p1.getX(), p2.getY() - p1.getY());
        this.normal = new Point(- (p2.getY() - p1.getY()), p2.getX() - p1.getX());
    }

    public Point getNormal() {
        return normal;
    }

    public Point getDirectional() {
        return directional;
    }
}
