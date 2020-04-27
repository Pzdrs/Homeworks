public class Player {
    // Messenger design
    public String displayName;
    public double health, hunger;
    public boolean isFlying;

    public Player(String displayName, double health, double hunger, boolean isFlying) {
        this.displayName = displayName;
        this.health = health;
        this.hunger = hunger;
        this.isFlying = isFlying;
    }

    public Player(Player player) {
        this.displayName = player.displayName;
        this.health = player.health;
        this.hunger = player.hunger;
        this.isFlying = player.isFlying;
    }

    public String toString() {
        return this.displayName + " has " + this.health + " health and " + this.hunger + " hunger. They " + (this.isFlying ? "are" : "aren't") + " flying.";

    }
}
