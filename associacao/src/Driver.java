public class Driver {
    private String driverName;
    private Vehicle vehicle;

    Driver (String driverName, Vehicle vehicle) {
        this.driverName = driverName;
        this.vehicle = vehicle;
    }

    public void showInfos() {
        System.out.println("Driver Name: " + driverName);
        System.out.println("Car Model: " + vehicle.getModel());
        System.out.println("Car ID: " + vehicle.getId());
    }
}
