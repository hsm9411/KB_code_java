package ch08.sec11.exam02;

import java.util.Scanner;

public class DriverExample {
    public static void main(String[] args) {
//Driver 객체 생성
        Driver driver = new Driver();
//Vehicle 구현 객체 생성
        Bus bus = new Bus();
        Taxi taxi = new Taxi();
//매개값으로 구현 객체 대입(다형성: 실행 결과가 다름)
        driver.drive(bus); // 자동 타입 변환: Bus → Vehicle
        driver.drive(taxi); // 자동 타입 변환: Taxi → Vehicle

        System.out.println("1) 2) 3) 고르세요");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

//        if (num == 1) {
//            Taxi taxi1 = new Taxi();
//            taxi1.run();
//        } else if (num == 2) {
//            Bus bus1 = new Bus();
//            bus1.run();
//        }

        Vehicle cars[] = {
                new Taxi(),
                new Bus(),
                new Truck()
        };

        cars[num - 1].run();

    }
}
