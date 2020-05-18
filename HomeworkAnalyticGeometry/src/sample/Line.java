package sample;

public class Line {
    private Point a, b;
    private Vector v;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;

        this.v = new Vector(a, b);
    }

    public String getRelativePosition(Line line) {
        double x = (line.v.getNormal().getY() * (v.getNormal().getX() * a.getX() + v.getNormal().getY() * a.getY()) - v.getNormal().getY() * (line.v.getNormal().getX() * line.a.getX() + line.v.getNormal().getY() * line.a.getY())) /
                (v.getNormal().getX() * line.v.getNormal().getY() - v.getNormal().getY() * line.v.getNormal().getX());
        double y = (v.getNormal().getX() * (line.v.getNormal().getX() * line.a.getX() + line.v.getNormal().getY() * line.a.getY()) - line.v.getNormal().getX() * (v.getNormal().getX() * a.getX() + v.getNormal().getY() * a.getY())) /
                (v.getNormal().getX() * line.v.getNormal().getY() - v.getNormal().getY() * line.v.getNormal().getX());


        if (Double.isNaN(x) && Double.isNaN(y)) {
            return "Přímky jsou totožné\nNekonečno společných bodů";
        } else if (Double.isFinite(x) && Double.isFinite(y)) {
            return "Přímky jsou " + (isPerpendicular(line) ? "na sebe kolmé" : "různoběžné") + "\nJeden společný bod\n(" + String.format("%.02f", x) + ", " + String.format("%.02f", y) + ")";
        } else {
            return "Přímky jsou rovnoběžné\nŽádné společné body";
        }
    }

    public boolean isPerpendicular(Line line) {
        return v.getNormal().getX() * line.v.getNormal().getX() + v.getNormal().getY() * line.v.getNormal().getY() == 0;
    }

    public String getGeneralExpression() {
        return v.getNormal().getX() + "x + " + v.getNormal().getY() + "y + " + -(v.getNormal().getX() * a.getX() + v.getNormal().getY() * a.getY()) + " = 0";
    }

    public String getParametricExpression() {
        return "x = " + a.getX() + " + " + v.getDirectional().getX() + "t\ny = " + a.getY() + " + " + v.getDirectional().getY() + "t";
    }
}
