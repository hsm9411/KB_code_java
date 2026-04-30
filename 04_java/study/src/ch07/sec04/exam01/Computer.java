package ch07.sec04.exam01;


public class Computer extends Calculator {

    // 부모의 메서드를 재정의(Overriding) 합니다.
    @Override
    public double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        // 부모의 3.14159 대신 Math.PI를 사용하여 정밀도를 높임
        return Math.PI * r * r;
    }
}