package ch06.sec07.exam01;

public class Car {
    
    String name;
    String color;
    int cost;

    public Car(String name, String color, int cost) {
        this.name = name;
        this.color = color;
        this.cost = cost;
    }
    public static void main(String[] args) {
        Car myCar = new Car("그랜저", "검정", 250);
        //Car myCar = new Car(); //기본 생성자 호출 못함
    }
}