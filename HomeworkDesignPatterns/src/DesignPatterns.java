public class DesignPatterns {
    public static void main(String[] args) {
        //SingletonDesign foo = new SingletonDesign(); - nedovolí mi vytvořit instanci
        SingletonDesign singletonDesign = SingletonDesign.getInstance();
        SingletonDesign2 singletonDesign2 = SingletonDesign2.getInstance();

        singletonDesign.foo();
        singletonDesign2.foo();

        Player player = new Player("Pzdrs", 20d, 20d, false);
        System.out.println(player.toString());

        Player pzdrsClone = new Player(player);
        System.out.println(pzdrsClone.toString());
    }
}
