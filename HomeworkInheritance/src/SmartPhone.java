import java.util.ArrayList;
import java.util.List;

public class SmartPhone extends Phone {
    private String osName;
    private List<App> installedApps;

    public SmartPhone(String name, double batteryLife, String osName) {
        super(name, batteryLife);
        this.osName = osName;
        this.installedApps = new ArrayList<>();
    }

    public SmartPhone installApplication(App app) {
        installedApps.add(app);
        return this;
    }

    public SmartPhone uninstallApplication(App app) {
        installedApps.remove(app);
        return this;
    }

    public void info() {
        super.info();
        System.out.println("------------------------------------------");
        System.out.println("POKROČILÉ INFO O MOBILU");
        System.out.println("Název OS: " + osName);
        System.out.println("Aplikace:");
        if (installedApps.isEmpty()) {
            System.out.println("Nejsou nainstalované žádné aplikace");
            return;
        }
        installedApps.forEach(app -> System.out.println(app.getName() + " by " + app.getCreator() + " (" + app.getSize() + "MB)"));
        System.out.println("------------------------------------------");
    }

    public String getOsName() {
        return osName;
    }

    public List<App> getInstalledApps() {
        return installedApps;
    }
}
