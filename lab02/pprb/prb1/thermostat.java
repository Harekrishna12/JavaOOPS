package lab02.pprb.prb1;

public class thermostat {
    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0;

    public thermostat(String location, int startTemp) {
        this.location = location;
        this.temperature = (startTemp >= MIN && startTemp <= MAX) ? startTemp : 22;
        activeCount++;
    }

    public void raise() {
        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at maximum (30)");
        }
    }

    public void lower() {
        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at minimum (16)");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public static int getActiveCount() {
        return activeCount;
    }

    public static void main(String[] args) {
        thermostat thermostat1 = new thermostat("Living Room", 22);
        thermostat thermostat2 = new thermostat("Bedroom", 25);

        for (int i = 0; i < 10; i++) {
            thermostat1.raise();
            System.out.println("Temperature: " + thermostat1.getTemperature());
        }

        for (int i = 0; i < 20; i++) {
            thermostat1.lower();
            System.out.println("Temperature: " + thermostat1.getTemperature());
        }

        System.out.println("Active count: " + thermostat.getActiveCount());
    }
}
