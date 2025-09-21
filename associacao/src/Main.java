public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(4453, "Volvo S60");
        Driver driver = new Driver("John", vehicle);

        driver.showInfos();
    }
}