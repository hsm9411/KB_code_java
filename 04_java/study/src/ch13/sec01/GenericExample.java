package ch13.sec01;

public class GenericExample {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.content = "Hello";
        String str = box.content;
        System.out.println(str);

        Box<Integer> box1 = new Box<>();
        box1.content = 10;
        Integer integer = box1.content;
        System.out.println(integer);
    }
}
