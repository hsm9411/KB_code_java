package ch07.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        // 1. 기본 타이어 장착
        myCar.tire = new Tire();
        myCar.run(); // "회전합니다."

        // 2. 한국 타이어로 교체 (자동 타입 변환: Tire 타입에 HankookTire 객체 대입)
        myCar.tire = new HankookTire();
        myCar.run(); // "한국 타이어가 회전합니다."

        // 3. 금호 타이어로 교체 (자동 타입 변환)
        myCar.tire = new KumhoTire();
        myCar.run(); // "금호 타이어가 회전합니다."
    }
}