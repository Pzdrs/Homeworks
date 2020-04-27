public class SingletonDesign2 {
    private static SingletonDesign2 instance;

    private SingletonDesign2() {

    }

    public static SingletonDesign2 getInstance() {
        if (instance == null)
            instance = new SingletonDesign2();
        return instance;
    }

    public void foo() {
        System.out.println("Singleton design pattern #2");
    }
}
