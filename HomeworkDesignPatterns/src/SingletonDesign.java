public class SingletonDesign {
    private static SingletonDesign instance = new SingletonDesign();

    private SingletonDesign() {
    }

    public static SingletonDesign getInstance() {
        return instance;
    }

    public void foo() {
        System.out.println("Singleton design pattern");
    }
}
