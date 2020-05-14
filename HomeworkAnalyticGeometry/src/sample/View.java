package sample;

public class View {
    private Model model;
    private Controller controller;

    public View(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;
    }

    public void both() {
        parametric();
        general();
    }

    public void parametric() {
        controller.getParametric().setText("x = " + model.getA().getX() + " + " + model.getV().getDirectional().getX() + "t\ny = " + model.getA().getY() + " + " + model.getV().getDirectional().getY() + "t");
    }

    public void general() {
        controller.getGeneral().setText(model.getV().getNormal().getX() + "x + " + model.getV().getNormal().getY() + "y + " + -(model.getV().getNormal().getX() * model.getA().getX() + model.getV().getNormal().getY() * model.getA().getY()) + " = 0");
    }
}
