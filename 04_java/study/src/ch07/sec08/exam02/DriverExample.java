package ch07.sec08.exam02;

public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        driver.drive(bus);  // 매개변수 다형성: Vehicle vehicle = bus; 처럼 작동

        Taxi taxi = new Taxi();
        driver.drive(taxi); // 매개변수 다형성: Vehicle vehicle = taxi; 처럼 작동
    }
}