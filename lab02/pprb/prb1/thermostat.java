package lab02.pprb.prb1;

public class Thermostat {
    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0;

    public Thermostat(String location, int startTemp) {
        this.location = location;
        this.temperature = (startTemp >= MIN && startTemp <= MAX) ? startTemp : 22;
        activeCount++;
    }

    public void raise() {
        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println(location + ": Already at maximum (30)");
        }
    }

    public void lower() {
        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println(location + ": Already at minimum (16)");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public static int getActiveCount() {
        return activeCount;
    }

    public static void main(String[] args) {
        Thermostat thermostat1 = new Thermostat("Living Room", 22);
        Thermostat thermostat2 = new Thermostat("Bedroom", 25);

        for (int i = 0; i < 10; i++) {
            thermostat1.raise();
            System.out.println(thermostat1.location + " Temperature: " + thermostat1.getTemperature());
        }

        for (int i = 0; i < 20; i++) {
            thermostat2.lower();
            System.out.println(thermostat2.location + " Temperature: " + thermostat2.getTemperature());
        }

        System.out.println("Active count: " + Thermostat.getActiveCount());
    }
}
