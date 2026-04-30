package ch07.sec03.exam02;

// Phone 클래스를 상속받습니다.
public class SmartPhone extends Phone {

    // 자식 클래스의 생성자
    public SmartPhone(String model, String color) {
        // 부모 클래스(Phone)의 생성자를 명시적으로 호출하여 초기화합니다.
        super(model, color);
        System.out.println("SmartPhone(String model, String color) 생성자 실행");
    }
}