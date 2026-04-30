package ch07.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {
        int r = 10;

        Calculator calculator = new Calculator();
        System.out.println("원 면적: " + calculator.areaCircle(r));
        System.out.println(); // 줄바꿈

        Computer computer = new Computer();
        // 오버라이딩된 Computer의 메서드가 호출됩니다.
        System.out.println("원 면적: " + computer.areaCircle(r));
    }
}