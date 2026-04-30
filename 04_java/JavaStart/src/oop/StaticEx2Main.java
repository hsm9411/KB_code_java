package oop;

public class StaticEx2Main {
    public static void main(String[] args) {
        StaticEx2 s = StaticEx2.getInstance();
        StaticEx2 s2 = StaticEx2.getInstance();
        s.setData(5);
        System.out.println(s.getData());
        System.out.println(s2.getData());
    }
}
