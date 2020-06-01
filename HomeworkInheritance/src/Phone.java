import java.util.ArrayList;
import java.util.List;

public class Phone {
    private String name;
    private double batteryLife;
    private List<Contact> contacts;

    public Phone(String name, double batteryLife) {
        this.name = name;
        this.batteryLife = batteryLife;
        this.contacts = new ArrayList<>();
    }

    public Phone createContact(Contact contact) {
        contacts.add(contact);
        return this;
    }

    public Phone removeContact(Contact contact) {
        contacts.remove(contact);
        return this;
    }

    public void info() {
        System.out.println("------------------------------------------");
        System.out.println("INFO O MOBILU");
        System.out.println("Název: " + name);
        System.out.println("Počet kontaktů: " + contacts.size());
        System.out.println("------------------------------------------");
    }

    public String getName() {
        return name;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
