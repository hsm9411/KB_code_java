package ch07.sec03.exam02;

public class SmartPhoneExample {
    public static void main(String[] args) {
        // SmartPhone 객체 생성 및 초기화
        SmartPhone myPhone = new SmartPhone("갤럭시 S24", "블랙");

        // 상속받은 필드 접근 확인
        System.out.println("모델: " + myPhone.model);
        System.out.println("색상: " + myPhone.color);
    }
}