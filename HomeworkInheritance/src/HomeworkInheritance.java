public class HomeworkInheritance {
    public static void main(String[] args) {
        Phone iphone = new Phone("iPhone 5", 12);
        iphone.createContact(new Contact("Pacros", "1234567"));
        Phone samsung = new Phone("Samsung Galaxy 5", 16);
        SmartPhone iphoneSmart = new SmartPhone("iPhone X", 48, "iphoneOS");
        SmartPhone samsungSmart = new SmartPhone("Samsung Galaxy S10", 50, "galaxyOS");
        samsungSmart
                .createContact(new Contact("Jardosn", "13246546"))
                .createContact(new Contact("Bosko", "1231645456"));
        iphoneSmart
                .installApplication(new App("Instagram", "Instagram, a.s", 5))
                .installApplication(new App("Messenger", "Facebook, Inc", 10));

        iphone.info();
        samsung.info();
        iphoneSmart.info();
        samsungSmart.info();
    }
}
