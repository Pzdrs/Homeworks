public class App {
    private String name, creator;
    private double size;

    public App(String name, String creator, double size) {
        this.name = name;
        this.creator = creator;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }

    public double getSize() {
        return size;
    }
}
