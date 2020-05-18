package sample;

public class Model {
    private Line line, optionalLine;
    private Point a, b;

    public Model(Controller controller, Point a, Point b) {
        this.a = a;
        this.b = b;

        this.line = new Line(a, b);

        controller.getGeneral().setText(line.getGeneralExpression());
        controller.getParametric().setText(line.getParametricExpression());
    }

    public Model(Controller controller, Point a, Point b, Line optionalLine) {
        this.a = a;
        this.b = b;
        this.optionalLine = optionalLine;

        this.line = new Line(a, b);

        controller.getGeneral().setText(line.getGeneralExpression());
        controller.getParametric().setText(line.getParametricExpression());
        controller.getRelativePosition().setText(line.getRelativePosition(optionalLine));
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }
}
