public class ParkingLot {
    private int twoWheelers;
    private int fourWheelers;
    private final int twoCap;
    private final int fourCap;
    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
        this.twoWheelers = 0;
        this.fourWheelers = 0;
    }

    public void park(String type) {
        if ("two".equalsIgnoreCase(type)) {
            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Parked two-wheeler");
            } else {
                System.out.println("Full");
            }
        } else if ("four".equalsIgnoreCase(type)) {
            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Parked four-wheeler");
            } else {
                System.out.println("Full");
            }
        } else {
            System.out.println("Invalid vehicle type");
        }
    }

    public void leave(String type) {
        if ("two".equalsIgnoreCase(type)) {
            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("Two-wheeler left");
            } else {
                System.out.println("No two-wheeler to leave");
            }
        } else if ("four".equalsIgnoreCase(type)) {
            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("Four-wheeler left");
            } else {
                System.out.println("No four-wheeler to leave");
            }
        } else {
            System.out.println("Invalid vehicle type");
        }
    }

    public int getTwoWheelers() {
        return twoWheelers;
    }

    public int getFourWheelers() {
        return fourWheelers;
    }

    public static long getRevenue() {
        return revenue;
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2, 1);

        lot.park("two");   // parked
        lot.park("four");  // parked
        lot.park("two");   // parked
        lot.park("two");   // Full
        lot.leave("two");  // leaves one two-wheeler
        lot.park("two");   // parked again
        lot.park("four");  // Full because four-wheeler section already full
        lot.leave("four"); // leaves the one four-wheeler
        lot.park("four");  // parked again
        lot.leave("four"); // leaves one four-wheeler

        System.out.println("Final two-wheelers: " + lot.getTwoWheelers());
        System.out.println("Final four-wheelers: " + lot.getFourWheelers());
        System.out.println("Final revenue: " + ParkingLot.getRevenue());
    }
}

